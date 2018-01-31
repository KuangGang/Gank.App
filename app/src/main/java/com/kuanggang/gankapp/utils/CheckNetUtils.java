package com.kuanggang.gankapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Description: 检测网络链接状态工具
 * @site: <a href="http://www.jiashuangkuaizi.com">jiashuangkuaizi.com</a>
 *        Copyright (C), 2001-2014, jiashuangkuaizi（加双筷子） This program is
 *        protected by copyright laws.
 * @Program_Name: 回家吃饭用户端
 * @Date: 2015年1月21日开始
 * 
 * @author 匡罡
 */
public class CheckNetUtils {

	/**
	 * 检查网络是否畅通
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkNet(Context context) {
		// has network
		ConnectivityManager conn = null;
		try {
			conn = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (conn == null)
			return false;

		NetworkInfo info = conn.getActiveNetworkInfo();
		if (info == null)
			return false;

		boolean available = info.isAvailable();
		if (!available)
			return false;

		return true;
	}

	/**
	 * 判断是不是APN网络
	 * 
	 * @param context
	 * @return
	 */
	private static boolean checkApnNet(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}

	/**
	 * 判断是不是WIFI网络
	 * 
	 * @param context
	 * @return
	 */
	private static boolean checkWifiNet(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null) {
			return networkInfo.isConnected();
		}
		return false;
	}

}
