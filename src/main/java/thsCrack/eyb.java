package thsCrack;

//package defpackage;

//import android.util.SparseArray;
//import com.xiaomi.mipush.sdk.Constants;
//import defpackage.exz;
import java.util.Vector;

/* compiled from: HexinClass */
/* renamed from: eyb  reason: default package */
/* loaded from: classes3.dex */
public class eyb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StringBuffer stringBuffer, int i) {
        stringBuffer.append("[").append("frame").append("]").append("\r\n");
        stringBuffer.append("id").append("=").append(i).append("\r\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StringBuffer stringBuffer, Vector<exz.a> vector, boolean z, int i) {
        stringBuffer.append("pageList").append("=");
        int size = vector.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = vector.get(i2).f37594b;
            int i4 = vector.get(i2).f37595c;
            if (i3 != -2 && i3 != -1) {
                stringBuffer.append(i4);
                if (i2 < size - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (z) {
                }
            }
        }
        stringBuffer.append("\r\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StringBuffer stringBuffer, Vector<exz.a> vector, boolean z, int i, Vector<Integer> vector2) {
        stringBuffer.append("pageList").append("=");
        int size = vector.size();
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = vector.get(i2).f37594b;
            int i4 = vector.get(i2).f37595c;
            if (i3 != -2 && i3 != -1) {
                stringBuffer.append(i4);
                if (i2 < size - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (z) {
                }
            }
        }
        if (vector2 != null && vector2.size() > 0) {
            if (size > 0) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            for (int i5 = 0; i5 < vector2.size(); i5++) {
                stringBuffer.append(vector2.get(i5));
                if (i5 < vector2.size() - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        stringBuffer.append("\r\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StringBuffer stringBuffer, int[] iArr, boolean z, int i) {
        stringBuffer.append("pageList").append("=");
        if (iArr != null) {
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuffer.append(iArr[i2]);
                if (i2 < length - 1) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        stringBuffer.append("\r\n");
    }

    public static void a(StringBuffer stringBuffer, int i, int i2, String str) {
        if (-1 != i) {
            stringBuffer.append("reqPage").append("=");
            stringBuffer.append(i2);
            stringBuffer.append("\r\n");
            stringBuffer.append("reqPageCount").append("=").append(1).append("\r\n");
            stringBuffer.append("[").append(i2).append("]").append("\r\n");
            stringBuffer.append("id").append("=").append(i).append("\r\n");
            stringBuffer.append(str).append("\r\n");
        }
    }

    public static int a(StringBuffer stringBuffer, Vector<exz.a> vector, SparseArray<Integer> sparseArray) {
        int size = vector.size();
        stringBuffer.append("reqPage").append("=");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(vector.get(i).f37595c);
            if (i < size - 1) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        stringBuffer.append("\r\n");
        stringBuffer.append("reqPageCount").append("=").append(size).append("\r\n");
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = vector.get(i2).f37594b;
            int i4 = vector.get(i2).f37595c;
            sparseArray.put(i4, Integer.valueOf(i3));
            String str = vector.get(i2).f37596d;
            stringBuffer.append("[").append(i4).append("]").append("\r\n");
            stringBuffer.append("id").append("=").append(i3).append("\r\n");
            stringBuffer.append(str).append("\r\n");
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(StringBuffer stringBuffer) {
        stringBuffer.append("reqPage").append("=").append(0);
        stringBuffer.append("\r\n");
        stringBuffer.append("reqPageCount").append("=").append(0).append("\r\n");
        return 0;
    }
}