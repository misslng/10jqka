package thsCrack;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HexinClass */
/* renamed from: eur  reason: default package */
/* loaded from: classes6.dex */
//这是StuffBaseStruct

public abstract class eur {

    /* renamed from: a  reason: collision with root package name */
    protected int f37121a;

    /* renamed from: b  reason: collision with root package name */
    protected int f37122b;

    /* renamed from: c  reason: collision with root package name */
    protected int f37123c;

    /* renamed from: d  reason: collision with root package name */
    protected int f37124d;

    /* renamed from: e  reason: collision with root package name */
    protected int f37125e;
    protected int f;
    protected boolean g;
    protected boolean h;
    protected long i;
    protected boolean j = false;
    protected Map<String, Object> k;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(exs exsVar) {
        this.f = exsVar.i();
        this.g = exsVar.c() == -1;
        this.f37124d = exsVar.e();
        this.f37125e = exsVar.f();
        this.f37123c = exsVar.c();
        this.f37121a = exw.a().a(exsVar.c());
        this.f37122b = exsVar.d();
    }

    public int a() {
        return this.f37121a;
    }

    public int b() {
        return this.f37123c;
    }

    public int c() {
        return this.f37124d;
    }

    public int d() {
        return this.f37125e;
    }

    public int e() {
        return this.f;
    }

    public String f() {
        return "";
    }

    public int g() {
        return this.f37122b;
    }

    public boolean h() {
        return this.g;
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.j;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public void a(eur eurVar) {
        if (eurVar != null) {
            eurVar.f37121a = this.f37121a;
            eurVar.f37123c = this.f37123c;
            eurVar.f37124d = this.f37124d;
            eurVar.f37125e = this.f37125e;
            eurVar.f = this.f;
            eurVar.g = this.g;
            eurVar.h = this.h;
            eurVar.i = this.i;
            eurVar.j = this.j;
            eurVar.f37122b = this.f37122b;
        }
    }

    public eur k() {
        return null;
    }

    public String toString() {
        return "StuffBaseStruct [requestId=" + this.f37121a + ", headType=" + this.f37122b + ", packageId=" + this.f37123c + ", frameId=" + this.f37124d + ", pageId=" + this.f37125e + ", instanceId=" + this.f + ", isRealData=" + this.g + ", isLocalData=" + this.h + ", updateTime=" + this.i + ", isExceptionWhenParse=" + this.j + "]";
    }

    public void c(boolean z) {
        this.g = z;
    }

    public void a(String str, Object obj) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        this.k.put(str, obj);
    }

    public Object a(String str) {
        if (this.k == null) {
            return null;
        }
        return this.k.get(str);
    }

    public Map<String, Object> l() {
        return this.k;
    }
}