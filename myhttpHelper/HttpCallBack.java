/**
 * 
 */
package com.xlfx.myhttpHelper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;

/**
 * @author xlfx
 * @泛型参数 T Result
 */
public abstract class HttpCallBack<T> implements ICallBack {

	/**
	 * 构造函数
	 */
	public HttpCallBack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSuccess(String result) {
		// 将网络访问的得到的数据转换成Json对象
		Gson gson = new Gson();
		// 得到httpcallback后面的泛型参数
		Class<?> clazz = analysisClassinfo(this);
		T objResult = (T) gson.fromJson(result, clazz);
		onSuccess(objResult);
	}

	public abstract void onSuccess(T result);

	// 获取泛型参数
	// 得到httpcallback后面的泛型参数
	private Class<?> analysisClassinfo(Object obj) {

		Type genType = obj.getClass().getGenericSuperclass();
		Type[] actualType = ((ParameterizedType) genType).getActualTypeArguments();
		return (Class<?>) actualType[0];
	}

	@Override
	public void onFailure(int Code, String msg) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
