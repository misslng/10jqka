package thsCrack;

//package defpackage;

//import android.text.TextUtils;
//import android.util.Log;
//import android.util.SparseArray;
//import androidx.core.view.MotionEventCompat;
//import com.hexin.android.radio.ui.DigitalClockView;
import utils.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* compiled from: HexinClass */
/* renamed from: exz  reason: default package */
/* loaded from: classes8.dex */
public class exz implements exq {

    /* renamed from: a  reason: collision with root package name */
    protected static int f37588a;

    /* renamed from: b  reason: collision with root package name */
    protected static Vector<a> f37589b = new Vector<>();

    /* renamed from: c  reason: collision with root package name */
    protected static Vector<a> f37590c = new Vector<>();

    /* renamed from: d  reason: collision with root package name */
    protected static Vector<Integer> f37591d = new Vector<>();

    /* renamed from: e  reason: collision with root package name */
    public static Map<Integer, exr> f37592e = new HashMap(4);
    public static eth f;

    @Override // defpackage.exq
    public eya a(eya eyaVar) {
        if (eyaVar.f37598b == -1) {
            eyaVar.f37598b = f37588a == -1 ? 0 : f37588a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        eyb.a(stringBuffer, eyaVar.f37598b);
        eyb.a(stringBuffer, d(eyaVar), false, eyaVar.f37598b);
        if (eyaVar.f37599c == -1) {
            stringBuffer.append(eyaVar.f37601e);
            eyaVar.f37599c = 65280;
        } else {
            exr exrVar = f37592e.get(Integer.valueOf(eyaVar.f37597a));
            if (exrVar != null) {
                exrVar.a(stringBuffer, eyaVar);
            } else {
                eyb.a(stringBuffer, eyaVar.f37599c, eyaVar.f37600d, eyaVar.f37601e);
            }
        }
        SparseArray<Integer> sparseArray = new SparseArray<>();
        sparseArray.put(eyaVar.f37600d, Integer.valueOf(eyaVar.f37599c));
        if (eyaVar.f37600d != -2) {
            eyaVar.a(sparseArray);
        }
        if (eyaVar.p) {
            eyaVar.b(stringBuffer.toString());
        }
        return eyaVar;
    }

    private synchronized int[] d(eya eyaVar) {
        int[] iArr;
        boolean z;
        int i = 0;
        synchronized (this) {
            if (f37588a == eyaVar.f37598b) {
                Iterator<a> it = f37589b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && (next.f37595c == eyaVar.f37600d || eto.b(next.f37595c, eyaVar.f37600d))) {
                        eyaVar.f37600d = next.f37595c;
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    if (f37591d != null && f37591d.size() > 0) {
                        int[] iArr2 = new int[f37589b.size() + f37591d.size()];
                        while (i < f37589b.size()) {
                            iArr2[i] = f37589b.get(i).f37595c;
                            i++;
                        }
                        int size = f37589b.size();
                        while (true) {
                            int i2 = size;
                            if (i2 >= iArr2.length) {
                                break;
                            }
                            iArr2[i2] = f37591d.get(i2 - f37589b.size()).intValue();
                            size = i2 + 1;
                        }
                        iArr = iArr2;
                    } else {
                        int[] iArr3 = new int[f37589b.size()];
                        while (i < f37589b.size()) {
                            iArr3[i] = f37589b.get(i).f37595c;
                            i++;
                        }
                        iArr = iArr3;
                    }
                } else if (f37591d != null && f37591d.size() > 0) {
                    int[] iArr4 = new int[f37589b.size() + f37591d.size() + 1];
                    while (i < f37589b.size()) {
                        iArr4[i] = f37589b.get(i).f37595c;
                        i++;
                    }
                    for (int size2 = f37589b.size(); size2 < iArr4.length - 1; size2++) {
                        iArr4[size2] = f37591d.get(size2 - f37589b.size()).intValue();
                    }
                    iArr4[f37589b.size() + f37591d.size()] = eyaVar.f37600d;
                    iArr = iArr4;
                } else {
                    int[] iArr5 = new int[f37589b.size() + 1];
                    while (i < f37589b.size()) {
                        iArr5[i] = f37589b.get(i).f37595c;
                        i++;
                    }
                    iArr5[f37589b.size()] = eyaVar.f37600d;
                    iArr = iArr5;
                }
            } else {
                iArr = new int[]{eyaVar.f37600d};
            }
        }
        return iArr;
    }

