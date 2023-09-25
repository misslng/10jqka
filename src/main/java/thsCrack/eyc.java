package thsCrack;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: HexinClass */
/* renamed from: eyc  reason: default package */
/* loaded from: classes4.dex */
public class eyc {

    /* renamed from: a  reason: collision with root package name */
    public static eyc f37604a;

    /* renamed from: b  reason: collision with root package name */
    private static int f37605b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<Integer, ext> f37606c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private Timer f37607d = new Timer("timer_RequestTimeRecordManager");

    /* renamed from: e  reason: collision with root package name */
    private a f37608e = new a();

    private eyc() {
        this.f37607d.schedule(this.f37608e, f37605b, f37605b);
    }

    public static eyc a() {
        if (f37604a == null) {
            f37604a = new eyc();
        }
        return f37604a;
    }

    public void a(int i, int i2, int i3) {
        if (i != 0) {
            this.f37606c.put(Integer.valueOf(i2), new ext(i, i3));
        }
    }

    public void b() {
        if (this.f37606c != null) {
            this.f37606c.clear();
        }
        if (this.f37607d != null) {
            this.f37607d.cancel();
            this.f37607d = null;
        }
    }

    public ext c() {
        if (this.f37606c.size() > 0) {
            for (Map.Entry<Integer, ext> entry : this.f37606c.entrySet()) {
                ext value = entry.getValue();
                int intValue = entry.getKey().intValue();
                if (value.b()) {
                    this.f37606c.remove(Integer.valueOf(intValue));
                    if (value != null) {
                        System.out.println("getP eriod mPackageid=" + intValue + ", mFrameId=" + value.f() + ", period=" + value.e());
                        return value;
                    }
                    return value;
                }
            }
        }
        return null;
    }

    public void a(int i) {
        ext extVar;
        if (i != 0 && (extVar = this.f37606c.get(Integer.valueOf(i))) != null) {
            extVar.a();
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: eyc$a */
    /* loaded from: classes4.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (eyc.this.f37606c.size() > 0) {
                for (Map.Entry entry : eyc.this.f37606c.entrySet()) {
                    ext extVar = (ext) entry.getValue();
                    if (!extVar.b() && extVar.c()) {
                        extVar.d();
                    }
                }
            }
        }
    }
}