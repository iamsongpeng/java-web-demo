package com.songpeng.demo01;

import com.songpeng.demo01.ext.OperationAdd;
import com.songpeng.demo01.ext.OperationDiv;
import com.songpeng.demo01.ext.OperationMul;
import com.songpeng.demo01.ext.OperationSub;

public class OperationFactory {
	public static Operation createOperate(String operate) {
		Operation oper = null;
		switch(operate) {
		case "+":
			oper = new OperationAdd();
			break;
		case "-":
			oper = new OperationSub();
			break;
		case "*":
			oper = new OperationMul();
			break;
		case "/":
			oper = new OperationDiv();
			break;
		}
		return oper;
	}
}
