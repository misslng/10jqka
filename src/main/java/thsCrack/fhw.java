package thsCrack;

//package defpackage;

//import android.text.TextUtils;
import utils.TextUtils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.http.protocol.HTTP;

/* compiled from: HexinClass */
/* renamed from: fhw  reason: default package */
/* loaded from: classes8.dex */
public class fhw {

    /* renamed from: a  reason: collision with root package name */
    private SecretKeySpec f38301a;

    /* renamed from: b  reason: collision with root package name */
    private IvParameterSpec f38302b;

    public fhw(String str) {
        this.f38301a = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f38301a = new SecretKeySpec(str.getBytes(HTTP.ASCII), "AES");
            }
        } catch (UnsupportedEncodingException e2) {
            
            System.out.println(e2.getMessage());
        }
    }

    public fhw a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f38302b = new IvParameterSpec(str.getBytes());
        }
        return this;
    }

    public String a(byte[] bArr) {
        return a(bArr, "AES/CBC/PKCS5Padding");
    }

    public String a(byte[] bArr, String str) {
        return new String(fhx.c(a(str, this.f38301a, bArr), 0));
    }

    public byte[] b(byte[] bArr, String str) {
        return a(str, this.f38301a, bArr);
    }

    public String b(byte[] bArr) {
        byte[] b2;
        if (bArr == null || (b2 = b("AES/CBC/PKCS5Padding", this.f38301a, bArr)) == null) {
            return null;
        }
        return new String(b2);
    }

    public byte[] c(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        return b(str, this.f38301a, bArr);
    }

    private byte[] a(String str, SecretKey secretKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            if (this.f38302b != null) {
                cipher.init(1, secretKey, this.f38302b);
            } else {
                cipher.init(1, secretKey);
            }
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e2) {
            System.out.println(e2);
            return null;
        } catch (InvalidKeyException e3) {
            //frr.b("AESUtil", "invalid key exception");
            return null;
        } catch (NoSuchAlgorithmException e4) {
            //frr.b("AESUtil", "no cipher getinstance support for " + str);
            return null;
        } catch (BadPaddingException e5) {
            //frr.b("AESUtil", "bad padding exception");
            return null;
        } catch (IllegalBlockSizeException e6) {
            //frr.b("AESUtil", "illegal block size exception");
            return null;
        } catch (NoSuchPaddingException e7) {
            //frr.b("AESUtil", "no cipher getinstance support for padding " + str);
            return null;
        }
    }

    private byte[] b(String str, SecretKey secretKey, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            if (this.f38302b != null) {
                cipher.init(2, secretKey, this.f38302b);
            } else {
                cipher.init(2, secretKey);
            }
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e2) {
            System.out.println(e2);
            return null;
        } catch (InvalidKeyException e3) {
            //frr.b("AESUtil", "invalid key exception");
            return null;
        } catch (NoSuchAlgorithmException e4) {
            //frr.b("AESUtil", "no cipher getinstance support for " + str);
            return null;
        } catch (BadPaddingException e5) {
            System.out.println(e5);
            return null;
        } catch (IllegalBlockSizeException e6) {
            //frr.b("AESUtil", "illegal block size exception");
            return null;
        } catch (NoSuchPaddingException e7) {
            //frr.b("AESUtil", "no cipher getinstance support for padding " + str);
            return null;
        }
    }
}