    @Override // defpackage.exq
    public synchronized eya b(eya eyaVar) {
        if (f37588a != -1 && f37589b.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            eyb.a(stringBuffer, f37588a);
            if (f37591d != null && f37591d.size() > 0) {
                eyb.a(stringBuffer, f37589b, true, f37588a, f37591d);
            } else {
                eyb.a(stringBuffer, f37589b, true, f37588a);
            }
            SparseArray<Integer> sparseArray = new SparseArray<>();
            exr exrVar = f37592e.get(Integer.valueOf(eyaVar.f37597a));
            if (exrVar != null) {
                exrVar.a(stringBuffer, eyaVar.f37598b, f37589b, sparseArray);
            } else {
                eyb.a(stringBuffer, f37589b, sparseArray);
            }
            eyaVar.a(f37588a);
            eyaVar.b(f37589b.size());
            eyaVar.a(sparseArray);
            eyaVar.b(stringBuffer.toString());
        } else {
//            Log.e("RequestManager", "requestFlush: sFrameid=" + f37588a + ", sReqbuf size=" + f37589b);
            eyaVar = null;
        }
        return eyaVar;
    }

    public synchronized void d() {
        a("clearRequestPageList");
        f37589b.clear();
        f37590c.clear();
        f37591d.clear();
        f37588a = -1;
    }

    private synchronized void a(int i, int i2) {
        for (int size = f37589b.size() - 1; size >= 0; size--) {
            try {
                if (f37589b.get(size).f37594b == i && (i2 == -1 || f37589b.get(size).f37595c == i2)) {
                    f37589b.remove(size);
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
            }
        }
    }

    @Override // defpackage.exq
    public synchronized void a(int i, int i2, int i3, String str) {
        if (f37588a == -1 || (f37588a != i && i != 65520)) {
            d();
        }
        f37588a = i;
        if (i != -1 && ((i2 != -2 && i2 != -1) || i3 == -1)) {
            a(i2, i3);
            a aVar = new a(i, i2, i3, str);
            if (a(aVar)) {
                f37589b.add(aVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        defpackage.eto.a(r0.f37595c, r5.f37595c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(a arg5) {
        return f37589b.contains(arg5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        r1.remove();
     */
    @Override // defpackage.exq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(int r4, int r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Vector<exz$a> r0 = defpackage.exz.f37589b     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L2e
            java.util.Vector<exz$a> r0 = defpackage.exz.f37589b     // Catch: java.lang.Throwable -> L30
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L30
            if (r0 <= 0) goto L2e
            java.util.Vector<exz$a> r0 = defpackage.exz.f37589b     // Catch: java.lang.Throwable -> L30
            java.util.Iterator r1 = r0.iterator()     // Catch: java.lang.Throwable -> L30
        L13:
            boolean r0 = r1.hasNext()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L2e
            java.lang.Object r0 = r1.next()     // Catch: java.lang.Throwable -> L30
            exz$a r0 = (defpackage.exz.a) r0     // Catch: java.lang.Throwable -> L30
            int r2 = r0.f37595c     // Catch: java.lang.Throwable -> L30
            if (r2 != r6) goto L13
            int r2 = r0.f37593a     // Catch: java.lang.Throwable -> L30
            if (r2 != r4) goto L13
            int r0 = r0.f37594b     // Catch: java.lang.Throwable -> L30
            if (r0 != r5) goto L13
            r1.remove()     // Catch: java.lang.Throwable -> L30
        L2e:
            monitor-exit(r3)
            return
        L30:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.exz.a(int, int, int):void");
    }

    @Override // defpackage.exq
    public synchronized void a() {
        a("clearBuff");
        f37589b.clear();
        f37590c.clear();
        f37591d.clear();
        f37588a = -1;
    }

    @Override // defpackage.exq
    public eya c(eya eyaVar) {
        int i = eyaVar.f37598b != -1 ? eyaVar.f37598b : f37588a;
        StringBuffer stringBuffer = new StringBuffer();
        eyb.a(stringBuffer, i);
        stringBuffer.append("pageList=").append("\r\n");
        eyaVar.c(393216);
        eyaVar.a(true);
        eyaVar.b(0);
        eyaVar.b(stringBuffer.toString());
        return eyaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        if (f != null) {
            f.a(str);
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: exz$a */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37593a;

        /* renamed from: b  reason: collision with root package name */
        public int f37594b;

        /* renamed from: c  reason: collision with root package name */
        public int f37595c;

        /* renamed from: d  reason: collision with root package name */
        public String f37596d;

        public a(int i, int i2, int i3, String str) {
            this.f37593a = i;
            this.f37594b = i2;
            this.f37595c = i3;
            this.f37596d = str;
        }

        public boolean a(a aVar) {
            return aVar != null && this.f37593a == aVar.f37593a && this.f37594b == aVar.f37594b && TextUtils.equals(this.f37596d, aVar.f37596d);
        }

        public String toString() {
            return "RequestStruct{frameid=" + this.f37593a + ", pageid=" + this.f37594b + ", instanceid=" + this.f37595c + ", requestText='" + this.f37596d + '\'' + '}';
        }
    }
}