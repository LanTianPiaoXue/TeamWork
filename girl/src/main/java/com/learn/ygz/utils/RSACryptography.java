package com.learn.ygz.utils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSACryptography { 
   //1024/8 - 11 = 117
    public static final int maxDecryptLength = 117;
    public static final int decryptLength = 128;
//    public static void main(String[] args) throws Exception {  
//        //获取公钥   
//        PublicKey publicKey=getPublicKey(publicKeyString);  
//          
//        //获取私钥   
//        PrivateKey privateKey=getPrivateKey(privateKeyString);        
//          
//        //公钥加密  
//        byte[] encryptedBytes=encrypt(data.getBytes(), publicKey);    
//        System.out.println("加密后："+new String(encryptedBytes));  
//          
//        //私钥解密  
//        byte[] decryptedBytes=decrypt(encryptedBytes, privateKey);        
//        System.out.println("解密后："+new String(decryptedBytes));  
//    }  
      
    //将base64编码后的公钥字符串转成PublicKey实例  
    public static PublicKey getPublicKey(String publicKey) throws Exception{  
        byte[ ] keyBytes=Base64.getDecoder().decode(publicKey.getBytes());  
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");  
        return keyFactory.generatePublic(keySpec);    
    }  
      
    //将base64编码后的私钥字符串转成PrivateKey实例  
    public static PrivateKey getPrivateKey(String privateKey) throws Exception{  
        byte[ ] keyBytes=Base64.getDecoder().decode(privateKey.getBytes());  
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");  
        return keyFactory.generatePrivate(keySpec);  
    }  
      
    //公钥加密  
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception{  
        Cipher cipher=Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        return cipher.doFinal(content);  
    }  
      
    //私钥解密  
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{  
        Cipher cipher=Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        return cipher.doFinal(content);  
    }  
    //生成密钥对  
    public static KeyPair genKeyPair(int keyLength) throws Exception{  
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");  
        keyPairGenerator.initialize(keyLength);        
        return keyPairGenerator.generateKeyPair();  
    }  
    
    public static byte[] decryptSubsectionByPrivateKey(byte[] encryptedData,PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * decryptLength) {
            byte[] cache;
            if(inputLen - offSet > decryptLength) {
                cache = cipher.doFinal(encryptedData, offSet, decryptLength);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public static byte[] encryptSubsectionByPublicKey(byte[] data,PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * maxDecryptLength) {
            byte[] cache;
            if(inputLen - offSet > maxDecryptLength) {
                cache = cipher.doFinal(data, offSet, maxDecryptLength);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }
}  