package thsCrack;

//package defpackage;

//import android.text.TextUtils;
import utils.TextUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: HexinClass */
/* renamed from: fhv */
/* loaded from: classes4.dex */
public class fhv {

    /* renamed from: a */
    private static String f38298a = null;

    /* renamed from: b */
    private fhw f38299b;

    public static fhv a() {
        return a.f38300a;
    }

    public void a(String str) {
        f38298a = str;
        this.f38299b = new fhw(f38298a);
    }

    public byte[] a(byte[] bArr) {
        exs a2;
        if (bArr == null) {
            return null;
        }
        if (this.f38299b != null && !TextUtils.isEmpty(f38298a) && (a2 = exs.a(bArr, 0, bArr.length)) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ftg ftgVar = new ftg(byteArrayOutputStream);
            try {
                try {
                    ftgVar.write(bArr, a2.b(), a2.h() + a2.g());
                    byte[] b2 = this.f38299b.b(byteArrayOutputStream.toByteArray(), "AES/ECB/ZeroBytePadding");
                    System.out.println("[encryptData info] frameid:" + a2.e());
                    byteArrayOutputStream.reset();
                    a2.b(a2.d() | 1879048192);
                    a2.e(b2.length);
                    a2.a(ftgVar);
                    ftgVar.write(b2, 0, b2.length);
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                    try {
                        ftgVar.close();
                    } catch (IOException e3) {
                        System.out.println(e3.getMessage());
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    ftgVar.close();
                } catch (IOException e4) {
                    System.out.println(e4);
                }
            }
        }
        return bArr;
    }

    public byte[] a(byte[] bArr, int i, int i2, exs exsVar) {
        if (bArr == null || exsVar == null || i2 < exsVar.g()) {
            return null;
        }
        byte[] bArr2 = new byte[exsVar.g()];
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        System.out.println("decryptData");
        return this.f38299b.c(bArr2, "AES/ECB/NoPadding");
    }

    /* compiled from: HexinClass */
    /* renamed from: fhv$a */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a */
        private static final fhv f38300a = new fhv();
    }
}