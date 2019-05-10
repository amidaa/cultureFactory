package com.first.group.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassWordToHash {

    public String passwordToHash(String password) {
        try {
            //SHA-256哈希加密
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aSrc : src) {
                //把高24位置0，得到8位的byte
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    //如果十六进制的数只有一位，就在前面加一个0填满两位
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
//			System.out.println(stringBuilder.toString());
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
