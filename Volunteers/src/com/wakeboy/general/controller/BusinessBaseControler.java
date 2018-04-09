package com.wakeboy.general.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author guoyu20160516控制器基类
 */
public abstract class BusinessBaseControler extends BaseControler {

	/**
	 * ThreadLocal确保高并发下每个请求的request，response都是独立的
	 */
	private static ThreadLocal<ServletRequest> currentRequest = new ThreadLocal<ServletRequest>();

	private static ThreadLocal<ServletResponse> currentResponse = new ThreadLocal<ServletResponse>();


	// 当前控制器名称
	protected String controllerName;

	/**
	 * 处理外键值
	 */
	protected String foreignValue;

	// 分页对象

	/**
	 * 文件上传注入
	 */




	/**
	 * 线程安全初始化reque，respose对象 初始化request和response对象
	 * 
	 * @param request
	 * @param response
	 * @date 2016年05月09日
	 * @author add guoy
	 */
	@ModelAttribute
	public void initReqAndRep(HttpServletRequest request,
			HttpServletResponse response) {
		currentRequest.set(request);
		currentResponse.set(response);
	}

	/** 基类公共方法,类似拦截器,所有子类任何方法都会先执行以下方法 */
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		// System.out.println("进入到初始化方法");
	}

	/**
	 * 初始化参数
	 * 
	 * @param para
	 */
	@ModelAttribute
	public void initParams(ModelMap params) {
		// System.out.println("进入到参数的初始化");
	}







	/**
	 * 讲字符串转换成json
	 * 
	 * @param value
	 */
	public void StrtoJson(String value) {
		PrintWriter out = null;
		this.getHttpResponse().setContentType("application/json");
		this.getHttpResponse().setCharacterEncoding("UTF-8");
		try {
			out = this.getHttpResponse().getWriter();
			out.write(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id
	 *            保存完之后返回的主键编号
	 * @param success
	 *            true：成功 false 失败
	 * @param message
	 *            返回消息 {"id";12345678,"result":"success","message":"保存成功"}
	 */
	public void StrtoJson(String id, boolean success, String message) {
		String result = "{\"id\":\"" + id + "\",\"result\":\""
				+ String.valueOf(success == true ? SUCCESS : FAILED) + "\""
				+ ",\"message\":\"" + message + "\"}";
		PrintWriter out = null;
		this.getHttpResponse().setContentType("application/json");
		this.getHttpResponse().setCharacterEncoding("UTF-8");
		try {
			out = this.getHttpResponse().getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 讲list转换成json
	 * 
	 * @return
	 */
	

	public String getForeignValue() {
		return foreignValue;
	}

	public static ThreadLocal<ServletRequest> getCurrentRequest() {
		return currentRequest;
	}
	public HttpServletResponse getHttpResponse() {
		return (HttpServletResponse) currentResponse.get();
	}
	public static void setCurrentRequest(ThreadLocal<ServletRequest> currentRequest) {
		BusinessBaseControler.currentRequest = currentRequest;
	}

	public static ThreadLocal<ServletResponse> getCurrentResponse() {
		return currentResponse;
	}

	public static void setCurrentResponse(ThreadLocal<ServletResponse> currentResponse) {
		BusinessBaseControler.currentResponse = currentResponse;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public void setForeignValue(String foreignValue) {
		this.foreignValue = foreignValue;
	}

}