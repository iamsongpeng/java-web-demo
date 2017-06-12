package com.songpeng.demo01.ext;

import com.songpeng.demo01.Operation;
/*
 * 除法类, 
 * 继承运算类
 */
public class OperationDiv extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		if(super.get_numberB() == 0) {
			throw new RuntimeException("除数不能为0!");
		}
		result = super.get_numberA() / super.get_numberB();
		return result;
	}

}
