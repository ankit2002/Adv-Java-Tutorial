package de.fh_kiel.person.checkmethod;

import java.lang.annotation.*;

/**
 * Created by amit on 30.10.16.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckNull {
    boolean silent() default false;
}
