package com.alzain.stcAssessment.util;


import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {

    String Value();
}
