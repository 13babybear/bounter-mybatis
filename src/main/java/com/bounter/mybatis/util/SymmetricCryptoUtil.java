package com.bounter.mybatis.util;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by simon on 2017/6/20.
 * 对称加密工具类，封装一些常用的对称加密算法实现
 */
public class SymmetricCryptoUtil {

	//AES默认的十六进制密钥串
	private static final String DEFAULT_KEY_AES = "692d6c6f76652d2d7869616f73757375";
	
    /**
     * 生成56位的DES密钥，以十六进制形式返回
     * @return
     * @throws Exception
     */
    public static String genDESHexKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        return EncodeUtil.encodeHex(secretKey.getEncoded());
    }

    /**
     * 生成168位的3DES密钥，以十六进制形式返回
     * @return
     * @throws Exception
     */
    public static String genDESedeHexKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(168);
        SecretKey secretKey = keyGenerator.generateKey();
        return EncodeUtil.encodeHex(secretKey.getEncoded());
    }

    /**
     * 生成128位的AES密钥，以十六进制形式返回
     * @return
     * @throws Exception
     */
    public static String genAESHexKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        return EncodeUtil.encodeHex(secretKey.getEncoded());
    }

    /**
     * DES加密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptDES(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        DESKeySpec desKeySpec = new DESKeySpec(EncodeUtil.decodeHex(hexKey));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        //根据密钥加密数据
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }

    /**
     * DES解密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptDES(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        DESKeySpec desKeySpec = new DESKeySpec(EncodeUtil.decodeHex(hexKey));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        //根据密钥解密数据
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }

    /**
     * 3DES加密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptDESede(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(EncodeUtil.decodeHex(hexKey));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        //根据密钥加密数据
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }

    /**
     * 3DES解密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptDESede(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(EncodeUtil.decodeHex(hexKey));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = secretKeyFactory.generateSecret(deSedeKeySpec);
        //根据密钥加密数据
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }

    /**
     * AES加密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptAES(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        SecretKey secretKey = new SecretKeySpec(EncodeUtil.decodeHex(hexKey),"AES");
        //根据密钥加密数据
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }
    
    /**
     * 用默认的AES密钥串加密
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptAESWithDefaultKey(byte[] data) throws Exception {
        return encryptAES(DEFAULT_KEY_AES, data);
    }

    /**
     * AES解密
     * @param hexKey
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptAES(String hexKey, byte[] data) throws Exception {
        //根据十六进制密钥串生成密钥
        SecretKey secretKey = new SecretKeySpec(EncodeUtil.decodeHex(hexKey),"AES");
        //根据密钥加密数据
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        return cipher.doFinal(data);
    }

    /**
     * 用默认的密钥串解密
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decryptAESWithDefaultKey(byte[] data) throws Exception {
        return decryptAES(DEFAULT_KEY_AES, data);
    }

    public static void main(String[] args) throws Exception {
        String dataStr = "bem4ph1p8gK7NBhVSW8wBQ==";
        byte[] decryptData = decryptAESWithDefaultKey(EncodeUtil.decodeBase64(dataStr));
        System.out.println(new String(decryptData));
    }
}
