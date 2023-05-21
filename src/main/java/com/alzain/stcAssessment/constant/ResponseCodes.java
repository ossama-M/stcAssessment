package com.alzain.stcAssessment.constant;

import com.alzain.stcAssessment.util.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ResponseCodes {
    @Value(Value = "success")
    public static final int SUCCESS = 200;
    @Value(Value = "CREATED")
    public static final int CREATED = 201;
    @Value(Value = "File Already Exist")
    public static final int ALREADY_EXIST = 300;


    public static String getDesc(int constantValue) {
        String Desc = "";
        Field[] interfaceFields = ResponseCodes.class.getFields();
        for (Field f : interfaceFields) {
            try {
                if (Integer.valueOf(f.get(null).toString()) == constantValue) {
                    Annotation annotation = f.getAnnotation(Value.class);
                    if (annotation instanceof Value) {
                        Value objValue = (Value) annotation;
                        Desc = objValue.Value();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Desc;

    }
}
