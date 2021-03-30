package com.hongchen.demo2.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	private boolean isOk;
}
