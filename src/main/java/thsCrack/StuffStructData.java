package thsCrack;

//package com.hexin.middleware.data.mobile;

import java.io.Serializable;
import java.util.Hashtable;

/* compiled from: HexinClass */
/* loaded from: classes6.dex */
public class StuffStructData implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f25234a;

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<Integer, Object> f25235b;

    /* renamed from: c  reason: collision with root package name */
    public Hashtable<Integer, Object> f25236c;

    public Object a(int i) {
        if (this.f25235b == null || this.f25235b.size() <= 0) {
            return null;
        }
        return this.f25235b.get(Integer.valueOf(b(i)));
    }

    public int b(int i) {
        Object obj;
        if (this.f25236c == null || this.f25236c.size() <= 0 || (obj = this.f25236c.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    public synchronized boolean a(int i, Object obj) {
        boolean z;
        if (i > 0 && obj != null) {
            if (this.f25236c != null && this.f25236c.containsKey(Integer.valueOf(i))) {
                this.f25235b.put((Integer) this.f25236c.get(Integer.valueOf(i)), obj);
                z = true;
            }
        }
        z = false;
        return z;
    }
}