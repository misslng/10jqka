package thsCrack;

//package com.hxlogin.third.models;

//import android.os.Bundle;
//import android.text.TextUtils;
//import androidx.annotation.NonNull;
import utils.TextUtils;

import java.io.Serializable;

/* compiled from: HexinClass */
/* loaded from: classes8.dex */
public class ThirdUserInfo implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f28389a;

    /* renamed from: b  reason: collision with root package name */
    public String f28390b;

    /* renamed from: c  reason: collision with root package name */
    public String f28391c;

    /* renamed from: d  reason: collision with root package name */
    public String f28392d;

    /* renamed from: e  reason: collision with root package name */
    public long f28393e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;

    public int a() {
        if (this.f != null && !"".equals(this.f.trim())) {
            if ("男".equals(this.f.trim()) || "m".equals(this.f.trim()) || "1".equals(this.f.trim())) {
                return 1;
            }
            if ("女".equals(this.f.trim()) || "f".equals(this.f.trim()) || "2".equals(this.f.trim())) {
                return 2;
            }
        }
        return 0;
    }

    public String b() {
        if (this.f28389a != null) {
            if (this.h == 1) {
                return "1000_" + this.f28389a;
            }
            if (this.h == 2) {
                return "0100_" + this.f28389a;
            }
            if (this.h == 3) {
                return "0010_" + this.f28389a;
            }
        }
        return null;
    }

    public String c() {
        return (TextUtils.isEmpty(this.j) || this.h != 3) ? "" : "0010_" + this.j;
    }

    public String d() {
        if (!TextUtils.isEmpty(this.l) && this.h == 2) {
            if (this.l.startsWith("0100_")) {
                return this.l;
            }
            return "0100_" + this.l;
        }
        return "";
    }
//
//    @NonNull
//    public Bundle a(@NonNull Bundle bundle) {
//        bundle.putString("_thirduserinfo_thirduid", this.f28389a);
//        bundle.putString("_thirduserinfo_username", this.f28390b);
//        bundle.putString("_thirduserinfo_profileurl", this.f28391c);
//        bundle.putString("_thirduserinfo_accesstoken", this.f28392d);
//        bundle.putLong("_thirduserinfo_expiresin", this.f28393e);
//        bundle.putString("_thirduserinfo_location", this.g);
//        bundle.putInt("_thirduserinfo_type", this.h);
//        bundle.putString("_thirduserinfo_thsusername", this.i);
//        bundle.putString("_thirduserinfo_weixinunionid", this.j);
//        bundle.putString("_thirduserinfo_appid", this.k);
//        bundle.putString("_thirduserinfo_tencentunionid", this.l);
//        return bundle;
//    }
}