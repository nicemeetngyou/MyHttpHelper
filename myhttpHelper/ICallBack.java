/**
 * 
 */
package com.xlfx.myhttpHelper;

/**
 * @author Administrator
 *
 */
public interface ICallBack {
	void onSuccess(String result);

	void onFailure(int Code,String Result);
}
