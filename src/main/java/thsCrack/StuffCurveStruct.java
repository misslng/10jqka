package thsCrack;
//package com.hexin.middleware.data.mobile;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import com.xiaomi.mipush.sdk.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/* compiled from: HexinClass */
/* loaded from: classes4.dex */
public class StuffCurveStruct extends eur implements Serializable, Cloneable {
    //    public static final Parcelable.Creator<StuffCurveStruct> CREATOR = new Parcelable.Creator<StuffCurveStruct>() { // from class: com.hexin.middleware.data.mobile.StuffCurveStruct.1
//        /* JADX DEBUG: Method merged with bridge method */
//        @Override // android.os.Parcelable.Creator
//        /* renamed from: a */
//        public StuffCurveStruct createFromParcel(Parcel parcel) {
//            return new StuffCurveStruct(parcel);
//        }
//
//        /* JADX DEBUG: Method merged with bridge method */
//        @Override // android.os.Parcelable.Creator
//        /* renamed from: a */
//        public StuffCurveStruct[] newArray(int i) {
//            return new StuffCurveStruct[i];
//        }
//    };
    
    public Hashtable<Integer, double[]> l;
    public Hashtable<Integer, double[]> m;
    public Hashtable<Integer, Object> n;
    public Hashtable<Integer, Integer> o;
    public byte[] p;
    public int q;
    public int r;
    public boolean s;
    public byte[] t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;

    public StuffCurveStruct(boolean z, byte[] bArr) {
        this.u = true;
        this.v = false;
        this.x = false;
        this.y = false;
        this.s = z;
        this.o = new Hashtable<>();
        this.p = bArr;
    }

    public StuffCurveStruct() {
        this.u = true;
        this.v = false;
        this.x = false;
        this.y = false;
    }

//    protected StuffCurveStruct(Parcel parcel) {
//        this.u = true;
//        this.v = false;
//        this.x = false;
//        this.y = false;
//        this.q = parcel.readInt();
//        this.r = parcel.readInt();
//        this.s = parcel.readByte() != 0;
//        this.t = parcel.createByteArray();
//        this.u = parcel.readByte() != 0;
//        this.v = parcel.readByte() != 0;
//        this.w = parcel.readByte() != 0;
//        this.x = parcel.readByte() != 0;
//        this.y = parcel.readByte() != 0;
//        this.p = parcel.createByteArray();
//    }

    public double[] a(int i) {
        if (this.l != null && this.l.size() > 0) {
            double[] dArr = this.l.get(Integer.valueOf(i));
            if (dArr instanceof double[]) {
                return dArr;
            }
        }
        return null;
    }

    public Object b(int i) {
        if (this.n == null || this.n.size() <= 0) {
            return null;
        }
        return this.n.get(Integer.valueOf(i));
    }

    public double c(int i) {
        Object b2 = b(i);
        if (b2 instanceof Double) {
            return ((Double) b2).doubleValue();
        }
        return -2.147483648E9d;
    }

