package thsCrack;
//
//package defpackage;

import java.util.HashMap;
import java.util.Map;

/* compiled from: HexinClass */
/* renamed from: fjf */
/* loaded from: classes6.dex */
public class fjf {

    /* renamed from: a */
    public static Map<Integer, exq> f38431a = new HashMap(8);

    static {
        c();
    }

    public static ewz a() {
        fje fjeVar = new fje(1);
        fjeVar.a(b());
        return fjeVar;
    }

    private static void c() {
        f38431a.put(1, new exz());
    }

    public static exq a(int i) {
        exq exqVar = f38431a.get(Integer.valueOf(i));
        if (exqVar == null) {
            throw new NullPointerException("your input biztype is unknown");
        }
        return exqVar;
    }

    public static exq b() {
        return a(1);
    }
}