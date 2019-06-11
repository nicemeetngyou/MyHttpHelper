package com.xlfx.myhttpHelper;

import java.util.Map;

public interface IHttpProcessor {

	//该类具有访问网络的能力
	void post(String url,Map<String,Object> params,ICallBack callback);
	
}
