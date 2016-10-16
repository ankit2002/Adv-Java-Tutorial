package de.fh_kiel.Person;

/**
 * Created by amit on 16.10.16.
 */

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.commons.lang3.AnnotationUtils;
import java.lang.Object.*;

import java.lang.annotation.*;
import java.time.LocalDate;


@Inherited
@Documented
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Boilerplate {


    //public void setUniqueId(long id){
    //  this.id = id;
    //}

    // Getter Method for First Name
     @Getter @Setter String fName();

    // Getter Method for Last Name
     @Getter @Setter String lName();

    // Getter Method for gender
     @Getter @Setter String gen();

    // Getter Method for Age
     @Getter @Setter int getAge();

     @Getter @Setter float workex();

     @Getter @Setter double min_Sal();

     @Getter @Setter float exp();

}

/*
public class  Boilerplate  extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env){ }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) { return true;}

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return null;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() { return null; }

}
*/