    public int m() {
        Object b2 = b(32785);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue() + 1;
        }
        return 1;
    }

    public int n() {
        return this.q;
    }

    public void d(int i) {
        this.q = i;
    }

    public int o() {
        return this.r;
    }

    public void e(int i) {
        if (this.l == null) {
            this.r = 0;
        } else {
            this.r = i;
        }
    }

    public boolean p() {
        a(B());
        return !u();
    }

    private List<Integer> B() {
        ArrayList arrayList = new ArrayList();
        if (this.l == null) {
            return arrayList;
        }
        for (Integer num : this.l.keySet()) {
            double[] a2 = a(num.intValue());
            if (a2 != null && a2.length != this.r) {
                arrayList.add(num);
            }
        }
        return arrayList;
    }

    private void a(List<Integer> list) {
        if (this.l != null) {
            if (list.size() == 0) {
                this.v = false;
            }
            for (Integer num : list) {
                this.l.remove(num);
                this.v = true;
            }
        }
    }

    public boolean f(int i) {
        if (this.o != null) {
            return this.o.containsKey(Integer.valueOf(i));
        }
        return false;
    }

    public synchronized boolean a(int i, double[] dArr, int i2, int i3) {
        boolean z;
        int i4;
        int i5 = 0;
        synchronized (this) {
            if (i2 >= 0 || i3 > 0) {
                double[] a2 = a(i);
                if (a2 instanceof double[]) {
                    double[] dArr2 = a2;
                    if (i2 > dArr2.length) {
                        z = false;
                    } else {
                        int i6 = i2 + i3;
                        if (i6 > dArr2.length) {
                            double[] dArr3 = new double[i6];
                            System.arraycopy(dArr2, 0, dArr3, 0, i2);
                            while (i5 < i3) {
                                if (dArr != null && i5 < dArr.length) {
                                    i4 = i2 + 1;
                                    dArr3[i2] = dArr[i5];
                                } else {
                                    i4 = i2 + 1;
                                    dArr3[i2] = -2.147483648E9d;
                                }
                                i5++;
                                i2 = i4;
                            }
                            this.l.put(Integer.valueOf(i), dArr3);
                            dArr2 = dArr3;
                        } else if (dArr != null) {
                            int min = Math.min(dArr.length, i3);
                            while (i5 < min) {
                                int i7 = i2 + 1;
                                dArr2[i2] = dArr[i5];
                                i5++;
                                i2 = i7;
                            }
                        } else {
                            z = false;
                        }
                        this.r = dArr2.length;
                        z = true;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean a(int i, double[] dArr, int i2, int i3, String str) {
        boolean z;
        if (i2 < 0 || dArr == null) {
            z = false;
        } else {
            double[] a2 = a(i);
            if (a2 instanceof double[]) {
                double[] dArr2 = a2;
                int length = (dArr.length - (i2 + 1)) + dArr2.length;
                double[] dArr3 = new double[length];
                System.arraycopy(dArr2, 0, dArr3, 0, dArr2.length);
                if (length - dArr.length >= 0) {
                    System.arraycopy(dArr, 0, dArr3, length - dArr.length, dArr.length);
                } else {
                    System.arraycopy(dArr, i2, dArr3, dArr2.length - 1, dArr.length - i2);
                }
                this.l.put(Integer.valueOf(i), dArr3);
                System.out.println("Curve_Data_appendKlineDataInTail:key=" + i + ",newSize=" + length + ",sobj=" + Arrays.toString(dArr3));
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean a(int i, double[] dArr) {
        boolean z = true;
        synchronized (this) {
            if (dArr != null) {
                if (dArr.length != 0) {
                    double[] a2 = a(i);
                    if (a2 != null) {
                        double[] dArr2 = new double[dArr.length + a2.length];
                        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
                        System.arraycopy(a2, 0, dArr2, dArr.length, a2.length);
                        this.l.put(Integer.valueOf(i), dArr2);
                        this.r = dArr2.length;
                    } else {
                        this.l.put(Integer.valueOf(i), dArr);
                        this.r = dArr.length;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean a(int i, double[] dArr, int i2) {
        boolean z;
        if (i2 >= 0 && dArr != null) {
            if (i2 <= dArr.length) {
                double[] a2 = a(i);
                if (a2 instanceof double[]) {
                    double[] dArr2 = a2;
                    int length = dArr2.length + i2;
                    if (length >= dArr.length) {
                        double[] dArr3 = new double[length];
                        System.arraycopy(dArr2, 0, dArr3, i2, dArr2.length);
                        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
                        this.l.put(Integer.valueOf(i), dArr3);
                        System.out.println("Curve_Data_appendKlineDataInHead:key=" + i + ",newSize=" + length + ",sobj=" + Arrays.toString(dArr3));
                    }
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean b(int i, double[] dArr, int i2) {
        boolean z;
        if (i2 < 0 || dArr == null) {
            z = false;
        } else {
            double[] a2 = a(i);
            if (a2 instanceof double[]) {
                double[] dArr2 = a2;
                int length = dArr2.length;
                int length2 = dArr.length;
                if (i2 > length) {
                    z = false;
                } else {
                    int i3 = ((i2 + length2) - length) + length;
                    if (i3 < length) {
                        z = false;
                    } else {
                        double[] dArr3 = new double[i3];
                        System.arraycopy(dArr2, 0, dArr3, 0, length);
                        System.arraycopy(dArr, 0, dArr3, i2, length2);
                        this.l.put(Integer.valueOf(i), dArr3);
                        System.out.println( "Curve_Data_appendKlineDataInTail:key=" + i + ",newSize=" + i3 + ",sobj=" + Arrays.toString(dArr3));
                        z = true;
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean a(int i, Object obj) {
        boolean z;
        if (i <= 0 || obj == null) {
            z = false;
        } else {
            this.n.put(Integer.valueOf(i), obj);
            z = true;
        }
        return z;
    }

    public byte[] q() {
        return this.t;
    }

    public void a(byte[] bArr) {
        this.t = bArr;
    }

    public boolean r() {
        return this.l == null;
    }

    public boolean s() {
        return this.w;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public boolean t() {
        return this.u;
    }

    public void e(boolean z) {
        this.u = z;
    }

//    @Override // android.os.Parcelable
//    public int describeContents() {
//        return 0;
//    }

//    @Override // android.os.Parcelable
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(this.q);
//        parcel.writeInt(this.r);
//        parcel.writeByte((byte) (this.s ? 1 : 0));
//        parcel.writeByteArray(this.t);
//        parcel.writeByte((byte) (this.u ? 1 : 0));
//        parcel.writeByte((byte) (this.v ? 1 : 0));
//        parcel.writeByte((byte) (this.w ? 1 : 0));
//        parcel.writeByte((byte) (this.x ? 1 : 0));
//        parcel.writeByte((byte) (this.y ? 1 : 0));
//        parcel.writeByteArray(this.p);
//    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.x;
    }

    public void f(boolean z) {
        this.x = z;
    }

    public String w() {
        StringBuilder sb = new StringBuilder();
        if (this.n != null && this.n.size() > 0) {
            for (Integer num : this.n.keySet()) {
                Object obj = this.n.get(num);
                if (obj != null) {
                    sb.append(num).append("=").append(obj.toString()).append(" ");
                }
            }
        }
        sb.append("\n");
        sb.append("Source\n");
        a(sb, this.l);
        sb.append("Copy\n");
        a(sb, this.m);
        return sb.toString();
    }

    private void a(StringBuilder sb, Hashtable<Integer, double[]> hashtable) {
        if (hashtable != null && hashtable.size() > 0 && sb != null) {
            for (Integer num : hashtable.keySet()) {
                double[] dArr = hashtable.get(num);
                if (dArr != null) {
                    sb.append("dataCount=").append(dArr.length).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(num).append("=").append(Arrays.toString(dArr)).append("\n\n");
                }
            }
        }
    }

    public boolean x() {
        return this.y;
    }

    public void g(boolean z) {
        this.y = z;
    }

    @Override // defpackage.eur
    public String f() {
        return "curve";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: y  reason: collision with other method in class */
    public StuffCurveStruct clone() {
        try {
            return (StuffCurveStruct) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean z() {
        return this.s;
    }

    public void h(boolean z) {
        this.s = z;
    }

    public void i(boolean z) {
        this.v = z;
    }

    public Hashtable<Integer, Integer> A() {
        return this.o;
    }

    public void a(Hashtable<Integer, Integer> hashtable) {
        this.o = hashtable;
    }
}