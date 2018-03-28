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
	 * 操作类的类名
	 * @return
	 */
	String menuName() default "";
	/**
	 * 操作方法的方法名
	 * @return
	 */
	String menuMethod() default "";
	
	/**
	 * 也可以自己定义一个，操作方法对应的操作类型（0--新增，1--修改，2--删除）
	 */
	
}
