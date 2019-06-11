/**
 * 网络访问代理类
 */
package com.xlfx.myhttpHelper;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class HttpHelper implements IHttpProcessor {
	// 单例模式
	private static HttpHelper instance;

	// 需要持有一个三方网络框架的实例
	private static IHttpProcessor mHttpProcessor;

	/**
	 * 
	 */
	public HttpHelper() {
		// TODO Auto-generated constructor stub
	}

	// 单例模式
	public static HttpHelper getInstance() {
		synchronized (HttpHelper.class) {

			if (null == instance) {
				instance = new HttpHelper();
			}
		}
		return instance;

	}

	// 初始化三方网络访问框架
	public static void init(IHttpProcessor httpProcessor) {
		mHttpProcessor = httpProcessor;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void post(String url, Map<String, Object> params, ICallBack callback) {
		final String finalURL = appendparams(url, params);

		// 可以使用post()方法，封装出get()方法
		mHttpProcessor.post(url, params, callback);
	}

	private String appendparams(String url, Map<String, Object> params) {
		if (null == params || params.isEmpty()) {
			return url;
		}
		StringBuilder urlBuilder = new StringBuilder();
		if (0 >= urlBuilder.indexOf("?")) {

			urlBuilder.append("?");
		} else if (urlBuilder.toString().endsWith("?")) {
			urlBuilder.append("&");
		}
		for (Map.Entry<String, Object> entry : params.entrySet()) {

			urlBuilder.append("&");
			urlBuilder.append(entry.getKey());
			urlBuilder.append(encode(entry.getValue().toString()));
		}
		// TODO Auto-generated method stub
		return urlBuilder.toString();
	}

	private Object encode(String str) {
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

}
