package com.songpeng.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifecycleFilter implements Filter {
	// 为了使其他方法都可以使用 config 对象
	private FilterConfig filterConfig;
	
    public LifecycleFilter() {
    	System.out.println("-------------------------------");
    	System.out.println("执行 LifecycleFilter 的构造方法");
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("-------------------------------");
    	System.out.println("执行 LifecycleFilter 的初始化方法");
    	this.filterConfig = fConfig;
    	System.out.println("初始化参数值：" + fConfig.getInitParameter("encoding"));
    }
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-------------------------------");
		System.out.println("执行过滤器 LifecycleFilter");
		String value = filterConfig.getInitParameter("encoding");
		System.out.println("拦截方法，初始化参数值：" + value);
		// 放行
		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("-------------------------------");
		System.out.println("执行 LifecycleFilter 的销毁方法");
	}

}
