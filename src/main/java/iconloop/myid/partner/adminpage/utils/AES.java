package iconloop.myid.partner.adminpage.utils;

import iconloop.myid.partner.adminpage.exception.CommonException;
import iconloop.myid.partner.adminpage.exception.code.CommonErrorCode;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

public class AES {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String ENCRYPTION_SCHEME = "AES/CBC/PKCS5Padding";

    private static String secretKey;
    private static Cipher encryptionCipher;

    public static void initSecret() {
        try{
            Properties profile = new Properties();
            profile.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            secretKey = profile.getProperty("setting.aes.secret");

            String initVector = secretKey.substring(0,16);

            SecretKeySpec defaultSecretKeySpec = new SecretKeySpec(secretKey.getBytes(), ENCRYPTION_ALGORITHM);
            IvParameterSpec defaultInitializationVectorSpec = new IvParameterSpec(initVector.getBytes(DEFAULT_CHARSET));
            encryptionCipher = Cipher.getInstance(ENCRYPTION_SCHEME);
            encryptionCipher.init(Cipher.ENCRYPT_MODE, defaultSecretKeySpec, defaultInitializationVectorSpec);

        } catch (IOException e){
            System.err.println("initSecretIOException");
        } catch (NullPointerException e) {
            System.err.println("EncCipher NullPointerException");
        } catch (NoSuchPaddingException e) {
            System.err.println("EncCipher NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("EncCipher NoSuchAlgorithmException");
        } catch (InvalidAlgorithmParameterException e) {
            System.err.println("EncCipher InvalidAlgorithmParameterException");
        } catch (InvalidKeyException e) {
            System.err.println("EncCipher InvalidAlgorithmParameterException");
        }
    }

    public static String getEncryptB64(String val){
        if(val == null){
            return null;
        }
        try{
            if(encryptionCipher == null){
                initSecret();
            }

            String b64String = Base64.getEncoder().encodeToString(encryptionCipher.doFinal(val.getBytes(DEFAULT_CHARSET)));
            if(val.equals(b64String)) {
                throw new CommonException(String.valueOf(CommonErrorCode.CRYPTO_ERROR.getCode()), "encrypt equals " + val + " -> " + b64String);
            }
            return b64String;
        } catch(IllegalBlockSizeException e){
            throw new CommonException(String.valueOf(CommonErrorCode.CRYPTO_ERROR.getCode()), "Encrypt IllegalBlockSizeException");
        } catch(BadPaddingException e){
            throw new CommonException(String.valueOf(CommonErrorCode.CRYPTO_ERROR.getCode()), "Encrypt BadPaddingException");
        }
    }

}
