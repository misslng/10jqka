package thsCrack;
//
//package defpackage;

//import com.assistant.voicecustomized.voicerecord.view.VoiceRecordView;
//import com.hexin.android.component.firstpage.feed.toutiao.views.items.BasicIndividualItem;
//import com.hexin.android.view.CangweiTips;
//import com.hexin.middleware.data.mobile.StuffCurveStruct;
//import com.hexin.middleware.data.mobile.StuffStructData;
//import com.hexin.middleware.data.mobile.StuffTableStruct;
//import cx.hell.android.pdfview.Actions;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
//import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: HexinClass */
/* renamed from: eus */
/* loaded from: classes6.dex */
public final class eus {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [161=5, 162=5, 164=5, 166=5] */
    public static final void a(byte[] bArr, int i, int i2, eur eurVar, exs exsVar, byte[] bArr2) {
        ftf ftfVar;
        byte[] bArr3;
        ftf ftfVar2;
        AutoCloseable autoCloseable = null;
        if (eurVar == null || bArr == null || (i | i2) < 0) {
            return;
        }
        try {
            if (i2 <= bArr.length - i) {
                try {
                    ftfVar = new ftf(new ByteArrayInputStream(bArr, i, i2));
                } catch (Exception e3) {
                    //e = e3;
                    ftfVar = null;
                } catch (OutOfMemoryError e4) {
                    ftfVar = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            autoCloseable.close();
                        } catch (IOException e5) {
                            System.out.println(e5);
                        }
                    }
                    throw th;
                }
                try {
                    if (eurVar instanceof eut) {
                        a(ftfVar, (eut) eurVar);
                    } else if (eurVar instanceof StuffCurveStruct) {
                        StuffCurveStruct stuffCurveStruct = (StuffCurveStruct) eurVar;
                        if (ftfVar.available() > 24) {
                            b bVar = new b();
                            ftf d2 = bVar.d(ftfVar);
                            a(bVar, d2, stuffCurveStruct);
                            if (stuffCurveStruct.s) {
                                byte[] bArr4 = new byte[bArr.length];
                                System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
                                stuffCurveStruct.t = bArr4;
                            }
                            ftfVar2 = d2;
                        } else {
                            ftfVar2 = ftfVar;
                        }
                        ftfVar = ftfVar2;
                    } else if (eurVar instanceof StuffTableStruct) {
                        StuffTableStruct stuffTableStruct = (StuffTableStruct) eurVar;
                        if (ftfVar.available() > 24) {
                            b bVar2 = new b();
                            ftfVar = bVar2.d(ftfVar);
                            a(bVar2, ftfVar, stuffTableStruct);
                            stuffTableStruct.w = exsVar;
                            if (stuffTableStruct.u) {
                                if (0x10000000 == (exsVar.d() & (0xF0000000))) {
                                    bArr3 = new byte[bArr.length + 24];
                                    System.arraycopy(exsVar.a(), 0, bArr3, 0, 24);
                                    System.arraycopy(bArr, 0, bArr3, 24, bArr.length);
                                } else {
                                    bArr3 = new byte[bArr.length];
                                    System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                                }
                                stuffTableStruct.v = bArr3;
                            }
                        }
                    } else if (eurVar instanceof euw) {
                        a(ftfVar, (euw) eurVar);
                    } else if (eurVar instanceof euu) {
                        a(ftfVar, (euu) eurVar);
                    }
                    if (ftfVar != null) {
                        try {
                            ftfVar.close();
                        } catch (IOException e6) {
                            System.out.println(e6);
                        }
                    }
                } catch (IOException e7) {
                    //e = e7;
                    System.out.println(e7.getMessage());
                    if (ftfVar != null) {
                        try {
                            ftfVar.close();
                        } catch (IOException e8) {
                            System.out.println(e8);
                        }
                    }
                } catch (Exception e9) {
                    //e = e9;
                    System.out.println(e9.getMessage());
                    if (ftfVar != null) {
                        try {
                            ftfVar.close();
                        } catch (IOException e10) {
                            System.out.println(e10);
                        }
                    }
                } catch (OutOfMemoryError e11) {
                    eurVar.b(true);
                    if (ftfVar != null) {
                        try {
                            ftfVar.close();
                        } catch (IOException e12) {
                            System.out.println(e12);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            //th = th2;
        }
    }

    public static final int a(int i) {
        switch (i & 0xF0) {
            case 0:
                return 1;
            case 15:
            case 48:
                return 4;
            case 16:
                return 2;
            case 32:
                return 3;
            case 64:
                return 5;
            default:
                return 0;
        }
    }

    private static final void a(ftf ftfVar, eut eutVar) throws IOException, EOFException {
        Hashtable<Integer, String> hashtable;
        Hashtable<Integer, Integer> hashtable2;
        Hashtable<Integer, Integer> hashtable3;
        byte readByte = ftfVar.readByte();
        eutVar.c(readByte);
        int readUnsignedByte = ftfVar.readUnsignedByte();
        eutVar.l = readUnsignedByte;
        System.out.println("stuffCtrlData"+ "stuffCtrlData=================================================================\nctrlCount=" + ((int) readByte) + ", ctrlFocusIndex=" + readUnsignedByte);
        if (readByte > 0) {
            hashtable3 = new Hashtable<>(readByte);
            Hashtable<Integer, Integer> hashtable4 = new Hashtable<>(readByte);
            hashtable = new Hashtable<>(readByte);
            eutVar.m = hashtable3;
            eutVar.n = hashtable4;
            eutVar.o = hashtable;
            hashtable2 = hashtable4;
        } else {
            hashtable = null;
            hashtable2 = null;
            hashtable3 = null;
        }
        for (int i = 0; i < readByte; i++) {
            int readUnsignedShort = ftfVar.readUnsignedShort();
            int readInt = ftfVar.readInt();
            int readUnsignedByte2 = ftfVar.readUnsignedByte();
            String readUTF = ftfVar.readUTF();
            
            System.out.println("stuffCtrlData"+ "dataId=" + readUnsignedShort + ",ctrlType=" + readInt + ",colorIndex=" + readUnsignedByte2 + ",content=" + readUTF);
            hashtable3.put(Integer.valueOf(readUnsignedShort), Integer.valueOf(readInt));
            hashtable2.put(Integer.valueOf(readUnsignedShort), Integer.valueOf(readUnsignedByte2));
            hashtable.put(Integer.valueOf(readUnsignedShort), readUTF);
        }
    }

    private static final void a(b bVar, ftf ftfVar, StuffCurveStruct stuffCurveStruct) throws IOException {
        if (ftfVar != null) {
            b(bVar, ftfVar, stuffCurveStruct);
            c(bVar, ftfVar, stuffCurveStruct);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v29, types: [int] */
    private static final void b(b bVar, ftf ftfVar, StuffCurveStruct stuffCurveStruct) throws IOException {
        int available = bVar.i - ftfVar.available();
        System.out.println("stuffCurveData"+ "enter into readCurveExtData readedHeaderSize=" + available);
        if (bVar.f37133e > available) {
            short readShort = ftfVar.readShort();
            Hashtable<Integer, Object> hashtable = readShort > 0 ? new Hashtable<>(readShort) : null;
            Hashtable<Integer, Integer> hashtable2 = stuffCurveStruct.o;
            fth fthVar = new fth();
            for (short s = 0; s < readShort; s++) {
                int readUnsignedShort = ftfVar.readUnsignedShort();
                Integer valueOf = Integer.valueOf(0x8FFF & readUnsignedShort);
                switch (readUnsignedShort & 0x7000) {
                    case 0:
                        String readUTF = ftfVar.readUTF();
                        
                        System.out.println("stuffCurveData"+ "TYPE_STRING " + readUTF);
                        if (readUTF == null) {
                            continue;
                        } else {
                            hashtable.put(valueOf, readUTF);
                            break;
                        }
                    case 4096:
                        fthVar.a(ftfVar.a());
                        double b2 = fthVar.b();
                        System.out.println("stuffCurveData"+ "TYPE_HXLONG " + b2);
                        hashtable.put(valueOf, Double.valueOf(b2));
                        break;
                    case 8192:
                        int readInt = ftfVar.readInt();
                        System.out.println("stuffCurveData"+ "TYPE_INT " + readInt);
                        hashtable.put(valueOf, Integer.valueOf(readInt));
                        break;
                    case 12288 /* 12288 */:
                        short readShort2 = ftfVar.readShort();
                        System.out.println("stuffCurveData"+ "TYPE_SHORT " + ((int) readShort2));
                        hashtable.put(valueOf, Integer.valueOf(readShort2));
                        break;
                    case 20480:
                        System.out.println("stuffCurveData"+ "TYPE_DOUBLE stream.skip(8)");
                        ftfVar.skip(8L);
                        continue;
                    case 24576 /* 24576 */:
                        int readShort3 = ftfVar.readShort();
                        if (readShort3 <= 0) {
                            continue;
                        } else if (readShort3 <= 100) {
                            int[] iArr = new int[readShort3];
                            for (int i = 0; i < readShort3; i++) {
                                iArr[i] = ftfVar.readInt();
                            }
                            System.out.println("stuffCurveData"+ "TYPE_ARRAY_INT " + Arrays.toString(iArr));
                            hashtable.put(valueOf, iArr);
                            break;
                        }
                    case 0x7000:
                        short readShort4 = ftfVar.readShort();
                        if (readShort4 > 0) {
                            int readUnsignedShort2 = ftfVar.readUnsignedShort();
                            short readShort5 = ftfVar.readShort();
                            byte[] bArr = new byte[readShort4 - 6];
                            ftfVar.readFully(bArr);
                            d dVar = new d();
                            dVar.f37139a = readUnsignedShort2;
                            dVar.f37140b = readShort5;
                            dVar.f37141c = bArr;
                            if (readUnsignedShort2 == 1) {
                                StuffStructData a2 = a(dVar);
                                System.out.println("stuffCurveData"+ "TYPE_STRUCT STRUCT_QUAN " + a2);
                                if (a2 != null) {
                                    hashtable.put(valueOf, a2);
                                    break;
                                }
                            } else {
                                System.out.println("stuffCurveData"+ "TYPE_STRUCT not STRUCT_QUAN " + dVar);
                                hashtable.put(valueOf, dVar);
                                break;
                            }
                        } else {
                            continue;
                        }
                    default:
                }
                hashtable2.put(valueOf, Integer.valueOf(readUnsignedShort));
            }
            stuffCurveStruct.n = hashtable;
        }
        int available2 = bVar.i - ftfVar.available();
        if (bVar.f37133e > available2) {
            int i2 = bVar.f37133e - available2;
            System.out.println("stuffCurveData"+ "扩展数据2 length= " + i2 + ",stream.skip(" + i2 + ")");
            ftfVar.skip(i2);
        }
        System.out.println("stuffCurveData"+ "leave readCurveExtData");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[CONST_STR, CONST_STR, INVOKE, CONST_STR, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v23, types: [int] */
    private static StuffStructData a(d dVar) {
        Exception exc;
        StuffStructData stuffStructData;
        StuffStructData stuffStructData2;
        Hashtable<Integer, Object> hashtable;
        Hashtable<Integer, Object> hashtable2;
        StuffStructData stuffStructData3;
        int i;
        System.out.println("stuffCurveData"+ "enter into stuffStructData");
        if (dVar == null || dVar.a() == null || dVar.a().length <= 0) {
            return null;
        }
        erb erbVar = new erb(new ByteArrayInputStream(dVar.a()));
        try {
            try {
                int i2 = dVar.f37139a;
                int i3 = dVar.f37140b;
                c cVar = new c();
                boolean z = false;
                boolean z2 = false;
                switch (i2) {
                    case 1:
                        z = i3 == 0;
                        break;
                    case 4:
                    case 5:
                        z2 = i3 == 0;
                        break;
                }
                if (!z && !z2) {
                    stuffStructData2 = null;
                } else {
                    int i4 = z ? 2 : 1;
                    System.out.println("stuffCurveData"+ "structType=" + i2 + ",structVer=" + i3 + ",isQuan=" + z + ",isLandmine=" + z2 + ",step=" + i4);
                    StuffStructData stuffStructData4 = null;
                    for (int i5 = 0; i5 < i4; i5++) {
                        try {
                            short readShort = erbVar.readShort();
                            int readShort2 = erbVar.readShort();
                            System.out.println("stuffCurveData"+ "itemCount=" + ((int) readShort) + ",dataCount=" + readShort2);
                            if (readShort != 0) {
                                if (readShort2 == 0) {
                                    for (int i6 = 0; i6 < readShort; i6++) {
                                        erbVar.readShort();
                                    }
                                } else {
                                    if (stuffStructData4 == null) {
                                        hashtable = new Hashtable<>(readShort);
                                        hashtable2 = new Hashtable<>(readShort);
                                        stuffStructData3 = new StuffStructData();
                                        try {
                                            stuffStructData3.f25235b = hashtable2;
                                            stuffStructData3.f25236c = hashtable;
                                            stuffStructData3.f25234a = i2;
                                        } catch (Exception e2) {
                                            exc = e2;
                                            stuffStructData = stuffStructData3;
                                            System.out.println(exc);
                                            return stuffStructData;
                                        }
                                    } else {
                                        hashtable = stuffStructData4.f25235b;
                                        hashtable2 = stuffStructData4.f25236c;
                                        stuffStructData3 = stuffStructData4;
                                    }
                                    for (short s = 0; s < readShort; s++) {
                                        int readShort3 = erbVar.readShort();
                                        int i7 = 0x8FFF & readShort3;
                                        int i8 = readShort3 & 0x7000;
                                        System.out.println("stuffCurveData"+ "type=" + readShort3 + ",id=" + i7 + ",itemType=" + i8);
                                        if (i4 == 1 && i7 == 1) {
                                            readShort3 = 801 | i8;
                                            i = 801;
                                        } else {
                                            i = i7;
                                        }
                                        switch (i8) {
                                            case 0:
                                                String[] strArr = new String[readShort2];
                                                for (int i9 = 0; i9 < readShort2; i9++) {
                                                    strArr[i9] = erbVar.readUTF();
                                                }
                                                System.out.println("stuffCurveData"+ "TYPE_String intArray=" + Arrays.toString(strArr));
                                                hashtable2.put(Integer.valueOf(readShort3), strArr);
                                                hashtable.put(Integer.valueOf(i), Integer.valueOf(readShort3));
                                                break;
                                            case 4096:
                                                double[] dArr = new double[readShort2];
                                                for (int i10 = 0; i10 < readShort2; i10++) {
                                                    long a2 = erbVar.a();
                                                    if (a2 != 0) {
                                                        cVar.a(a2);
                                                        dArr[i10] = cVar.b();
                                                    }
                                                }
                                                System.out.println("stuffCurveData"+ "TYPE_HXLONG doubleArray=" + Arrays.toString(dArr));
                                                hashtable2.put(Integer.valueOf(readShort3), dArr);
                                                hashtable.put(Integer.valueOf(i), Integer.valueOf(readShort3));
                                                break;
                                            case 8192:
                                                int[] iArr = new int[readShort2];
                                                for (int i11 = 0; i11 < readShort2; i11++) {
                                                    iArr[i11] = erbVar.readInt();
                                                }
                                                System.out.println("stuffCurveData"+ "TYPE_INT intArray=" + Arrays.toString(iArr));
                                                hashtable2.put(Integer.valueOf(readShort3), iArr);
                                                hashtable.put(Integer.valueOf(i), Integer.valueOf(readShort3));
                                                break;
                                        }
                                    }
                                    stuffStructData4 = stuffStructData3;
                                }
                            }
                        } catch (Exception e3) {
                            exc = e3;
                            stuffStructData = stuffStructData4;
                        }
                    }
                    stuffStructData2 = stuffStructData4;
                }
                try {
                    erbVar.close();
                } catch (IOException e4) {
                    System.out.println(e4);
                }
                System.out.println("stuffCurveData"+ "leave stuffStructData");
                return stuffStructData2;
            } finally {
                try {
                    erbVar.close();
                } catch (IOException e5) {
                    System.out.println(e5);
                }
                System.out.println("stuffCurveData"+ "leave stuffStructData");
            }
        } catch (Exception e6) {
            exc = e6;
            stuffStructData = null;
        }
        return null;
    }


    private static final void c(b bVar, ftf ftfVar, StuffCurveStruct stuffCurveStruct) throws IOException {
        double[] dArr;
        int i = bVar.f37130b;
        int i2 = bVar.g;
        int i3 = bVar.f37132d;
        System.out.println("stuffCurveData"+ "enter into readCurveData points=" + i + ",fields=" + i2 + ",firstIndex=" + i3);
        if (i > 0 && i2 > 0 && i3 >= 0) {
            Hashtable<Integer, double[]> hashtable = new Hashtable<>(i2);
            Hashtable<Integer, Integer> hashtable2 = stuffCurveStruct.o;
            fth fthVar = new fth();
            for (int i4 = 0; i4 < i; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bVar.h[i5].f37126a;
                    Integer valueOf = Integer.valueOf(0x8FFF & i6);
                    if (i4 == 0) {
                        hashtable2.put(valueOf, Integer.valueOf(i6));
                        double[] dArr2 = new double[i];
                        hashtable.put(valueOf, dArr2);
                        dArr = dArr2;
                    } else {
                        dArr = hashtable.get(valueOf);
                    }
                    switch (i6 & 0x7000) {
                        case 4096:
                            fthVar.a(ftfVar.a());
                            dArr[i4] = fthVar.c() ? -2.147483648E9d : fthVar.b();
                            break;
                        case 8192:
                            dArr[i4] = ftfVar.readInt();
                            break;
                        case 12288 /* 12288 */:
                            dArr[i4] = ftfVar.readShort();
                            break;
                    }
                }
            }
            stuffCurveStruct.l = hashtable;
            stuffCurveStruct.r = i;
            stuffCurveStruct.q = i3;
            System.out.println("stuffCurveData"+ "leave readCurveData");
        }
    }

    private static final void a(b bVar, ftf ftfVar, StuffTableStruct stuffTableStruct) throws IOException {
        if (ftfVar != null) {
            stuffTableStruct.l = ftfVar.readUTF();
            System.out.println("stuffTableData"+"stuffTableData=============================================================================\ntable caption=" + stuffTableStruct.l);
            b(bVar, ftfVar, stuffTableStruct);
            c(bVar, ftfVar, stuffTableStruct);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    private static final void b(b bVar, ftf ftfVar, StuffTableStruct stuffTableStruct) throws IOException {
        int available = 0;
        int i = bVar.i;
        if (bVar.f37133e > i - ftfVar.available()) {
            String[] strArr = new String[bVar.g];
            int[] iArr = new int[bVar.g];
            boolean z = false;
            for (int i2 = 0; i2 < bVar.g; i2++) {
                String readUTF = ftfVar.readUTF();
                if (readUTF != null) {
                    z = true;
                    strArr[i2] = readUTF;
                }
                iArr[i2] = bVar.h[i2].f37126a & 0x8FFF;
            }
            if (z) {
                stuffTableStruct.m = strArr;
                stuffTableStruct.n = iArr;
            }
            System.out.println("stuffTableData"+"readTableExtData tableHead=" + Arrays.toString(stuffTableStruct.m));
        }
        if (bVar.f37133e > i - ftfVar.available()) {
            short readShort = ftfVar.readShort();
            if (readShort >= 0 && readShort <= 100) {
                Hashtable<Integer, Object> hashtable = new Hashtable<>(readShort);
                Hashtable<Integer, Integer> hashtable2 = stuffTableStruct.r;
                for (short s = 0; s < readShort; s++) {
                    int readUnsignedShort = ftfVar.readUnsignedShort();
                    Integer valueOf = Integer.valueOf(readUnsignedShort & 0x8FFF);
                    switch (readUnsignedShort & 0x7000) {
                        case 0:
                            String readUTF2 = ftfVar.readUTF();
                            if (readUTF2 == null) {
                                continue;
                            } else {
                                hashtable.put(valueOf, readUTF2);
                                break;
                            }
                        case 8192:
                            if (valueOf.intValue() == 34068) {
                                hashtable.put(valueOf, ftfVar.a());
                                break;
                            } else {
                                hashtable.put(valueOf, ftfVar.readInt());
                                break;
                            }
                        case 24576 /* 24576 */:
                            switch (valueOf.intValue()) {
                                case 32776:
                                    int readShort2 = ftfVar.readShort();
                                    if (readShort2 > 0) {
                                        int[] iArr2 = new int[readShort2];
                                        for (int i3 = 0; i3 < readShort2; i3++) {
                                            iArr2[i3] = ftfVar.readInt();
                                        }
                                        hashtable.put(valueOf, iArr2);
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            break;
                        default:
                    }
                    hashtable2.put(valueOf, Integer.valueOf(readUnsignedShort));
                }
                stuffTableStruct.q = hashtable;
            } else {
                return;
            }
        }
        if (bVar.f37133e > i - ftfVar.available()) {
            ftfVar.skip(bVar.f37133e - available);
        }
    }

    private static final void c(b bVar, ftf ftfVar, StuffTableStruct stuffTableStruct) throws IOException {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr2;
        String[] strArr;
        byte readByte;
        int i5 = bVar.f37130b;
        int i6 = bVar.g;
        boolean e2 = stuffTableStruct.e(32776);
        if (!e2) {
            iArr = null;
            i = i6;
            i2 = i5;
        } else {
            Object c2 = stuffTableStruct.c(32776);
            if (!(c2 instanceof int[])) {
                return;
            }
            int i7 = bVar.g;
            iArr = (int[]) c2;
            i = bVar.f37130b;
            i2 = i7;
        }
        if (i2 > 0 && i > 0) {
            Hashtable<Integer, String[]> hashtable = new Hashtable<>(i);
            Hashtable<Integer, int[]> hashtable2 = new Hashtable<>(i);
            Hashtable<Integer, Integer> hashtable3 = stuffTableStruct.r;
            fth fthVar = new fth();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i8 = 0; i8 < i2; i8++) {
                for (int i9 = 0; i9 < i; i9++) {
                    stringBuffer.setLength(0);
                    if (e2) {
                        i3 = iArr[i9];
                        i4 = bVar.h[i8].f37126a | i3;
                    } else {
                        int i10 = bVar.h[i9].f37126a;
                        i3 = 0x8FFF & i10;
                        i4 = i10;
                    }
                    Integer valueOf = Integer.valueOf(i3);
                    if (i8 == 0) {
                        hashtable3.put(valueOf, Integer.valueOf(i4));
                        String[] strArr2 = new String[i2];
                        iArr2 = new int[i2];
                        hashtable.put(valueOf, strArr2);
                        hashtable2.put(valueOf, iArr2);
                        strArr = strArr2;
                    } else {
                        iArr2 = hashtable2.get(valueOf);
                        strArr = hashtable.get(valueOf);
                    }
                    switch (i4 & 0x7000) {
                        case 0:
                            String a2 = ftfVar.a(e2 ? bVar.h[i8].f37127b / 2 : bVar.h[i9].f37127b / 2);
                            readByte = ftfVar.readByte();
                            if (a2 != null) {
                                stringBuffer.append(a2.trim());
                                a(readByte, stringBuffer);
                                strArr[i8] = stringBuffer.toString();
                                iArr2[i8] = b(readByte);
                                break;
                            } else {
                                break;
                            }
                        case 4096:
                            fthVar.a(ftfVar.a());
                            readByte = ftfVar.readByte();
                            a(fthVar, readByte, stringBuffer);
                            strArr[i8] = stringBuffer.toString();
                            iArr2[i8] = b(readByte);
                            break;
                        case 8192:
                            int readInt = ftfVar.readInt();
                            readByte = ftfVar.readByte();
                            stringBuffer.append(readInt);
                            a(readByte, stringBuffer);
                            strArr[i8] = stringBuffer.toString();
                            iArr2[i8] = b(readByte);
                            break;
                        case 12288 /* 12288 */:
                            short readShort = ftfVar.readShort();
                            readByte = ftfVar.readByte();
                            stringBuffer.append((int) readShort);
                            a(readByte, stringBuffer);
                            strArr[i8] = stringBuffer.toString();
                            iArr2[i8] = b(readByte);
                            break;
                    }
                }
            }
            stuffTableStruct.s = i2;
            stuffTableStruct.t = i;
            stuffTableStruct.o = hashtable;
            stuffTableStruct.p = hashtable2;
        }
    }

    public static final int b(int i) {
        return fse.b(i & 15);
    }

    public static final void a(fth fthVar, int i, StringBuffer stringBuffer) {
        if (fthVar.c()) {
            String a2 = fse.a();
            if (a2 != null) {
                stringBuffer.append(a2);
                return;
            }
            return;
        }
        fti.a(fthVar.b(), fthVar.a(), true, stringBuffer);
        a(i, stringBuffer);
    }

    private static final void a(int i, StringBuffer stringBuffer) {
        String a2 = fse.a(i & 240);
        if (a2 != null) {
            stringBuffer.append(a2);
        }
    }

    private static final void a(ftf ftfVar, euw euwVar) throws IOException {
        euwVar.l = ftfVar.readUTF();
        euwVar.m = ftfVar.readUTF();
        if (ftfVar.available() >= 6) {
            ftfVar.skipBytes(2);
            euwVar.o = ftfVar.readInt();
        }
        if (ftfVar.available() >= 6) {
            ftfVar.skipBytes(2);
            euwVar.p = ftfVar.readInt();
        }
        System.out.println("stuffTextData"+ "stuffTextData======================================================\nstruct.id=" + euwVar.o + ",type=" + euwVar.n + ",title=" + euwVar.l + ",content=" + euwVar.m + ",reCode=" + euwVar.p);
    }

    private static final void a(ftf ftfVar, euu euuVar) throws IOException {
        euuVar.l = ftfVar.a(ftfVar.readUnsignedShort());
        euuVar.m = ftfVar.a(ftfVar.readUnsignedShort());
        int readUnsignedShort = ftfVar.readUnsignedShort();
        if (readUnsignedShort > 0) {
            euuVar.p = ftfVar.a(readUnsignedShort);
        }
        int readUnsignedShort2 = ftfVar.readUnsignedShort();
        if (readUnsignedShort2 > 0) {
            euuVar.q = ftfVar.a(readUnsignedShort2);
        }
        if (ftfVar.available() >= 6) {
            ftfVar.skipBytes(2);
            euuVar.n = ftfVar.readInt();
        }
        if (ftfVar.available() >= 6) {
            ftfVar.skipBytes(2);
            euuVar.o = ftfVar.readInt();
        }
        System.out.println("stuffInteractData"+ "stuffInteractData======================================================\nstruct.id=" + euuVar.o + ",type=" + euuVar.n + ",title=" + euuVar.l + ",content=" + euuVar.m);
    }

    /* compiled from: HexinClass */
    /* renamed from: eus$a */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a */
        private int f37126a;

        /* renamed from: b */
        private int f37127b;

        /* renamed from: c */
        private int f37128c;

        private a() {
        }

        public void a(ftf ftfVar) throws IOException {
            if (ftfVar != null && ftfVar.available() >= 4) {
                this.f37126a = ftfVar.readUnsignedShort();
                this.f37127b = ftfVar.readUnsignedByte();
                this.f37128c = ftfVar.readUnsignedByte();
            }
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: eus$b */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a */
        private byte[] f37129a;

        /* renamed from: b */
        private int f37130b;

        /* renamed from: c */
        private long f37131c;

        /* renamed from: d */
        private int f37132d;

        /* renamed from: e */
        private int f37133e;
        private int f;
        private int g;
        private a[] h;
        private int i;

        private b() {
            this.f37129a = new byte[6];
        }

        private static final String a(int i, int i2) {
            if (i > 9 || i < 1 || i2 > 9 || i2 < -1) {
                return null;
            }
            if (i2 <= -1) {
                return "cv" + i + VoiceRecordView.POINT;
            }
            return "cv" + i + VoiceRecordView.POINT + i2;
        }

        private static final String b(int i, int i2) {
            if (i > 9 || i < 1 || i2 > 9 || i2 < -1) {
                return null;
            }
            if (i2 <= -1) {
                return "tb" + i + VoiceRecordView.POINT;
            }
            return "tb" + i + VoiceRecordView.POINT + i2;
        }

        private static final int a(ftf ftfVar) throws IOException {
            byte[] bArr = new byte[4];
            ftfVar.readFully(bArr);
            int i = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = i << 8;
                if (bArr[i2] < 0) {
                    i3 += 256;
                }
                i = bArr[i2] + i3;
            }
            return i;
        }

        private boolean c(int i, int i2) {
            if (i > 9 || i < 1 || i2 > 9 || i2 < -1 || this.f37129a == null) {
                return false;
            }
            String lowerCase = new String(this.f37129a).toLowerCase();
            String str = null;
            if (lowerCase.startsWith("tb")) {
                str = b(i, i2);
            } else if (lowerCase.startsWith("cv")) {
                str = a(i, i2);
            }
            if (str != null) {
                if (i2 >= 0) {
                    return lowerCase.equals(str);
                }
                return lowerCase.regionMatches(0, str, 0, 4);
            }
            return false;
        }

        private ftf b(ftf ftfVar) throws OutOfMemoryError, IOException {
            int available;
            if (ftfVar != null && c(3, -1) && (available = this.i - ftfVar.available()) < this.f37133e) {
                int i = this.f37133e - available;
                byte[] bArr = new byte[i];
                ftfVar.readFully(bArr);
                int i2 = this.f * this.f37130b;
                int readInt = ftfVar.readInt();
                int a2 = a(ftfVar);
                try {
                    byte[] bArr2 = new byte[a2 + 1];
                    byte[] bArr3 = new byte[ftfVar.available()];
                    ftfVar.readFully(bArr3);
                    if (ftj.a(bArr3, 0, readInt, bArr2, a2) == i2) {
                        byte[] bArr4 = new byte[i2 + i + 4];
                        System.arraycopy(bArr, 0, bArr4, 0, i);
                        int i3 = 0;
                        int i4 = 0;
                        while (i4 < this.f) {
                            int i5 = 0;
                            int i6 = i;
                            while (i5 < this.f37130b) {
                                bArr4[i6] = bArr2[i3];
                                i6 += this.f;
                                i5++;
                                i3++;
                            }
                            i4++;
                            i++;
                        }
                        try {
                            ftfVar.close();
                        } catch (IOException e2) {
                        }
                        this.i = bArr4.length + available;
                        return new ftf(new ByteArrayInputStream(bArr4));
                    }
                    return ftfVar;
                } catch (OutOfMemoryError e3) {
                    throw e3;
                }
            }
            return ftfVar;
        }

        private void c(ftf ftfVar) throws IOException {
            ftfVar.readFully(this.f37129a);
            this.f37130b = ftfVar.readInt();
            this.f37131c = ftfVar.a();
            this.f37132d = ftfVar.readInt();
            this.f37133e = ftfVar.readUnsignedShort();
            this.f = ftfVar.readUnsignedShort();
            this.g = ftfVar.readUnsignedShort();
            if (this.g > 0) {
                this.h = new a[this.g];
                for (int i = 0; i < this.g; i++) {
                    this.h[i] = new a();
                    this.h[i].a(ftfVar);
                }
            }
        }

        public ftf d(ftf ftfVar) throws IOException {
            this.i = ftfVar != null ? ftfVar.available() : 0;
            if (this.i >= 28) {
                c(ftfVar);
                return b(ftfVar);
            }
            return ftfVar;
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: eus$c */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: d */
        private int f37137d;

        /* renamed from: e */
        private int f37138e;
        private int f;
        private int g;
        private long h;

        /* renamed from: b */
        private static final long f37135b = Long.parseLong("80000000", 16);

        /* renamed from: c */
        private static final long f37136c = Long.parseLong("FFFFFFFF", 16);

        /* renamed from: a */
        public static final int[] f37134a = {1, 10, 100, 1000, 10000, 100000, Actions.ZOOM_IN, 10000000, 100000000};

        public c() {
            c();
        }

        public void a(long j) {
            if (j == 0) {
                c();
                return;
            }
            this.h = j;
            this.f37137d = (int) (134217727 & j);
            this.f37138e = (int) ((134217728 & j) >> 27);
            this.f = (int) ((1879048192 & j) >> 28);
            this.g = (int) (((-2147483648L) & j) >> 31);
        }

        private void c() {
            this.h = 0L;
            this.f37137d = 0;
            this.f37138e = 0;
            this.f = 0;
            this.g = 0;
        }

        private boolean d() {
            return this.f37138e == 0 && this.f == 0 && this.f37137d == 0 && this.g == 0;
        }

        public boolean a() {
            return this.h == -2147483648L || this.h == -1 || this.h == f37135b || this.h == f37136c;
        }

        public double b() {
            double d2;
            if (a()) {
                return -2.147483648E9d;
            }
            if (d()) {
                return CangweiTips.MIN;
            }
            double d3 = f37134a[this.f] * 1.0d;
            if (this.g == 1) {
                d2 = this.f37137d / d3;
            } else {
                d2 = d3 * this.f37137d;
            }
            return this.f37138e != 0 ? -d2 : d2;
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: eus$d */
    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a */
        private int f37139a;

        /* renamed from: b */
        private int f37140b;

        /* renamed from: c */
        private byte[] f37141c;

        public byte[] a() {
            return this.f37141c;
        }
    }
}