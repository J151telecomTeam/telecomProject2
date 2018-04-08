package com.telecom.project.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {
	/**
	 * 反回结果
	 * @return
	 */
	String result() default "";
	
	/**
	 * 操作的类型（哪个类）
	 * @return
	 */
	String type() default "";
	/**
	 * 也可以自己定义一个，操作方法对应的操作类型（0--新增，1--修改，2--删除）
	 */
	
}
