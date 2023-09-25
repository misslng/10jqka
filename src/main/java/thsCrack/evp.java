package thsCrack;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HexinClass */
/* renamed from: evp  reason: default package */
/* loaded from: classes8.dex */
public class evp {

    /* renamed from: b  reason: collision with root package name */
    private static evp f37158b;

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<evs> f37159a = new SparseArray<>();

    private evp() {
    }

    public static evp a() {
        if (f37158b == null) {
            synchronized (evp.class) {
                if (f37158b == null) {
                    f37158b = new evp();
                }
            }
        }
        return f37158b;
    }

    private void a(int i, evs evsVar) {
        synchronized (this.f37159a) {
            this.f37159a.put(i, evsVar);
        }
    }

    public void a(int i) {
        synchronized (this.f37159a) {
            evs evsVar = this.f37159a.get(i);
            if (evsVar != null) {
                evsVar.a();
            }
            this.f37159a.remove(i);
        }
    }

    public evs b(int i) {
        evs evsVar;
        synchronized (this.f37159a) {
            evsVar = this.f37159a.get(i);
        }
        return evsVar;
    }

    public void b() {
        synchronized (this.f37159a) {
            this.f37159a.clear();
        }
    }

    public List<evs> c() {
        ArrayList arrayList;
        synchronized (this.f37159a) {
            int size = this.f37159a.size();
            arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                evs valueAt = this.f37159a.valueAt(i);
                if (valueAt != null) {
                    arrayList.add(valueAt);
                }
            }
        }
        return arrayList;
    }

    public boolean c(int i) {
        boolean z;
        synchronized (this.f37159a) {
            z = this.f37159a.indexOfKey(i) > -1;
        }
        return z;
    }

    private evs d(int i) {
        switch (i) {
            case 1:
                return new evt();
            default:
                return null;
        }
    }

    public List<Integer> a(evr evrVar) {
        eup[] m;
        if (evrVar == null || (m = evrVar.m()) == null || m.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (evs evsVar : c()) {
            for (eup eupVar : m) {
                int[] a2 = evrVar.a(eupVar);
                if (a2 != null && evsVar.a(eupVar, a2) && !arrayList.contains(Integer.valueOf(evsVar.c()))) {
                    arrayList.add(Integer.valueOf(evsVar.c()));
                }
            }
        }
        System.out.println("AM_REALDATA"+ "RealDataManager_filterInstanceIds():eventually ids=" + arrayList);
        return arrayList;
    }

    public void a(int i, List<eup> list, int[] iArr, int i2) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Subscriber ids must not be empty!");
        }
        if (i < 0) {
            throw new IllegalArgumentException("instanceid is error, id=" + i);
        }
        if (i2 != 2 && i2 != 1) {
            throw new IllegalArgumentException("reqType is error, type=" + i2);
        }
        evs d2 = d(i2);
        if (d2 != null) {
            if (list != null && list.size() > 0) {
                d2.a(list);
            }
            d2.a(i, i2, iArr);
            a(i, d2);
        }
    }
}