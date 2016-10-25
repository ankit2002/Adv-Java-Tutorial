package de.fh_kiel.annotation_processor;

import com.squareup.javapoet.*;
import de.fh_kiel.annotation.BoilerPlate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by Ankit on 10/23/2016.
 */
@SupportedAnnotationTypes("de.fh_kiel.annotation.BoilerPlate")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BoilerPlateProcessor extends AbstractProcessor {

    private Elements elementUtils;
    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }


    private void generateCode(TypeElement typeElement) throws IOException {

        // get class Name
        final TypeElement superClassName = elementUtils.getTypeElement(typeElement.getQualifiedName());
        final String className = superClassName.getSimpleName().toString().replace("Stub","");

        // first, get all the fields of the anotated class
        final List<FieldSpec> allFields = new ArrayList();
        final List<MethodSpec> allGettersAndSetters = new ArrayList<>();

        for (final Element elemloop:typeElement.getEnclosedElements()){
            if (elemloop.getKind() == ElementKind.FIELD){

                final FieldSpec fieldSpec = FieldSpec.builder(TypeName.get(elemloop.asType()),
                        elemloop.getSimpleName().toString(),elemloop.getModifiers().
                                toArray(new Modifier[elemloop.getModifiers().size()])).build();

                allFields.add(fieldSpec);


                final MethodSpec getter = MethodSpec.methodBuilder((TypeName.BOOLEAN.equals(TypeName.get(elemloop.asType())) ? "is" : "get") +
                        StringUtils.capitalize(elemloop.getSimpleName().toString()))
                        .addModifiers(Modifier.PUBLIC)
                        .returns(TypeName.get(elemloop.asType()))
                        .addStatement("return this.$N",fieldSpec.name)
                        .build();
                allGettersAndSetters.add(getter);


                final MethodSpec setter = MethodSpec.methodBuilder("set" + StringUtils.capitalize(
                        elemloop.getSimpleName().toString()))
                        .addModifiers(Modifier.PUBLIC)
                        .returns(TypeName.VOID)
                        .addParameter(TypeName.get(elemloop.asType()),fieldSpec.name,Modifier.FINAL)
                        .addStatement("this.$N = $N", fieldSpec.name, fieldSpec.name)
                        .build();
                allGettersAndSetters.add(setter);
            }
        }


        final MethodSpec cons1 = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).build();
        final MethodSpec.Builder builder = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);

        for(final  FieldSpec fs:allFields){
            builder.addParameter(fs.type,fs.name,Modifier.FINAL)
                    .addStatement("this.$N = $N", fs.name,fs.name);
        }

        final MethodSpec cons2 = builder.build();

        TypeSpec.Builder typeBuilder = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(Generated.class).addMember("value", "$S", "annotation processor").build())
                .addFields(allFields)
                .addMethod(cons1)
                .addMethod(cons2)
                .addMethods(allGettersAndSetters)
                .addMethod(MethodSpec.methodBuilder("equals").addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .returns(TypeName.BOOLEAN)
                        .addParameter(Object.class, "o", Modifier.FINAL)
                        .beginControlFlow("if (!(o instanceof $N))", className)
                        .addStatement("return false")
                        .endControlFlow()
                        .addStatement("final $N objCurr = ($N) o", className, className)
                        .addStatement("return $T.reflectionEquals(this, objCurr)",
                                EqualsBuilder.class)
                        .build())
                .addMethod(MethodSpec.methodBuilder("hashCode").addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .returns(TypeName.INT)
                        .addStatement("return $T.reflectionHashCode(this)",
                                HashCodeBuilder.class)
                        .build()
                )
                .addMethod(MethodSpec.methodBuilder("toString").addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .returns(String.class)
                        .addStatement("return $T.reflectionToString(this)", ToStringBuilder.class)
                        .build()
                );

        if(typeElement.getInterfaces() != null && !typeElement.getInterfaces().isEmpty()) {

            typeBuilder = typeBuilder.addSuperinterfaces(typeElement.getInterfaces().stream().map(t -> ClassName.bestGuess(t.toString())).collect(toList()));
        }
        if(typeElement.getSuperclass() != null) {
            typeBuilder = typeBuilder.superclass(ClassName.bestGuess(typeElement.getSuperclass().toString().replace("Stub", "")));
        }

        final TypeSpec type = typeBuilder
                .build();

        final PackageElement pkg = elementUtils.getPackageOf(superClassName);
        final JavaFile jf = JavaFile.builder(pkg.getQualifiedName().toString(), type).build();
        jf.writeTo(filer);
    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {

        try {
            for(final Element annotatedElement : roundEnv.getElementsAnnotatedWith(BoilerPlate.class)){
                final TypeElement typeElement = (TypeElement) annotatedElement;
                // call method to generate code
                generateCode(typeElement);
            }
            return true;
        }catch (final IOException ex){
            messager.printMessage(Diagnostic.Kind.ERROR,"Could not write Source Code"+ex.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }


}
