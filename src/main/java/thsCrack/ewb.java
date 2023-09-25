package thsCrack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: HexinClass */
/* renamed from: ewb  reason: default package */
/* loaded from: classes4.dex */
public class ewb {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, ewf> f37211a = new HashMap();

    public static synchronized boolean a(exs exsVar) {
        boolean z;
        synchronized (ewb.class) {
            System.out.println("HeadDispatcher_dispatch() called with: head = [" + exsVar + "]");
            if (exsVar != null) {
                Iterator<ewf> it = f37211a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    ewf next = it.next();
                    if (next != null && next.b(exsVar) && next.a(exsVar)) {
                        z = true;
                        break;
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized boolean a(ewf ewfVar) {
        boolean z;
        synchronized (ewb.class) {
            if (ewfVar == null) {
                z = false;
            } else {
                f37211a.put(ewfVar.a(), ewfVar);
                z = true;
            }
        }
        return z;
    }

    public static synchronized void a() {
        synchronized (ewb.class) {
            f37211a.clear();
        }
    }
}