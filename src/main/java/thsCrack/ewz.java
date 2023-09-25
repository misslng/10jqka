package thsCrack;

//package defpackage;

//import com.hexin.plat.android.CommunicationService;

/* compiled from: HexinClass */
/* renamed from: ewz */
/* loaded from: classes4.dex */
public abstract class ewz {

    /* renamed from: a */
    protected eya f37319a;

    /* renamed from: b */
    private exq f37320b;

    public ewz(int i) {
        a(i);
    }

    public void a(exq exqVar) {
        this.f37320b = exqVar;
    }

    public void a(int i) {
        this.f37319a = new eya();
        this.f37319a.f37597a = i;
        this.f37319a.f37598b = -1;
        this.f37319a.f37599c = -1;
        this.f37319a.f37601e = "";
        this.f37319a.g = false;
        this.f37319a.h = false;
        this.f37319a.f = 0x10000;
        this.f37319a.i = 0;
        this.f37319a.j = 0;
        this.f37319a.k = 4;
        this.f37319a.l = 1;
        this.f37319a.m = -1;
        this.f37319a.p = true;
    }

    public ewz a(int i, int i2, data_send_recv_interface data_send_recv_interfaceVar, String str) {
        this.f37319a.f37598b = i;
        this.f37319a.f37599c = i2;
        this.f37319a.f37600d = eto.c(data_send_recv_interfaceVar);
        this.f37319a.f37601e = str;
        return this;
    }

    public ewz a(int i, int i2, int i3, String str) {
        this.f37319a.f37598b = i;
        this.f37319a.f37599c = i2;
        this.f37319a.f37600d = i3;
        this.f37319a.f37601e = str;
        return this;
    }

    public ewz b(int i) {
        this.f37319a.f37598b = i;
        return this;
    }

    public ewz c(int i) {
        this.f37319a.f37599c = i;
        return this;
    }

    public ewz d(int i) {
        this.f37319a.f37600d = i;
        return this;
    }

    public ewz a(String str) {
        this.f37319a.f37601e = str;
        return this;
    }

    public ewz e(int i) {
        this.f37319a.f = i;
        return this;
    }

    public ewz a(boolean z) {
        this.f37319a.g = z;
        return this;
    }

    public ewz b(boolean z) {
        this.f37319a.h = z;
        return this;
    }

    public ewz f(int i) {
        this.f37319a.i = i;
        return this;
    }

    public ewz g(int i) {
        this.f37319a.j = i;
        return this;
    }

    public ewz h(int i) {
        this.f37319a.k = i;
        return this;
    }

    public ewz a(byte[] bArr) {
        this.f37319a.n = bArr;
        this.f37319a.p = false;
        return this;
    }

    public ewz b(String str) {
        this.f37319a.b(str);
        this.f37319a.p = false;
        return this;
    }

    public ewz i(int i) {
        this.f37319a.m = i;
        return this;
    }

    public ewz a(String str, Object obj) {
        this.f37319a.a(str, obj);
        return this;
    }

    public ewz a(int[] iArr) {
        this.f37319a.o = iArr;
        return this;
    }

    public ewz c(boolean z) {
        this.f37319a.q = z;
        return this;
    }

    public eya a() {
        this.f37320b.a(this.f37319a);
//        System.out.println("AM_DATA_REQ"+ "AbsRequestBuilder_request(): " + this.f37319a);
        this.f37320b = null;
        e();
        return this.f37319a;
    }

    public void b() {
        a(true);
        this.f37320b.a(this.f37319a);
        //frr.a("AM_DATA_REQ", "AbsRequestBuilder_requestInBackgroud: " + this.f37319a);
        this.f37320b = null;
        e();
    }

    public void c() {
        this.f37319a = this.f37320b.b(this.f37319a);
        //frr.a("AM_DATA_REQ", "AbsRequestBuilder_requestFlush: " + this.f37319a);
        this.f37320b = null;
        if (this.f37319a != null) {
            e();
        }
    }

    public void d() {
        this.f37320b.c(this.f37319a);
        //frr.a("AM_DATA_REQ", "AbsRequestBuilder_stopRequest: " + this.f37319a);
        this.f37320b = null;
        e();
    }

    public void e() {
//        CommunicationService x = CommunicationService.x();
//        if (x != null) {
//            exh w = x.w();
//            if (w != null) {
//                w.b(this.f37319a);
//                return;
//            }
//            return;
//        }
//        frr.e("AM_DATA_REQ", "AbsRequestBuilder_executeRequest(): service is null.");
    }
}