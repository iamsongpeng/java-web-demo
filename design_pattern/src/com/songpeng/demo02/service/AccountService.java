package com.songpeng.demo02.service;

public class AccountService {

	public double actualConsumption(double txtPrice, double txtNum, String addRange) {
		switch(addRange) {
		case "0":
			return txtPrice * txtNum;
		case "1":
			return txtPrice * txtNum * 0.8;
		case "2":
			return txtPrice * txtNum * 0.7;
		case "3":
			return txtPrice * txtNum * 0.5;
		}
		return 0;
	}

}
