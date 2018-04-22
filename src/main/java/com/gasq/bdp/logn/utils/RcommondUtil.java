package com.gasq.bdp.logn.utils;

import java.util.Random;

public class RcommondUtil {
	/*private static char[] table=new char[62];*/
	private static char[] table=new char[36];
	private static Random rd=new Random();
	static {
    	int m=0;
		for(char i =48;i<=122;i++){
			if((i<=57)/*||(i>=65&&i<=90)*/||(i>=97)){
					table[m]=i;
					m++;
			}
		}
	}
	
	public static String randomString(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<6;i++){
			//sb.append(table[rd.nextInt(62)]);
			sb.append(table[rd.nextInt(36)]);
		}
		return sb.toString();
	}

}
