package cn.edu.cqut.crmservice.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auth {

    boolean value() default true;//若为true，则需要权限控制

    String roles() default "ADMIN";//设置允许访问的角色
}
