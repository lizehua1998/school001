package com.hua.utils;
import java.security.MessageDigest;
//base64 反向解密
//MD5 不可逆加密算法
public class MD5 {
	public static String encrypty(String source){
		MessageDigest md=null;
		StringBuffer sb=null;
		try {
			md = MessageDigest.getInstance("md5");
			byte[] result = md.digest(source.getBytes());//加密了
			sb = new StringBuffer();
			for(byte b:result){
				int num = b & 0xff;
				String str=Integer.toHexString(num);
				if(str.length()==1){
					sb.append("0");
				}
				sb.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString().toUpperCase();
	}
	
}