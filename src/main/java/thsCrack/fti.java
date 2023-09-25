package thsCrack;

//package defpackage;
//
//import com.hexin.android.view.CangweiTips;
//import cx.hell.android.pdfview.Actions;

/* compiled from: HexinClass */
/* renamed from: fti  reason: default package */
/* loaded from: classes6.dex */
public class fti {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f39223a = {1, 10, 100, 1000, 10000, 100000, Actions.ZOOM_IN, 10000000, 100000000, 1000000000};

    public static void a(double d2, int i, boolean z, StringBuffer stringBuffer) {
        boolean z2;
        double d3;
        stringBuffer.setLength(0);
        if (i >= 0 && i < f39223a.length) {
            if (d2 == CangweiTips.MIN || d2 == Double.NaN) {
                stringBuffer.append('0');
                if (i > 0) {
                    stringBuffer.append('.');
                    for (int i2 = 0; i2 < i; i2++) {
                        stringBuffer.append('0');
                    }
                }
            } else if (i == 0) {
                if (z) {
                    d3 = d2 > CangweiTips.MIN ? 0.5d + d2 : d2 - 0.5d;
                } else {
                    d3 = d2;
                }
                stringBuffer.append((long) d3);
            } else if (i > 0) {
                if (d2 < CangweiTips.MIN) {
                    z2 = true;
                    d2 = -d2;
                } else {
                    z2 = false;
                }
                long j = (long) ((z ? 0.5d : 0.0d) + (f39223a[i] * d2));
                stringBuffer.append(j);
                double d4 = j / f39223a[i];
                if (d4 < 1.0d) {
                    if (d4 < 0.1d) {
                        int length = i - stringBuffer.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            stringBuffer.insert(0, '0');
                        }
                    }
                    stringBuffer.insert(0, "0.");
                } else if (stringBuffer.length() - i >= 0) {
                    stringBuffer.insert(stringBuffer.length() - i, '.');
                }
                if (z2) {
                    stringBuffer.insert(0, '-');
                }
            }
        }
    }
}