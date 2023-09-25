package thsCrack;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class fjl {
    private RSAPublicKey a;
    private static final char[] b= new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};;

//    static {
//        fjl.b
//    }

    public RSAPublicKey a() {
        return this.a;
    }

    public void a(String arg4) throws Exception {
        try {
            this.a = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(fjj.a(arg4.getBytes())));
            return;
        }
        catch(NoSuchAlgorithmException v0_2) {
            throw new Exception("无此算法");
        }
        catch(InvalidKeySpecException v0_1) {
            throw new Exception("公钥非法");
        }
        catch(NullPointerException v0) {
            throw new Exception("公钥数据为空");
        }
    }

    public byte[] a(RSAPublicKey arg3, byte[] arg4) throws Exception {
        if(arg3 == null) {
            throw new Exception("加密公钥为空, 请设置");
        }

        try {
            Cipher v0_5 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            v0_5.init(1, arg3);
            return v0_5.doFinal(arg4);
        }
        catch(NoSuchAlgorithmException v0_4) {
            throw new Exception("无此加密算法");
        }
        catch(NoSuchPaddingException v0_3) {
//            fza.a.a(v0_3);
            return null;
        }
        catch(InvalidKeyException v0_2) {
            throw new Exception("加密公钥非法,请检查");
        }
        catch(IllegalBlockSizeException v0_1) {
            throw new Exception("明文长度非法");
        }
        catch(BadPaddingException v0) {
            throw new Exception("明文数据已损坏");
        }
    }
}

