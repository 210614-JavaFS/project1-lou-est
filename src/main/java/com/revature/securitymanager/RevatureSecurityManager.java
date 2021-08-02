package com.revature.securitymanager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class RevatureSecurityManager {

	private static SecretKeySpec secretKey;
	private static byte[] key;
	private static final String myKey = "revature";

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(encrypt("e"));
		System.out.println(encrypt("f"));
		System.out.println(encrypt("1"));
	}

	public static String encrypt(String stringToEncrypt) {
		try {
			setKey(myKey);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.err.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String stringToDecrypt) {
		try {
			setKey(myKey);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
		} catch (Exception e) {
			System.err.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
}