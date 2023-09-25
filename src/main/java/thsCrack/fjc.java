package thsCrack;

//package defpackage;

//import android.text.TextUtils;
//import com.hexin.middleware.MiddlewareProxy;
//import com.hexin.performancemonitor.Configuration;
//import com.hxlogin.third.models.ThirdUserInfo;
//import com.unionpay.tsmservice.data.Constant;
//import defpackage.esg;
import utils.Constant;
import utils.TextUtils;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* compiled from: HexinClass */
/* renamed from: fjc  reason: default package */
/* loaded from: classes8.dex */
public class fjc {

    /* renamed from: a  reason: collision with root package name */
    public static final fjc f38429a = new fjc();

    public fjc() {
    }

    public final String b(String str) {
        hsl.b(str, "originalContent");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            fjl fjlVar = new fjl();
            String a2 = Constant.RSA_KEY;
            if (TextUtils.isEmpty(a2)) {
            } else {
                fjlVar.a(a2);
                Charset forName = Charset.forName(MiddlewareProxy.ENCODE_TYPE_GBK);
                byte[] bytes = str.getBytes(forName);
                Charset forName2 = Charset.forName(MiddlewareProxy.ENCODE_TYPE_GBK);
                String str2 = new String(bytes, forName2);
                Charset forName3 = Charset.forName(MiddlewareProxy.ENCODE_TYPE_GBK);
                byte[] bytes2 = str2.getBytes(forName3);
                byte[] a3 = fjlVar.a(fjlVar.a(), bytes2);
                String b2 = fjj.b(a3);
                str = b2;
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
//            fza.f39719a.d("hxlogin", "Utils_encryptAndFormatBase64 exception e= " + e2);
//            fza.f39719a.a(e2);
            return str;
        }
    }

}