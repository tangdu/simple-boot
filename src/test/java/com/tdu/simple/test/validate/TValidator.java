package com.tdu.simple.test.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorImpl.class)
@Documented
public @interface TValidator {
	String message() default "{constraint.not.matches}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/** 是否为空 **/
	boolean required() default false;

	/** 最大长度 **/
	String maxLength() default "";

	/** 最小长度 **/
	String minLength() default "";

	/** 最小值 **/
	String minValue() default "";

	/** 最大值 **/
	String maxValue() default "";

	/** 正则式匹配 **/
	String pattren() default "";

	/** 在列表中 **/
	String[] list() default "";

	/** 类型 **/
	String type() default "";
}
