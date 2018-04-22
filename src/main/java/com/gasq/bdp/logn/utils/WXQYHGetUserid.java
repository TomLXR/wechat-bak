package com.gasq.bdp.logn.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gasq.bdp.logn.utils.ConstantWeChat;;

/**
 * 获取企业号用户userid
 * @author lg
 *
 */
public class WXQYHGetUserid {

	public static Logger log = Logger.getLogger(WXQYHGetUserid.class);

	/**
	 * 重定向和最终界面的连接
	 * @param reqUrl
	 * @param resultUrl
	 * @param address
	 * @return
	 */
	public static String getRedirectUrl(String reqUrl, String resultUrl, String address) {
		// 此处可以添加获取持久化的数据，如企业号id等相关信息
		String redirectUrl = "";
		if (resultUrl != null) {
			// TODO 此处把参数"reqUrl"拼接成你自己的URL
			String backUrl = reqUrl + address + "?oauth2url=" + resultUrl;
//			System.out.println("backUrl=" + backUrl);
			redirectUrl = oAuth2Url(ConstantWeChat.CORPID, backUrl);
		}
		return redirectUrl;
	}

	/**
	 * 微信的接口连接
	 * @param corpid
	 * @param redirect_uri
	 * @return
	 */
	private static String oAuth2Url(String corpid, String redirect_uri) {
		try {
			redirect_uri = URLEncoder.encode(redirect_uri, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
				+ corpid
				+ "&redirect_uri="
				+ redirect_uri
				+ "&response_type=code&scope=snsapi_base&state=sunlight#wechat_redirect";
		System.out.println("oauth2Url=" + oauth2Url);
		return oauth2Url;
	}

	/**
	 * 返回userid
	 * @param code
	 * @param agentId
	 * @return
	 */
	public static String getOauth2MeUrl(String code, int agentId) {
		String userid = "";
		String token = WeixinUtil.getQyToken();
		String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=" + token + "&code=" + code + "&agentid=" + agentId;
		JSONObject jsonObject = WeixinUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			System.out.println("返回的用户信息" + jsonObject.toJSONString());
			try {
				userid = jsonObject.getString("UserId");
			} catch (JSONException e) {
				// 获取token失败
				log.error("获取用户userid失败 errcode:" + jsonObject.getIntValue("errcode") + "，errmsg:" + jsonObject.getString("errmsg"));
			}
		}
		return userid;
	}

}
