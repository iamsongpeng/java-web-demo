package com.songpeng.demo02.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.songpeng.demo02.service.AccountService;

public class ActualConsumptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double txtPrice = Double.parseDouble(request.getParameter("txtPrice"));
		double txtNum = Double.parseDouble(request.getParameter("txtNum"));
		String addRange = request.getParameter("addRange");
		AccountService accountService = new AccountService();
		double totalPrices = accountService.actualConsumption(txtPrice, txtNum, addRange);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("应收金额: " + totalPrices);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}