package thsCrack;

//package defpackage;

//import com.hexin.exception.Exception;
//import com.hexin.exception.QueueFullException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* compiled from: HexinClass */
/* renamed from: eto  reason: default package */
/* loaded from: classes7.dex */
public class eto {

    /* renamed from: a  reason: collision with root package name */
    private static int f37020a = 10001;

    /* renamed from: b  reason: collision with root package name */
    private static Map<data_send_recv_interface, Map<Integer, Vector<Integer>>> f37021b = new HashMap(20);

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f37022c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f37023d = new byte[0];

    /* renamed from: e  reason: collision with root package name */
    private static final Set<a> f37024e = new HashSet();

    /* compiled from: HexinClass */
    /* renamed from: eto$a */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);

        void b(int i);
    }

    public static void a() {
        b();
    }

    public static int a(data_send_recv_interface data_send_recv_interfaceVar)  {
        System.out.println("未被使用的函数");
        System.exit(0);
        return 0;
//        int i;
//        synchronized (f37022c) {
//            Map<Integer, Vector<Integer>> map = f37021b.get(data_send_recv_interfaceVar);
//            if (map != null && map.keySet().iterator().hasNext()) {
//                i = map.keySet().iterator().next().intValue();
//            } else if (f37021b.size() >= 10000) {
//                throw new QueueFullException("size > 10000 , need remove unused NetWrokClinet");
//            } else {
//                if (f37020a < 65535) {
//                    f37020a++;
//                } else {
//                    f37020a = 10001;
//                }
//                i = f37020a;
//                HashMap hashMap = new HashMap();
//                hashMap.put(Integer.valueOf(i), null);
//                f37021b.put(data_send_recv_interfaceVar, hashMap);
//                c(i);
//            }
//        }
//        return i;
    }

    public static void a(data_send_recv_interface data_send_recv_interfaceVar, int i) throws Exception {
        Map<Integer, Vector<Integer>> map;
        if (i > 10001) {
            throw new Exception("instanceID must <= 10001");
        }
        synchronized (f37022c) {
            Iterator<data_send_recv_interface> it = f37021b.keySet().iterator();
            while (it.hasNext()) {
                data_send_recv_interface next = it.next();
                if (next != null && (map = f37021b.get(next)) != null && map.keySet().iterator().next().intValue() == i) {
                    it.remove();
                    d(i);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i), null);
            f37021b.put(data_send_recv_interfaceVar, hashMap);
            c(i);
            //frr.b("QueueManagement", "register__instanceID = " + i + ",netWrokClinet = " + data_send_recv_interfaceVar + ",keyQueue =" + f37021b.keySet());
        }
    }

    public static int b(data_send_recv_interface data_send_recv_interfaceVar) {
        int i;
        synchronized (f37022c) {
            Map<Integer, Vector<Integer>> map = f37021b.get(data_send_recv_interfaceVar);
            if (map != null) {
                i = map.keySet().iterator().next().intValue();
                f37021b.remove(data_send_recv_interfaceVar);
                d(i);
            } else {
                i = -1;
            }
        }
        return i;
    }

    public static data_send_recv_interface a(int i) {
        data_send_recv_interface data_send_recv_interfaceVar;
        Map<Integer, Vector<Integer>> map;
        synchronized (f37022c) {
            Iterator<data_send_recv_interface> it = f37021b.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    data_send_recv_interfaceVar = null;
                    break;
                }
                data_send_recv_interfaceVar = it.next();
                if (data_send_recv_interfaceVar != null && (map = f37021b.get(data_send_recv_interfaceVar)) != null && map.keySet().iterator().hasNext() && map.keySet().iterator().next().intValue() == i) {
                    it.remove();
                    d(i);
                    //frr.b("QueueManagement", "remove__instanceID = " + i + ",networkClient" + data_send_recv_interfaceVar + ",keyQueue =" + f37021b.keySet());
                    break;
                }
            }
        }
        return data_send_recv_interfaceVar;
    }

    public static void b() {
        synchronized (f37022c) {
            f37020a = 10001;
            f37021b.clear();
        }
    }

    public static Vector<data_send_recv_interface> b(int i) {
        boolean z;
        Vector<Integer> vector;
        Map<Integer, Vector<Integer>> map;
        Map<Integer, Vector<Integer>> map2;
        synchronized (f37022c) {
            Vector<data_send_recv_interface> vector2 = new Vector<>();
            Iterator<data_send_recv_interface> it = f37021b.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    vector = null;
                    break;
                }
                data_send_recv_interface next = it.next();
                if (next != null && (map2 = f37021b.get(next)) != null && map2.keySet().iterator().hasNext() && map2.keySet().iterator().next().intValue() == i) {
                    vector2.add(next);
                    z = true;
                    vector = map2.get(Integer.valueOf(i));
                    break;
                }
            }
            if (z && vector != null && vector.size() > 0) {
                for (data_send_recv_interface data_send_recv_interfaceVar : f37021b.keySet()) {
                    if (data_send_recv_interfaceVar != null && (map = f37021b.get(data_send_recv_interfaceVar)) != null && map.keySet().iterator().hasNext()) {
                        int intValue = map.keySet().iterator().next().intValue();
                        Iterator<Integer> it2 = vector.iterator();
                        while (it2.hasNext()) {
                            if (intValue == it2.next().intValue()) {
                                vector2.add(data_send_recv_interfaceVar);
                            }
                        }
                    }
                }
            }
            if (vector2.size() > 0) {
                return vector2;
            }
            return null;
        }
    }

    public static void a(int i, int i2) {
        Map<Integer, Vector<Integer>> map;
        synchronized (f37022c) {
            Iterator<data_send_recv_interface> it = f37021b.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                data_send_recv_interface next = it.next();
                if (next != null && (map = f37021b.get(next)) != null && map.keySet().iterator().next().intValue() == i) {
                    Vector<Integer> vector = map.get(Integer.valueOf(i));
                    if (vector == null) {
                        vector = new Vector<>();
                    }
                    if (!vector.contains(Integer.valueOf(i2))) {
                        vector.add(Integer.valueOf(i2));
                        map.remove(Integer.valueOf(i));
                        map.put(Integer.valueOf(i), vector);
                        it.remove();
                        f37021b.put(next, map);
                    }
                }
            }
        }
    }

    public static boolean b(int i, int i2) {
        boolean z;
        Map<Integer, Vector<Integer>> map;
        Vector<Integer> vector;
        boolean z2 = false;
        synchronized (f37022c) {
            Iterator<data_send_recv_interface> it = f37021b.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = z2;
                    break;
                }
                data_send_recv_interface next = it.next();
                if (next == null || (map = f37021b.get(next)) == null || map.keySet().iterator().next().intValue() != i || (vector = map.get(Integer.valueOf(i))) == null) {
                    z = z2;
                } else {
                    z = vector.contains(Integer.valueOf(i2));
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
        }
        return z;
    }

    public static int c(data_send_recv_interface data_send_recv_interfaceVar) {
        int i;
        if (f37020a < 65535) {
            f37020a++;
        } else {
            f37020a = 10001;
        }
        i = f37020a;
        c(i);
        return f37020a;
    }

    public static void a(a aVar) {
        if (aVar != null) {
            synchronized (f37023d) {
                if (f37024e.contains(aVar)) {
                    f37024e.remove(aVar);
                }
                f37024e.add(aVar);
            }
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            synchronized (f37023d) {
                f37024e.remove(aVar);
            }
        }
    }

    private static void c(int i) {
        synchronized (f37023d) {
            if (f37024e.size() > 0) {
                for (a aVar : f37024e) {
                    if (aVar != null) {
                        aVar.a(i);
                    }
                }
            }
        }
    }

    private static void d(int i) {
        synchronized (f37023d) {
            if (f37024e.size() > 0) {
                for (a aVar : f37024e) {
                    if (aVar != null) {
                        aVar.b(i);
                    }
                }
            }
        }
    }
}