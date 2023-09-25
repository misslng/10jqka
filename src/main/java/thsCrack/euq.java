package thsCrack;

//package defpackage;

//import com.hexin.common.CCLuanMaRecorder;
//import com.hexin.middleware.data.mobile.StuffTableStruct;
//import com.hexin.security.DesEngineManager;
import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.math.BigInteger;

/* compiled from: HexinClass */
/* renamed from: euq  reason: default package */
/* loaded from: classes6.dex */
public final class euq {

    /* renamed from: a  reason: collision with root package name */
    private static fia f37120a;

    public static eur a(byte[] bArr, int i, int i2, exs exsVar) {
        int i3 = 0;
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            return null;
        }
        CCLuanMaRecorder.f25194a.a(CCLuanMaRecorder.Stage.SOURCE, bArr, exsVar);
        byte[] b2 = b(bArr, i, i2, exsVar);
        if (b2 == null) {
            return null;
        }
        if (b2 != bArr) {
            i2 = b2.length;
            i = 0;
        }
        CCLuanMaRecorder.f25194a.a(DesEngineManager.a().g(), exsVar, DesEngineManager.a().c(), DesEngineManager.a().b(), fib.a().c());
        CCLuanMaRecorder.f25194a.a(CCLuanMaRecorder.Stage.DECRYPT, b2, exsVar);
        byte[] c2 = c(b2, i, i2, exsVar);
        if (c2 == null) {
            return null;
        }
        if (b2 != c2) {
            i2 = c2.length;
        } else {
            c2 = b2;
            i3 = i;
        }
        if (exsVar.c() == -3) {
            return a(i3, i2, exsVar, c2);
        }
        return a(i3, i2, exsVar, c2, bArr);
    }

    private static eur a(int i, int i2, exs exsVar, byte[] bArr, byte[] bArr2) {
        boolean z = true;
        eur eurVar = null;
        switch (exsVar.d() & 15) {
            case 0:
            case 1:
            case 3:
            case 13:
                eurVar = a(bArr, i, i2, exsVar, true, bArr2);
                break;
            case 4:
                eurVar = b(bArr, i, i2);
                z = false;
                break;
            case 6:
                eurVar = c(bArr, i, i2);
                exsVar.d(8890);
                z = false;
                break;
            case 7:
                eurVar = d(bArr, i, i2, exsVar);
                exsVar.d(8889);
                z = false;
                break;
            case 9:
                eurVar = d(bArr, i, i2);
                z = false;
                break;
            case 10:
                z = false;
                break;
            case 11:
                eurVar = e(bArr, i, i2);
                z = false;
                break;
            case 15:
                eurVar = d(bArr, i, i2, exsVar);
                z = false;
                break;
            case 1048576:
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (eurVar == null) {
            eurVar = new eur() { // from class: euq.1
            };
        }
        eurVar.a(exsVar);
        if (z && (eurVar instanceof StuffTableStruct) && evq.a(eurVar.f)) {
            evq.a(eurVar.f, eurVar);
        }
        return eurVar;
    }

    private static eur a(int i, int i2, exs exsVar, byte[] bArr) {
        eur a2 = evq.a(bArr, i, i2, exsVar);
        if (a2 != null) {
            a2.a(exsVar);
            return a2;
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int i, int i2, exs exsVar) {
        switch (exsVar.d() & (0xF0000000)) {
            case 0:
            case 805306368:
            case 1073741824:
            default:
                return bArr;
            case 268435456:
                if (i2 >= exsVar.g() && DesEngineManager.a().e()) {
                    byte[] bArr2 = new byte[exsVar.g()];
                    System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                    return DesEngineManager.a().a(bArr2, bArr2.length);
                }
                return null;
            case 536870912:
                return a(bArr, i, i2);
            case 1879048192:
                return fhv.a().a(bArr, i, i2, exsVar);
        }
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        fia a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.c(bArr, i, i2);
    }

    private static fia a() {
        if (f37120a != null) {
            return f37120a;
        }
//        byte[] b2 = ftp.b(fic.a(), "pubkey.dat");
        byte[] b2 = null;
        if (b2 == null || b2.length < 258) {
            return null;
        }
        byte[] bArr = new byte[64];
        System.arraycopy(b2, 194, bArr, 0, 64);
        f37120a = new fia();
        f37120a.a(true, new BigInteger(1, bArr), new BigInteger(new byte[]{1, 0, 1}));
        return f37120a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] c(byte[] arg8, int arg9, int arg10, exs arg11) {
        byte[] v3;
        byte[] v0_2 = new byte[0];
        if((arg11.d() & 0xF000) == 0x1000 && arg10 > 0) {
            System.out.println("ReceiveDataProcess"+"解压前数据长度：" + arg10);
            int v0 = arg11.d() & 0xF0000000;
            if(0x10000000 == v0 || 0x20000000 == v0 || 0x70000000 == v0) {
                //frr.a("ReceiveDataProcess", "snappy upress before length change !");
                arg10 = fse.a(arg8, 0);
                arg9 = 4;
            }

            byte[] v4 = new byte[arg11.h()];
            byte[] v2 = new byte[arg10];
            System.arraycopy(arg8, arg9, v2, 0, arg10);
            System.arraycopy(arg8, arg9, v4, 0, arg11.h());
            try {
                v0_2 = new byte[Snappy.uncompressedLength(v2, 0, v2.length)];
                Snappy.uncompress(v2, 0, v2.length, v0_2, 0);
            }
            catch(IOException v0_1) {
                v3 = null;
                //frr.a(v0_1);
                //goto label_76;
            }

            v3 = v0_2;
            label_76:
            if(v3 == null) {
                System.out.println("ReceiveDataProcess"+"dataByteUnpressed == null");
                return null;
            }

            byte[] v1 = new byte[v3.length];
            System.arraycopy(v3, 0, v1, 0, v3.length);
            if(v4.length > 0) {
                System.out.println("ReceiveDataProcess"+"文本数据长度：" + v4.length);
                try {
                    arg11.f(Snappy.uncompressedLength(v4, 0, v4.length));
                }
                catch(IOException v0_3) {
                    //frr.a(v0_3);
                }
            }

            arg11.e(v3.length);
            System.out.println("ReceiveDataProcess"+ "解压hou数据长度：" + arg10);
            return v1;
        }

        return arg8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:9:0x001c, B:12:0x0024, B:14:0x003e, B:17:0x0047, B:19:0x0050, B:23:0x005b, B:25:0x0064), top: B:35:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:9:0x001c, B:12:0x0024, B:14:0x003e, B:17:0x0047, B:19:0x0050, B:23:0x005b, B:25:0x0064), top: B:35:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static eur a(byte[] bArr, int i, int i2, exs exsVar, boolean z, byte[] bArr2) {
        eur euwVar;
        boolean z2;
        String lowerCase;
        eur c2 = null;
        int d2 = exsVar.d() & 15;
        switch (d2) {
            case 0:
                if (i2 < 6) {
                    return null;
                }
                if (z) {
                    try {
                        if (exsVar.c() != -1) {
                            z2 = true;
                            byte[] bArr3 = new byte[6];
                            System.arraycopy(bArr, i, bArr3, 0, 6);
                            lowerCase = new String(bArr3).toLowerCase();
                            if (lowerCase.startsWith("tb")) {
                                c2 = new StuffTableStruct(z2);
                            } else if (lowerCase.startsWith("cv")) {
                                c2 = new StuffCurveStruct(z2, bArr2);
                            } else {
                                c2 = lowerCase.startsWith("8,") ? c(bArr, i, i2) : null;
                            }
                            euwVar = c2;
                            break;
                        }
                    } catch (Exception e2) {
                        //frr.a(e2);
                        return null;
                    }
                }
                z2 = false;
                byte[] bArr32 = new byte[6];
                System.arraycopy(bArr, i, bArr32, 0, 6);
                lowerCase = new String(bArr32).toLowerCase();
                if (!lowerCase.startsWith("tb")) {
                }
                euwVar = c2;
            case 1:
                euwVar = new euw(eus.a(d2));
                break;
            case 3:
                eur eutVar = new eut();
                if (!a(exsVar)) {
                    euwVar = eutVar;
                    break;
                } else {
                    ((eut) eutVar).c(-1);
                    return eutVar;
                }
            case 13:
                euwVar = new euu();
                break;
            case 15:
                euwVar = new euw(eus.a(d2));
                break;
            default:
                euwVar = null;
                break;
        }
        eus.a(bArr, i, i2, euwVar, exsVar, bArr2);
        return euwVar;
    }


    private static boolean a(exs exsVar) {
        if (exsVar.e() != 2605 || exsVar.g() != 0) {
            return false;
        }
        return true;
    }

    private static euv b(byte[] bArr, int i, int i2) {
        int min = Math.min(16, i2);
        if (min < 16) {
            return null;
        }
        byte[] bArr2 = new byte[min];
        System.arraycopy(bArr, i, bArr2, 0, min);
        if (a(bArr2)) {
            System.out.println("processDesKey"+ "valid des");
        } else {
            System.out.println("processDesKey"+"invalid des");
            DesEngineManager.a().d();
            bArr2 = new byte[0];
        }
        return new euv(1, bArr2);
    }

    private static boolean a(byte[] bArr) {
        boolean z;
        if (bArr == null || bArr.length < 16) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= 16) {
                z = false;
                break;
            } else if (bArr[i] != 1) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    private static euv d(byte[] bArr, int i, int i2, exs exsVar) {
        if (i2 < exsVar.g()) {
            return null;
        }
        byte[] bArr2 = new byte[exsVar.g()];
        System.arraycopy(bArr, i, bArr2, 0, exsVar.g());
        return new euv(2, bArr2);
    }

    private static euv c(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new euv(3, bArr2);
    }

    private static euv d(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new euv(4, bArr2, bArr);
    }

    private static euv e(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new euv(5, bArr2, bArr);
    }
}