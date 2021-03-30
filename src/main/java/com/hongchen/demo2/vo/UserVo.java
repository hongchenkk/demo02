package com.hongchen.demo2.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2649514979061398356L;

	private String name;
	private Integer age;
	private Boolean sex;
	private String hop;
}
