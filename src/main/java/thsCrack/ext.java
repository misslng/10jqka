package thsCrack;

//import com.hexin.android.lgt.LgtContent;

/* compiled from: HexinClass */
/* renamed from: ext  reason: default package */
/* loaded from: classes5.dex */
public class ext {

    /* renamed from: a  reason: collision with root package name */
    private int f37565a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f37566b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f37567c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f37568d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f37569e = -1;
    private long f = 60000;

    public ext(int i, int i2) {
        a(i, i2);
    }

    public void a(int i, int i2) {
        this.f37566b = i2;
        this.f37565a = i;
        this.f37568d = System.currentTimeMillis();
        this.f37567c = 0;
        this.f37569e = -1L;
    }

    public void a() {
        this.f37567c++;
        this.f37569e = System.currentTimeMillis();
    }

    public boolean b() {
        return this.f37567c == this.f37566b;
    }

    public boolean c() {
        return System.currentTimeMillis() - this.f37568d > this.f;
    }

    public void d() {
        this.f37569e = this.f37568d + this.f + this.f37567c;
        this.f37567c = this.f37566b;
    }

    public int e() {
        int i = (int) (this.f37569e - this.f37568d);
        if (i > 60000 || i < 1) {
            return 60000;
        }
        return i;
    }

    public int f() {
        return this.f37565a;
    }
}