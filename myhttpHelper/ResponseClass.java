/**
 * 
 */
package com.xlfx.myhttpHelper;

/**
 * @author Administrator
 *
 */
public class ResponseClass {



	private int mResultcode;
	private String mReason;
	/**
	 * 
	 */
	public ResponseClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the mResultcode
	 */
	public int getResultcode() {
		return mResultcode;
	}

	/**
	 * @param mResultcode the mResultcode to set
	 */
	public void setResultcode(int mResultcode) {
		this.mResultcode = mResultcode;
	}

	/**
	 * @return the mReason
	 */
	public String getReason() {
		return mReason;
	}

	/**
	 * @param mReason the mReason to set
	 */
	public void setReason(String mReason) {
		this.mReason = mReason;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseClass [mResultcode=" + mResultcode + ", mReason=" + mReason + ", getResultcode()="
				+ getResultcode() + ", getReason()=" + getReason() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
