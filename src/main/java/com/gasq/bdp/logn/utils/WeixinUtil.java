package com.gasq.bdp.logn.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gasq.bdp.logn.component.SpringServletContextUtil;
import com.gasq.bdp.logn.message.AccessToken;

/**
 * 微信通用接口工具类
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class WeixinUtil {

	public static Logger log = Logger.getLogger(WeixinUtil.class);

	/**
	 * 获取access_token的接口地址（GET） 限200（次/天）
	 */
	public final static String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String JSTICKET_TOKEN = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={ACCESSTOKEN}&type=jsapi";
	public final static String SIGNATURE = "jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s";
	public final static String OPENID="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	public final static String USERINFO="https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s";
	public final static String ACCESSOPENIDURL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	/**
	 * 企业号
	 */
	public final static String QY_ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";

	/**
	 * 获取access_token对象
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return AccessToken对象
	 */
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;  
        ServletContext servletContext = SpringServletContextUtil.getCx();
        accessToken= (servletContext.getAttribute(ConfigUtil.get("cxt"))!=null)?(AccessToken)servletContext.getAttribute(ConfigUtil.get("cxt")):null;
        if( accessToken!=null&&System.currentTimeMillis()<(accessToken.getGettime()+accessToken.getExpiresIn()*1000-600000L)){
        	return  accessToken; 
        	
        	
        }
		String requestUrl = ACCESS_TOKEN.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
				accessToken.setGettime(System.currentTimeMillis());
				servletContext.setAttribute(ConfigUtil.get("cxt"), accessToken);
			} catch (JSONException e) {
				accessToken = null;
			}
			
		}
		return accessToken;
	}

	/**
	 * 获取企业号access_token对象
	 * @param CorpID 企业号的标识
	 * @param CorpSecret 管理组凭证密钥
	 * @return AccessToken对象
	 */
	public static AccessToken getQyAccessToken(String corpid, String corpsecret) {
		AccessToken accessToken = null;

		String requestUrl = QY_ACCESS_TOKEN.replace("CORPID", corpid).replace("CORPSECRET", corpsecret);
		JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:" + jsonObject.getIntValue("errcode") + "，errmsg:" + jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}


	/**
	 * 获取token值
	 * @return token
	 */
	public static String getToken() {
		AccessToken at = WeixinUtil.getAccessToken(ConstantWeChat.APPID, ConstantWeChat.APPSECRET);
		if (null != at) {
			return at.getToken();
		} else {
			return null;
		}
	}

	/**
	 * 获取企业号token值
	 * @return token
	 */
	public static String getQyToken() {
		AccessToken at = WeixinUtil.getQyAccessToken(ConstantWeChat.CORPID, ConstantWeChat.CORPSECRET);
		if (null != at) {
			return at.getToken();
		} else {
			return null;
		}
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:", e);
		}
		return jsonObject;
	}

	
	/**
	 * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param createTime
	 *            消息创建时间
	 * @return String
	 */
	public static String formatTime(String createTime) {
		// 将微信传入的CreateTime转换成long类型，再乘以1000
		long msgCreateTime = Long.parseLong(createTime) * 1000L;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date(msgCreateTime));
	}

	
	public static String  getJsapiTicket(){
		String token=getAccessToken(ConfigUtil.get("appId"), ConfigUtil.get("appSecret")).getToken();
		String jspurl=JSTICKET_TOKEN.replace("{ACCESSTOKEN}", token);
		JSONObject jsonObject = httpsRequest(jspurl, "GET", null);
		String ticket=null;
		if(jsonObject.get("errmsg").equals("ok")){
			ticket=jsonObject.get("ticket").toString();
		}
		return ticket;
	}
	
	public static String[] getSignature(String url){
		MessageDigest md = null;
		String tmpStr = null;
		String signature=null;
		String noncestr=ConfigUtil.get("token");
		String jsapi_ticket=getJsapiTicket();
		String timestamp=String.valueOf(System.currentTimeMillis()).substring(0,10);

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(String.format(SIGNATURE,jsapi_ticket,noncestr,timestamp,url).getBytes());
			signature = WXUtil.byteToStr(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(signature==null){
			return null;
		}
		return new String[]{signature,noncestr,timestamp};
	}

/*	
	public static String acherc(String rc,HttpSession session){
		session.setAttribute(ConfigUtil.get("recommond"),rc);
		return rc;
		
	}*/
	
	public static String acheOpenId(String code,HttpSession session){
		String openurl=String.format(OPENID,ConfigUtil.get("appId"),ConfigUtil.get("appSecret"),code);
		JSONObject jsonObject =httpsRequest(openurl,"POST",null);
		session.setAttribute("openId",jsonObject.getString("openid"));
		return jsonObject.getString("openid");
	}

	
	public static JSONObject getUserinfo(HttpSession session){
        ServletContext servletContext = SpringServletContextUtil.getCx();
		String userinfo=String.format(USERINFO, getAccessToken(ConfigUtil.get("appId"),ConfigUtil.get("appSecret")).getToken()
				,getOpenId(session));
		JSONObject jsonObject =httpsRequest(userinfo,"POST",null);
		if(jsonObject.get("errcode")!=null){
			String requestUrl = ACCESS_TOKEN.replace("APPID", ConfigUtil.get("appId")).replace("APPSECRET", ConfigUtil.get("appSecret"));
			JSONObject to = httpsRequest(requestUrl, "GET", null);
			// 如果请求成功
			if (null != jsonObject) {
				try {
					AccessToken accessToken = new AccessToken();
					accessToken.setToken(jsonObject.getString("access_token"));
					accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
					accessToken.setGettime(System.currentTimeMillis());
					servletContext.setAttribute(ConfigUtil.get("cxt"), accessToken);
					userinfo=String.format(USERINFO, accessToken.getToken()
							,getOpenId(session));
					jsonObject =httpsRequest(userinfo,"POST",null);
				} catch (JSONException e) {
					System.out.println(" 获取token 失败 ");
				}
				
			}
		}
		return jsonObject;
	}

	public static String getOpenId(HttpSession session){
		return (String) session.getAttribute("openId");
	}
	
	
	public static String accessOpenid(HttpServletRequest request,HttpSession session){
		//http%3A%2F%2Fyx.nmlte.com%2FweChat%2FaccessopenId
		String url=String.format(ACCESSOPENIDURL,ConfigUtil.get("appId")
				,URLEncoder.encode("http://"+ConfigUtil.get("localname")+request.getContextPath()+"/accessopenId") );		
		JSONObject jsonObject =httpsRequest(url,"POST",null);
		String openId=jsonObject.getString("openid");
		session.setAttribute("openid", openId);
		return openId;
	}
	
}