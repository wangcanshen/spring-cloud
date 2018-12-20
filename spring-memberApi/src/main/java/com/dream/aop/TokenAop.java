package com.dream.aop;

import java.lang.annotation.*;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenAop {
	String type();
}
