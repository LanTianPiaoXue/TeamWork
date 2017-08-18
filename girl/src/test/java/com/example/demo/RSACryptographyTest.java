package com.example.demo;

import com.learn.ygz.utils.RSACryptography;
import com.learn.ygz.utils.TestUtil;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSACryptographyTest {

	public static PublicKey publicKey = null;
	public static PrivateKey privateKey = null;

	static{
		KeyPair keyPair = null;
		try {
			keyPair = RSACryptography.genKeyPair(1024);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取公钥
		 publicKey = keyPair.getPublic();

		// 获取私钥
		 privateKey = keyPair.getPrivate();

	}

	@Test
	public void testSuSectionEncryptNDecrypt() throws Exception {
		// 获取公钥
//		PublicKey publicKey = RSACryptography.getPublicKey(publicKeyString);
//		// 获取私钥
//		PrivateKey privateKey = RSACryptography.getPrivateKey(privateKeyString);
//		//4096
//		KeyPair keyPair = RSACryptography.genKeyPair(2048);
//		// 获取公钥
//		PublicKey publicKey = keyPair.getPublic();
//		// 获取私钥
//		PrivateKey privateKey = keyPair.getPrivate();	
		String orderExt = TestUtil.getXml("logback.xml").trim();
		
		long startTime0 = System.currentTimeMillis();
		// 公钥加密
		byte[] encryptedBytes = RSACryptography.encryptSubsectionByPublicKey(orderExt.getBytes(),publicKey);
		System.out.println("加密后：" + new String(encryptedBytes));
		System.out.println("costTime-en" + (System.currentTimeMillis() - startTime0) + "  RSACryptography encrypt OrderExt");

		long startTime1 = System.currentTimeMillis();
		// 私钥解密
		byte[] decryptedBytes = RSACryptography.decryptSubsectionByPrivateKey(encryptedBytes,privateKey);
		System.out.println("解密后：" + new String(decryptedBytes));
		System.out.println("costTime-de" + (System.currentTimeMillis() - startTime1) + "  RSACryptography decrypt OrderExt");
		
		Assert.assertEquals("加密和解密后的结果：",orderExt, new String(decryptedBytes));
//		Order order = (Order) JSONUtils.json2pojo(new String(decryptedBytes), Order.class);
//		System.out.println("order:"+order);
	}
}
