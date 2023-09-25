package thsCrack;

//package defpackage;

//import android.text.TextUtils;
//import android.util.SparseArray;
import utils.TextUtils;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HexinClass */
/* renamed from: eya  reason: default package */
/* loaded from: classes4.dex */
public class eya {

    /* renamed from: a  reason: collision with root package name */
    int f37597a;

    /* renamed from: b  reason: collision with root package name */
    public int f37598b;

    /* renamed from: c  reason: collision with root package name */
    public int f37599c;

    /* renamed from: d  reason: collision with root package name */
    public int f37600d;

    /* renamed from: e  reason: collision with root package name */
    String f37601e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public byte[] n;
    int[] o;
    boolean p;
    boolean q;
    private Map<String, Object> r;
    private a s;

    /* compiled from: HexinClass */
    /* renamed from: eya$a */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<Integer> f37602a;

        /* renamed from: b  reason: collision with root package name */
        String f37603b;
    }

    public void a(String str, Object obj) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        this.r.put(str, obj);
    }

    public Map<String, Object> a() {
        return this.r;
    }

    public Object a(String str) {
        if (this.r != null) {
            return this.r.get(str);
        }
        return null;
    }

    public void a(SparseArray<Integer> sparseArray) {
        if (this.s == null) {
            this.s = new a();
        }
        this.s.f37602a = sparseArray;
    }

    public SparseArray<Integer> b() {
        if (this.s != null) {
            return this.s.f37602a;
        }
        return null;
    }

    public void b(String str) {
        if (this.s == null) {
            this.s = new a();
        }
        this.s.f37603b = str;
    }

    public String c() {
        if (this.s != null) {
            return this.s.f37603b;
        }
        return null;
    }

    public void a(int i) {
        this.f37598b = i;
    }

    public void b(int i) {
        this.l = i;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void c(int i) {
        this.f = i;
    }

    public int d() {
        return this.f37598b;
    }

    public int e() {
        return this.f37599c;
    }

    public int f() {
        return this.f37600d;
    }

    public String g() {
        return this.f37601e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RequestParams:").append('\n');
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            sb.append("bizType=").append(this.f37597a).append('\n').append("frameId=").append(this.f37598b).append('\n').append("pageId=").append(this.f37599c).append('\n').append("instanceId=").append(this.f37600d).append('\n').append("requestText=").append(this.f37601e).append('\n').append("hasBuffer=").append(this.n != null).append('\n');
        } else {
            sb.append("buildRequesText=").append('\n').append(c2).append('\n');
        }
        return sb.toString();
    }
}