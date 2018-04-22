package com.gasq.bdp.logn.service.imp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.service.CodeService;
import com.gasq.bdp.logn.utils.ConfigUtil;
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
@Service
public class CodeServiceImpl implements CodeService {
	public static final int BLACK = 0xFF000000;  
	public static final int WHITE = 0xFFFFFFFF;
	public  void generateCode(HttpServletRequest request,HttpServletResponse response,String rc){
		//String rs="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ConfigUtil.get("appId")+"&redirect_uri="+URLEncoder.encode("http://"+ConfigUtil.get("localname")+request.getContextPath()+"/gotoregist")+"&response_type=code&scope=snsapi_base&state="+rc+"#wechat_redirect";
		String rs=URLEncoder.encode("http://"+ConfigUtil.get("localname")+request.getContextPath()+"/gotoregist")+"&state="+rc;
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
}
