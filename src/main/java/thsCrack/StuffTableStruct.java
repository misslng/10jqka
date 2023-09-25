package thsCrack;

//package com.hexin.middleware.data.mobile;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;

/* compiled from: HexinClass */
/* loaded from: classes4.dex */
public class StuffTableStruct extends eur implements Serializable {
    private static final long serialVersionUID = -6404551563216029348L;
    public String l;
    public String[] m;
    public int[] n;
    public Hashtable<Integer, String[]> o;
    public Hashtable<Integer, int[]> p;
    public Hashtable<Integer, Object> q;
    public Hashtable<Integer, Integer> r = new Hashtable<>();
    public int s;
    public int t;
    public boolean u;
    public byte[] v;
    public exs w;

    public Hashtable<Integer, int[]> m() {
        return this.p;
    }

    public StuffTableStruct(boolean z) {
        this.u = z;
    }

    public String n() {
        return this.l;
    }

    public String[] o() {
        return this.m;
    }

    public int[] p() {
        return this.n;
    }

    public String[] a(int i) {
        if (this.o != null && this.o.size() > 0) {
            String[] strArr = this.o.get(Integer.valueOf(i));
            if (strArr instanceof String[]) {
                return strArr;
            }
        }
        return null;
    }

    public int[] b(int i) {
        if (this.p != null && this.p.size() > 0) {
            int[] iArr = this.p.get(Integer.valueOf(i));
            if (iArr instanceof int[]) {
                return iArr;
            }
        }
        return null;
    }

    public Object c(int i) {
        if (this.q == null || this.q.size() <= 0) {
            return null;
        }
        return this.q.get(Integer.valueOf(i));
    }

    public int d(int i) {
        if (this.r != null && this.r.size() > 0) {
            Integer num = this.r.get(Integer.valueOf(i));
            if (num instanceof Integer) {
                return num.intValue();
            }
        }
        return 0;
    }

    public boolean e(int i) {
        if (this.r != null) {
            return this.r.containsKey(Integer.valueOf(i));
        }
        return false;
    }

    public int q() {
        return this.s;
    }

    public int r() {
        return this.t;
    }

    public byte[] s() {
        return this.v;
    }

    public int[] t() {
        if (this.o == null) {
            return null;
        }
        int[] iArr = new int[this.o.size()];
        int i = 0;
        Iterator<Integer> it = this.o.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            iArr[i2] = it.next().intValue();
            i = i2 + 1;
        }
    }

    public Hashtable<Integer, String[]> u() {
        return this.o;
    }

    public Hashtable<Integer, Object> v() {
        return this.q;
    }

    public exs w() {
        return this.w;
    }

    @Override // defpackage.eur
    public eur k() {
        StuffTableStruct stuffTableStruct = new StuffTableStruct(this.u);
        stuffTableStruct.v = this.v;
        stuffTableStruct.l = this.l;
        stuffTableStruct.t = this.t;
        stuffTableStruct.s = this.s;
        stuffTableStruct.w = this.w;
        a(stuffTableStruct);
        if (this.v != null && this.v.length > 0) {
            stuffTableStruct.v = new byte[this.v.length];
            System.arraycopy(this.v, 0, stuffTableStruct.v, 0, this.v.length);
        }
        if (this.m != null && this.m.length > 0) {
            stuffTableStruct.m = new String[this.m.length];
            System.arraycopy(this.m, 0, stuffTableStruct.m, 0, this.m.length);
        }
        if (this.n != null && this.n.length > 0) {
            stuffTableStruct.n = new int[this.n.length];
            System.arraycopy(this.n, 0, stuffTableStruct.n, 0, this.n.length);
        }
        if (this.o != null && this.o.size() > 0) {
            stuffTableStruct.o = new Hashtable<>();
            stuffTableStruct.o.putAll(this.o);
        }
        if (this.p != null && this.p.size() > 0) {
            stuffTableStruct.p = new Hashtable<>();
            stuffTableStruct.p.putAll(this.p);
        }
        if (this.q != null && this.q.size() > 0) {
            stuffTableStruct.q = new Hashtable<>();
            stuffTableStruct.q.putAll(this.q);
        }
        if (this.r != null && this.r.size() > 0) {
            stuffTableStruct.r = new Hashtable<>();
            stuffTableStruct.r.putAll(this.r);
        }
        return stuffTableStruct;
    }

    @Override // defpackage.eur
    public String f() {
        return "table";
    }

    public void a(int i, String[] strArr) {
        if (this.o != null) {
            this.o.put(Integer.valueOf(i), strArr);
        }
    }

    public boolean x() {
        return this.u;
    }

    public Hashtable<Integer, Integer> y() {
        return this.r;
    }

    public void b(String str) {
        this.l = str;
    }

    public void a(String[] strArr) {
        this.m = strArr;
    }

    public void a(int[] iArr) {
        this.n = iArr;
    }

    public void a(Hashtable<Integer, String[]> hashtable) {
        this.o = hashtable;
    }

    public void b(Hashtable<Integer, int[]> hashtable) {
        this.p = hashtable;
    }

    public void c(Hashtable<Integer, Object> hashtable) {
        this.q = hashtable;
    }

    public void d(Hashtable<Integer, Integer> hashtable) {
        this.r = hashtable;
    }

    public void f(int i) {
        this.s = i;
    }

    public void g(int i) {
        this.t = i;
    }

    public void a(byte[] bArr) {
        this.v = bArr;
    }

    public void b(exs exsVar) {
        this.w = exsVar;
    }

    public void a(int i, int[] iArr) {
        if (this.p != null) {
            this.p.put(Integer.valueOf(i), iArr);
        }
    }
}