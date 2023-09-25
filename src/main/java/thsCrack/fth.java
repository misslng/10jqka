package thsCrack;

//package defpackage;

//import com.hexin.android.view.CangweiTips;

/* compiled from: HexinClass */
/* renamed from: fth  reason: default package */
/* loaded from: classes6.dex */
public class fth {

    /* renamed from: a  reason: collision with root package name */
    private static final long f39218a = Long.parseLong("80000000", 16);

    /* renamed from: b  reason: collision with root package name */
    private static final long f39219b = Long.parseLong("FFFFFFFF", 16);

    /* renamed from: c  reason: collision with root package name */
    private int f39220c;

    /* renamed from: d  reason: collision with root package name */
    private int f39221d;

    /* renamed from: e  reason: collision with root package name */
    private int f39222e;
    private int f;
    private long g;

    public fth() {
        d();
    }

    public void a(long j) {
        if (j == 0) {
            d();
            return;
        }
        this.g = j;
        this.f39220c = (int) (0x7FFFFFFL & j);
        this.f39221d = (int) ((0x8000000L & j) >> 27);
        this.f39222e = (int) ((0x70000000L & j) >> 28);
        this.f = (int) (((0xFFFFFFFF80000000L) & j) >> 0x1F);
    }

    public int a() {
        if (this.f == 0) {
            return 0;
        }
        return this.f39222e;
    }

    public double b() {
        double d2;
        if (c()) {
            return -2.147483648E9d;
        }
        if (e()) {
            return CangweiTips.MIN;
        }
        double pow = Math.pow(10.0d, this.f39222e);
        if (this.f == 1) {
            d2 = this.f39220c / pow;
        } else {
            d2 = pow * this.f39220c;
        }
        return this.f39221d != 0 ? -d2 : d2;
    }

    public boolean c() {
        return this.g == -2147483648L || this.g == -1 || this.g == f39218a || this.g == f39219b;
    }

    private void d() {
        this.g = 0L;
        this.f39220c = 0;
        this.f39221d = 0;
        this.f39222e = 0;
        this.f = 0;
    }

    private boolean e() {
        return this.f39221d == 0 && this.f39222e == 0 && this.f39220c == 0 && this.f == 0;
    }
}