package com.songpeng.demo01.ext;

import com.songpeng.demo01.Operation;
/*
 * 加法类, 
 * 继承运算类
 */
public class OperationAdd extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		result = super.get_numberA() + super.get_numberB();
		return result;
	}
}
