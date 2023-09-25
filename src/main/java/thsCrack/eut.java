package thsCrack;

//package defpackage;

import java.util.Hashtable;

/* compiled from: HexinClass */
/* renamed from: eut  reason: default package */
/* loaded from: classes7.dex */
public class eut extends eur {
    protected int l;
    protected Hashtable<Integer, Integer> m;
    protected Hashtable<Integer, Integer> n;
    protected Hashtable<Integer, String> o;
    private int p;

    public int m() {
        return this.p;
    }

    public Hashtable<Integer, Integer> n() {
        return this.m;
    }

    public int a(int i) {
        if (this.m != null && this.m.size() > 0) {
            Integer num = this.m.get(Integer.valueOf(i));
            if (num instanceof Integer) {
                return num.intValue();
            }
        }
        return 0;
    }

    public String b(int i) {
        if (this.o != null && this.o.size() > 0) {
            String str = this.o.get(Integer.valueOf(i));
            if (str instanceof String) {
                return str;
            }
        }
        return null;
    }

    public int o() {
        return this.l;
    }

    public void c(int i) {
        this.p = i;
    }

    public Hashtable p() {
        return this.o;
    }

    public Hashtable<Integer, Integer> q() {
        return this.n;
    }

    public void d(int i) {
        this.l = i;
    }

    public void a(Hashtable<Integer, Integer> hashtable) {
        this.m = hashtable;
    }

    public void b(Hashtable<Integer, Integer> hashtable) {
        this.n = hashtable;
    }

    public void c(Hashtable<Integer, String> hashtable) {
        this.o = hashtable;
    }

    @Override // defpackage.eur
    public String f() {
        return "ctrl";
    }
}