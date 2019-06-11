/**
 * 
 */
package com.xlfx.myhttpHelper;

import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;

/**
 * @author Administrator
 *
 */
public class VolleyProcessor implements IHttpProcessor {

	private static RequestQueue mRequstQueue = null;

	/**
	 * 
	 */
	public VolleyProcessor(Context context) {
		mRequstQueue = Volley.newRequestQueue(context);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void post(String url, Map<String, Object> params, final ICallBack callback) {
		//创建Request
		StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				callback.onSuccess(response);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});
		//将Request添加到Volley的请求队列中
		mRequstQueue.add(stringRequest);
	}

}
