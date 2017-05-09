package com.zx.demo.demo2;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "062bb08b9a7f3d05e47ac3e533e1a653";
	private static final String geetest_key = "dd2aa4766018d255dc5883a1c20711f2";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}
	
	public static final boolean isnewfailback() {
		return newfailback;
	}

}
