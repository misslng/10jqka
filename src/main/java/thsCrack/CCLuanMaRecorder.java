package thsCrack;

//package com.hexin.common;

//import com.hexin.security.DesEngineManager;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: HexinClass */
/* loaded from: classes4.dex */
public final class CCLuanMaRecorder {

    /* renamed from: c */
    private static DesEngineManager.ExecuteDesMode f25196c;

    /* renamed from: e */
    private static boolean f25198e;
    private static boolean f;
    private static boolean g;

    /* renamed from: a */
    public static final CCLuanMaRecorder f25194a = new CCLuanMaRecorder();

    /* renamed from: b */
    private static final Map<String, byte[]> f25195b = new LinkedHashMap();

    /* renamed from: d */
    private static final Map<Integer, Integer> f25197d = new LinkedHashMap();

    /* compiled from: HexinClass */
    /* loaded from: classes6.dex */
    public enum Stage {
        SOURCE,
        DECRYPT
    }

    private CCLuanMaRecorder() {
    }

    public final void a(Stage stage, byte[] bArr, exs exsVar) {
        hsl.b(stage, "stage");
        hsl.b(bArr, "buffer");
        hsl.b(exsVar, "head");
        int c2 = exsVar.c();
        Integer num = f25197d.get(1891);
        if (num != null && c2 == num.intValue()) {
            if (stage == Stage.SOURCE) {
                f25195b.put("source", bArr);
            } else if (stage == Stage.DECRYPT) {
                f25195b.put("decrypt", bArr);
            }
        }
    }

    public final void a(DesEngineManager.ExecuteDesMode executeDesMode, exs exsVar, boolean z, boolean z2, boolean z3) {
        hsl.b(executeDesMode, "mode");
        hsl.b(exsVar, "head");
        int c2 = exsVar.c();
        Integer num = f25197d.get(1891);
        if (num != null && c2 == num.intValue()) {
            f25196c = executeDesMode;
            f25198e = z;
            f = z2;
            g = z3;
        }
    }

    public final Map<String, byte[]> a() {
        return f25195b;
    }

    public final DesEngineManager.ExecuteDesMode b() {
        return f25196c;
    }

    public final boolean c() {
        return f25198e;
    }

    public final boolean d() {
        return f;
    }

    public final boolean e() {
        return g;
    }

    public final void f() {
        f25195b.clear();
        f25197d.clear();
        f25196c = null;
        f25198e = false;
        f = false;
        g = false;
    }

    public final void a(erf erfVar) {
        hsl.b(erfVar, "requestInfo");
        if (erfVar.d() == 1891) {
            f25197d.put(1891, Integer.valueOf(erfVar.k()));
        }
    }
}