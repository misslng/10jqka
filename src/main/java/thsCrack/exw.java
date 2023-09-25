package thsCrack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: HexinClass */
/* renamed from: exw  reason: default package */
/* loaded from: classes7.dex */
public class exw {

    /* renamed from: c  reason: collision with root package name */
    private static exw f37578c = null;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArrayList<a>> f37579a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, CopyOnWriteArrayList<a>> f37580b = new HashMap();

    private exw() {
    }

    public static synchronized exw a() {
        exw exwVar;
        synchronized (exw.class) {
            if (f37578c == null) {
                f37578c = new exw();
            }
            exwVar = f37578c;
        }
        return exwVar;
    }

    public void a(int i, int i2, int i3) {
        a(i, i2, i3, 0);
    }

    public void a(int i, int i2, int i3, int i4) {
        Map<Integer, CopyOnWriteArrayList<a>> c2 = c(i4);
        if (c2 != null) {
            synchronized (c2) {
                CopyOnWriteArrayList<a> copyOnWriteArrayList = c2.get(Integer.valueOf(i));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                copyOnWriteArrayList.add(new a(i2, i3));
                c2.put(Integer.valueOf(i), copyOnWriteArrayList);
            }
        }
    }

    private Map<Integer, CopyOnWriteArrayList<a>> c(int i) {
        switch (i) {
            case 0:
                return this.f37579a;
            case 1:
                return this.f37580b;
            default:
                return null;
        }
    }

    public int a(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        if (i == -1) {
            System.out.println("getRequestId: packageId=-1");
            return -1;
        }
        Map<Integer, CopyOnWriteArrayList<a>> c2 = c(i2);
        if (c2 == null) {
            return -1;
        }
        synchronized (c2) {
            for (Integer num : c2.keySet()) {
                System.out.println("getRequestId: frameid=" + num);
                CopyOnWriteArrayList<a> copyOnWriteArrayList = c2.get(num);
                if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                    System.out.println( "getRequestId: idList is empty, frameid=" + num);
                } else {
                    Iterator<a> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (next.f37581a == i) {
                            System.out.println( "getRequestId: find requestid=" + next.f37582b + " by packageid=" + i + " on frameid=" + num);
                            return next.f37582b;
                        }
                    }
                    continue;
                }
            }
            System.out.println("getRequestId: find no mapping requestid by packageid=" + i);
            return -1;
        }
    }

    public void b() {
        synchronized (this.f37579a) {
            this.f37579a.clear();
        }
        synchronized (this.f37580b) {
            this.f37580b.clear();
        }
    }

    public void b(int i) {
        synchronized (this.f37579a) {
            this.f37579a.remove(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HexinClass */
    /* renamed from: exw$a */
    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37581a;

        /* renamed from: b  reason: collision with root package name */
        public int f37582b;

        public a(int i, int i2) {
            this.f37581a = i;
            this.f37582b = i2;
        }
    }
}