package com.xlfx.myhttpHelper;

import java.io.IOException;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpProcessor implements IHttpProcessor {
	private OkHttpClient mOkHttpClient;
	// 切换线程
	private Handler mHandler = new Handler(Looper.getMainLooper());

	public OkhttpProcessor(Context context) {
		mOkHttpClient = new OkHttpClient();
	}

	@Override
	public void post(String url, Map<String, Object> params, final ICallBack callback) {
		RequestBody requestBody = appendBody(params);
		Request request = new Request.Builder().url(url).post(requestBody).build();
		mOkHttpClient.newCall(request).enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				if (response.isSuccessful()) {
					final String str = response.body().toString();
					mHandler.post(new Runnable() {

						@Override
						public void run() {
							callback.onSuccess(str);

						}
					});
				} else {

				}
			}

			@Override
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private RequestBody appendBody(Map<String, Object> params) {
		FormBody.Builder body = new FormBody.Builder();
		if (null == params || params.isEmpty()) {
			return body.build();
		}
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			body.add(entry.getKey(), entry.getValue().toString());

		}
		return body.build();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
