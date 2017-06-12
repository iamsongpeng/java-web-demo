package com.songpeng.demo01.test;

import com.songpeng.demo01.Operation;
import com.songpeng.demo01.OperationFactory;

public class Test01 {
	public static void main(String[] args) {
		Operation oper;
		oper = OperationFactory.createOperate("/");
		oper.set_numberA(2);
		oper.set_numberB(1);
		double result = oper.getResult();
		System.out.println(result);
		
	}
}
