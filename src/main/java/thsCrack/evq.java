package thsCrack;

//package defpackage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: HexinClass */
/* renamed from: evq */
/* loaded from: classes4.dex */
public class evq {
    public static boolean a(int i) {
        return evp.a().c(i);
    }

    public static void a(int i, eur eurVar) {
        evs b2;
        if (eurVar != null && i >= 0 && (b2 = evp.a().b(i)) != null) {
            b2.b(eurVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=5] */
    public static eur a(byte[] bArr, int i, int i2, exs exsVar) {
        eur eurVar;
        if (bArr == null || bArr.length < i || bArr.length != i2 + i) {
            System.out.println( "RealDataProcess_processData():buffer length=" + (bArr != null ? bArr.length : 0) + ", offset=" + i + ", length=" + i2);
            return null;
        } else if (exsVar == null) {
            System.out.println( "RealDataProcess_processNewRealTimeData():MiniDataHead head is null");
            return null;
        } else {
            System.out.println("AM_REALDATA"+"RealDataProcess_processData():" + exsVar);
            System.out.println("AM_REALDATA"+"RealDataProcess_processData(): src data=" + Arrays.toString(bArr));
            ftf ftfVar = new ftf(new ByteArrayInputStream(bArr, i, i2));
            try {
                try {
                    try {
                        switch (exsVar.d() & 15) {
                            case 1:
                            case 14:
                            case 15:
                                eurVar = a(ftfVar, exsVar.g());
                                break;
                            case 11:
                                eurVar = a(bArr, i, i2);
                                break;
                            case 12:
                                eurVar = a(ftfVar, exsVar);
                                break;
                            default:
                                return null;
                        }
                    } catch (Exception e2) {
                        System.out.println("RealDataProcess_processData():Exception=" + e2);
                        a(ftfVar);
                        eurVar = null;
                    }
                } catch (Exception e3) {
                    System.out.println("RealDataProcess_processData():IOException=" + e3);
                    a(ftfVar);
                    eurVar = null;
                }
                return eurVar;
            } finally {
                a(ftfVar);
            }
        }
    }

    private static euw a(ftf ftfVar, int i) throws Exception {
        if (ftfVar == null) {
            System.out.println("RealDataProcess_processTextData():stream is null!");
            return null;
        } else if (i <= 0) {
            System.out.println("RealDataProcess_processTextData():expectDataLen is error!");
            return null;
        } else {
            int readUnsignedShort = ftfVar.readUnsignedShort();
            String a2 = ftfVar.a(readUnsignedShort);
            int readUnsignedShort2 = ftfVar.readUnsignedShort();
            String a3 = ftfVar.a(readUnsignedShort2);
            int i2 = (readUnsignedShort * 2) + 2 + (readUnsignedShort2 * 2) + 2;
            int readUnsignedShort3 = ftfVar.readUnsignedShort();
            int i3 = i2 + (readUnsignedShort3 * 2) + 2;
            System.out.println("AM_REALDATA"+"RealDataProcess_processData():title=" + a2 + ", tipid=" + ftfVar.a(readUnsignedShort3) + ", content=" + a3);
            if (i != i3) {
                System.out.println("RealDataProcess_processData():data len is error, readCount=" + i3 + ", datalen=" + i);
                a(ftfVar);
                return null;
            }
            euw euwVar = new euw(0);
            euwVar.b(a2);
            euwVar.c(a3);
            return euwVar;
        }
    }

    private static eur a(ftf ftfVar, exs exsVar) {
        if (ftfVar == null) {
            System.out.println("RealDataProcess_processRTPushData:stream is null!");
            return null;
        } else if (exsVar == null) {
            System.out.println("RealDataProcess_processRTPushData:head is null!");
            return null;
        } else {
            return b(ftfVar, exsVar);
        }
    }

    private static evr b(ftf ftfVar, exs exsVar) {
        if (ftfVar == null) {
            System.out.println("RealDataProcess_parseRTData:stream is null!");
            return null;
        }
        evr a2 = new evr().a(ftfVar, exsVar.g() + exsVar.h());
        if (a2 == null) {
            System.out.println( "RealDataProcess_processNewRealTimeData():parse NewRealData error!");
            return null;
        }
        a2.n();
        return a2;
    }

    private static euv a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new euv(5, bArr2, bArr);
    }

    private static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }
    }
}