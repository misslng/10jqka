package thsCrack;

//package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* compiled from: HexinClass */
/* renamed from: ewd */
/* loaded from: classes6.dex */
public class ewd {

    /* renamed from: b */
    private static ewj f37215b;

    /* renamed from: a */
    private static final Map<String, ewg> f37214a = new HashMap();

    /* renamed from: c */
    private static final byte[] f37216c = new byte[0];

    public static void a(exs exsVar, eur eurVar) {
        synchronized (f37216c) {
            
            System.out.println("AM_DATA_REC"+"StructDispatcher_onPreDispatch(): head -> \n" + exsVar);
            if (f37215b != null) {
                f37215b.a(exsVar, eurVar);
            } else {
                //frr.e("AM_DATA_REC"+"StructDispatcher_onPreDispatch(): EMPTY LISTENER ERROR!");
            }
        }
    }

    public static synchronized boolean a(eur eurVar) {
        boolean z = false;
        synchronized (ewd.class) {
            if (eurVar != null) {
                System.out.println("AM_DATA_REC"+"StructDispatcher_dispatch():");
                Iterator<ewg> it = f37214a.values().iterator();
                boolean z2 = false;
                while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    ewg next = it.next();
                    if (next.b(eurVar)) {
                        System.out.println("AM_DATA_REC"+"StructDispatcher_dispatch(): receiver name is " + next.a());
                        z = next.a(eurVar);
                        if (z) {
                            break;
                        }
                        z2 = z;
                    }
                }
            }
        }
        return z;
    }

    public static boolean b(eur eurVar) {
        System.out.println("ewd b 未被使用的代码");
        System.exit(0);
//        Vector<data_send_recv_interface> b2 = eto.b(eurVar.e());
//        System.out.println("AM_DATA_REC"+"StructDispatcher_dispatchClients(): instanceId = " + eurVar.e() + ", packageid = " + eurVar.b() + ", client size == " + (b2 == null ? 0 : b2.size()));
//        if (b2 != null) {
//            Iterator<data_send_recv_interface> it = b2.iterator();
//            while (it.hasNext()) {
//                data_send_recv_interface next = it.next();
//                if (next != null) {
//                    next.receive(eurVar);
//                }
//            }
//            return true;
//        }
//        return false;
        return true;
    }

    public static synchronized boolean a(ewg ewgVar) {
        boolean z = false;
        synchronized (ewd.class) {
            if (ewgVar != null) {
                if (f37214a.put(ewgVar.a(), ewgVar) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized void a() {
        synchronized (ewd.class) {
            f37214a.clear();
        }
    }

    public static void a(ewj ewjVar) {
        synchronized (f37216c) {
            f37215b = ewjVar;
        }
    }

    public static void b() {
        synchronized (f37216c) {
            f37215b = null;
        }
    }
}