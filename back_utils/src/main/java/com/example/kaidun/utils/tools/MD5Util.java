package com.example.kaidun.utils.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {


  public static String encrypt(String source) {
    return encodeMd5(source.getBytes());
  }

  private static String encodeMd5(byte[] source) {
    try {
      return encodeHex(MessageDigest.getInstance("MD5").digest(source));
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

  private static String encodeHex(byte[] bytes) {
    StringBuffer buffer = new StringBuffer(bytes.length * 2);
    for (int i = 0; i < bytes.length; i++) {
      if (((int) bytes[i] & 0xff) < 0x10) {
        buffer.append("0");
      }
      buffer.append(Long.toString((int) bytes[i] & 0xff, 16));
    }
    return buffer.toString();
  }


  // MD5加码。32位
  public static String MD5(String inStr) {
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (Exception e) {
      System.out.println(e.toString());
      e.printStackTrace();
      return "";
    }
    char[] charArray = inStr.toCharArray();
    byte[] byteArray = new byte[charArray.length];

    for (int i = 0; i < charArray.length; i++)
      byteArray[i] = (byte) charArray[i];

    byte[] md5Bytes = md5.digest(byteArray);

    StringBuffer hexValue = new StringBuffer();

    for (int i = 0; i < md5Bytes.length; i++) {
      int val = ((int) md5Bytes[i]) & 0xff;
      if (val < 16)
        hexValue.append("0");
      hexValue.append(Integer.toHexString(val));
    }

    return hexValue.toString();
  }


}