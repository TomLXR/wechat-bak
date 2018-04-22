package com.gasq.bdp.logn.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.service.CodeService;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.utils.ConfigUtil;
import com.gasq.bdp.logn.utils.WeixinUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年1月26日
*/
@Controller
public class RecommendController extends BaseController{
	   private static final int BLACK = 0xFF000000;  
	   private static final int WHITE = 0xFFFFFFFF;
	
	
	@Autowired
	private CodeService codeService;

	@Autowired
	private TUserService  tUserService;
	
	

	
	@RequestMapping(value = "/accessorecomm")

	public String accessorecomm(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod,String code) {
		String openid=WeixinUtil.acheOpenId(code,session);
		if(tUserService.selectUserCountByOpenId(openid.toString())==0){
			return "redirect:gotoregist";
		}
		return "redirect:recomm";
	}	
/*	@RequestMapping(value = "/accessorecomm")
	public String accessorecomm(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod,String code) {
		
		String openid=WeixinUtil.acheOpenId(code,session);
		if(openid!=null&&tUserService.selectUserCountByOpenId(openid.toString())==0){
			return "redirect:gotoregist";
		}
		return "redirect:recomm";
	}*/
	

	
	
	
/*	@RequestMapping(value = "/recomm")
	public String recomm(HttpServletRequest request, ModelMap mmap, RedirectAttributes attr,Model  mod) {
		jsGood (request,"recomm",mod);
		return "recomm";
	}*/
	
	
	
	
	
	
	
	
	
	
	/*
	 * 生成二维码
	 * 
	 */
	
	@RequestMapping(value = "/recommEW",produces = "image/jpeg; charset=utf-8")
	public void recomm(HttpSession session,HttpServletRequest request,HttpServletResponse response,String rc){
		String rs="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ConfigUtil.get("appId")+"&redirect_uri="+URLEncoder.encode("http://"+ConfigUtil.get("localname")+request.getContextPath()+"/accessopenId")+"&response_type=code&scope=snsapi_base&state=gotoregist$$"+rc+"#wechat_redirect";
		System.out.println("---- rc  ------------"+rc);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();//Zxing是Google提供的关于条码  
        Map hints = new HashMap<>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix=null;
		try {
			bitMatrix = multiFormatWriter.encode(rs, BarcodeFormat.QR_CODE, 400, 400,hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//这里是照片的大小  

        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
          for (int y = 0; y < height; y++) {  
            image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);  
          }  
        }   
        
        try {
			if (!ImageIO.write(image, "jpg", response.getOutputStream())) {
			  throw new IOException("Could not write an image of format " + "jpg"+ " to " );  
			}
		} catch (IOException e) {

			e.printStackTrace();
		}  

	}
	
	@RequestMapping(value = "/EWma",produces = "image/jpeg; charset=utf-8")
	public void ewma(HttpSession session,HttpServletRequest request,HttpServletResponse response,String code){


        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();//Zxing是Google提供的关于条码  
        Map hints = new HashMap<>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix=null;
		try {
			bitMatrix = multiFormatWriter.encode(code, BarcodeFormat.QR_CODE, 400, 400,hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//这里是照片的大小  

        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
          for (int y = 0; y < height; y++) {  
            image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);  
          }  
        }   
        
        try {
			if (!ImageIO.write(image, "jpg", response.getOutputStream())) {
			  throw new IOException("Could not write an image of format " + "jpg"+ " to " );  
			}
		} catch (IOException e) {

			e.printStackTrace();
		}  

	}
	
	
	/**
	 * 生成二维码
	 * 
	 */
/*	@RequestMapping(value = "/recommEW",produces = "image/jpeg; charset=utf-8")
	public void recomm(HttpSession session,HttpServletRequest request,HttpServletResponse response,String rc){
		codeService.generateCode(request,response,rc);

	}*/
	
	@RequestMapping(value = "/checkRecom",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> checkRecom(String recommond){
		Map<String, Object> rs=new HashMap<>();

		TUser sup=tUserService.selectUserByCommo(recommond);
		if(sup==null){
			rs.put("ms","推荐码错误");
			
		}else{
			rs.put("ms","");
		}
		return rs;
	}
	

	
	@RequestMapping(value = "/recommn")
	@ResponseBody
	public Map<String, Object> recomm(HttpSession session,String name,String desc,String mobile,String sex){
		Map<String, Object> rs=new HashMap<>();
		//发送短信
		rs.put("ms", "ok");
	return rs;
	}


}
