package thsCrack;

//import android.text.TextUtils;
//import android.util.SparseArray;
//import com.xiaomi.mipush.sdk.Constants;
import utils.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: HexinClass */
/* renamed from: evr  reason: default package */
/* loaded from: classes5.dex */
public class evr extends eur {
    private b l;
    private Map<String, c> m = new HashMap();

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=6] */
    public evr a(ftf ftfVar, int i) {
        if (ftfVar == null) {
            System.out.println("AM_REALDATA"+ "NewRealData_parse():stream is null, stop!");
            return null;
        }
        this.l = new b();
        this.l = this.l.a(ftfVar);
        if (this.l == null) {
            System.out.println("AM_REALDATA"+ "NewRealData_parse():mDataStruct is null, stop!");
            return null;
        } else if (this.l.c() + this.l.b() != i) {
            System.out.println("AM_REALDATA"+ "NewRealData_processNewRealTimeData():newDataStruct datalen=" + this.l.c() + ", textlen=" + this.l.b() + ",head datalen=" + i);
            return null;
        } else {
            System.out.println("AM_REALDATA"+ "NewRealData_parse():" + this.l);
            try {
                int available = ftfVar.available();
                int c2 = this.l.c();
                if (c2 > available) {
                    System.out.println("AM_REALDATA"+ "NewRealData_parse():dataLenTotal=" + c2 + ", availableLen=" + available);
                    return null;
                }
                int a2 = this.l.a();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= a2 || ftfVar == null) {
                        break;
                    }
                    int i4 = i3 + 1;
                    c a3 = new c().a(ftfVar);
                    if (a3 == null) {
                        System.out.println("AM_REALDATA"+ "NewRealData_parse():parse RowData error");
                        break;
                    }
                    i2 += a3.a();
                    this.m.put(a3.b(), a3);
                    i3 = i4;
                }
                if (this.m.size() != a2) {
                    System.out.println("AM_REALDATA"+ "NewRealData_parse():stock count is not equal[" + this.m.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + a2 + "]");
                    return null;
                } else if (this.l.c() != i2) {
                    System.out.println("AM_REALDATA"+ "NewRealData_parse():Data length is error");
                    return null;
                } else {
                    return this;
                }
            } catch (IOException e2) {
                System.out.println("AM_REALDATA"+ "NewRealData_parse():IOException e=" + e2);
                return null;
            } catch (Exception e3) {
                System.out.println("AM_REALDATA"+ "NewRealData_parse():Exception e=" + e3);
                return null;
            } finally {
                b(ftfVar);
            }
        }
    }

    public eup[] m() {
        if (this.m == null) {
            return null;
        }
        Set<String> keySet = this.m.keySet();
        eup[] eupVarArr = new eup[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            c cVar = this.m.get(str);
            if (cVar != null) {
                eupVarArr[i] = cVar.c();
                i++;
            }
        }
        return eupVarArr;
    }

    public int[] a(eup eupVar) {
        if (eupVar == null || TextUtils.isEmpty(eupVar.f37116b)) {
            return null;
        }
        String str = eupVar.f37116b;
        if (eupVar.a()) {
            str = eupVar.f37116b + "_" + eupVar.f37117c;
        }
        c cVar = this.m.get(str);
        if (cVar != null) {
            SparseArray sparseArray = cVar.f37172d;
            int size = sparseArray.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = (int) sparseArray.keyAt(i);
            }
            return iArr;
        }
        return null;
    }

    public a a(eup eupVar, int i) {
        if (eupVar == null || TextUtils.isEmpty(eupVar.f37116b)) {
            return null;
        }
        String str = eupVar.f37116b;
        if (eupVar.a()) {
            str = eupVar.f37116b + "_" + eupVar.f37117c;
        }
        c cVar = this.m.get(str);
        if (cVar != null) {
            return cVar.a(i);
        }
        return null;
    }

    public void n() {
        SparseArray sparseArray;
        a aVar;
        if (false) {
            eup[] m = m();
            int length = m.length;
            StringBuilder sb = new StringBuilder();
            
            System.out.println("AM_REALDATA"+ "NewRealData_dumpLog():Begin to dump........................");
            for (int i = 0; i < length; i++) {
                if (m[i] != null) {
                    String str = m[i].f37116b;
                    if (m[i].a()) {
                        str = m[i].f37116b + "_" + m[i].f37117c;
                    }
                    c cVar = this.m.get(str);
                    if (cVar == null) {
                        sparseArray = null;
                    } else {
                        sparseArray = cVar.f37172d;
                    }
                    int[] a2 = a(m[i]);
                    if (a2 != null && sparseArray != null) {
                        for (int i2 : a2) {
                            if (((a) sparseArray.get(i2)) != null) {
                                sb.append(aVar.f37160a + "=" + aVar.f37164e).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                        }
                        System.out.println("AM_REALDATA"+ "NewRealData_dumpLog():" + m[i].f37116b + ":" + sb.toString());
                        sb.setLength(0);
                    } else {
                        System.out.println("AM_REALDATA"+ "NewRealData_dumpLog():get data id failed, code=" + m[i].f37116b + ", market=" + m[i].f37117c);
                    }
                }
            }
            System.out.println("AM_REALDATA"+ "NewRealData_dumpLog():dump finished........................");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: evr$b */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f37165a;

        /* renamed from: b  reason: collision with root package name */
        int f37166b;

        /* renamed from: c  reason: collision with root package name */
        int f37167c;

        /* renamed from: d  reason: collision with root package name */
        int f37168d;

        public b a(ftf ftfVar) {
            if (ftfVar == null) {
                System.out.println("AM_REALDATA"+ "RealTimeDataStruct_parse():stream is null");
                return null;
            }
            try {
                int readUnsignedShort = ftfVar.readUnsignedShort();
                if (ftfVar.available() < readUnsignedShort) {
                    System.out.println("AM_REALDATA"+ "RealTimeDataStruct_parse():headLen=" + readUnsignedShort + " is bigger than stream available=" + ftfVar.available());
                    evr.b(ftfVar);
                    //this = null;
                } else {
                    int readUnsignedShort2 = ftfVar.readUnsignedShort();
                    int readUnsignedShort3 = ftfVar.readUnsignedShort();
                    short readShort = ftfVar.readShort();
                    if (ftfVar.available() < readUnsignedShort3) {
                        System.out.println("AM_REALDATA"+ "RealTimeDataStruct_parse(): datalen is error");
                        evr.b(ftfVar);
                        //this = null;
                    } else {
                        this.f37165a = readUnsignedShort;
                        this.f37166b = readUnsignedShort3;
                        this.f37167c = readUnsignedShort2;
                        this.f37168d = readShort;
                    }
                }
                return this;
            } catch (IOException e2) {
                System.out.println(e2);
                System.out.println("AM_REALDATA"+ "RealTimeDataStruct_parse()IOException:" + e2.getMessage());
                evr.b(ftfVar);
                return null;
            } catch (Exception e3) {
                System.out.println("AM_REALDATA"+ "RealTimeDataStruct_parse()Exception:" + e3.getMessage());
                evr.b(ftfVar);
                return null;
            }
        }

        public int a() {
            return this.f37167c;
        }

        public int b() {
            return this.f37165a;
        }

        public int c() {
            return this.f37166b;
        }

        public String toString() {
            return "RealTimeDataStruct [mHeadLen=" + this.f37165a + ", mDataLen=" + this.f37166b + ", mReceivedStockCount=" + this.f37167c + ", mMark=" + this.f37168d + "]";
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: evr$a */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f37160a;

        /* renamed from: b  reason: collision with root package name */
        private int f37161b;

        /* renamed from: c  reason: collision with root package name */
        private int f37162c;

        /* renamed from: d  reason: collision with root package name */
        private int f37163d;

        /* renamed from: e  reason: collision with root package name */
        private Object f37164e;
        private int f;

        public int a(ftf ftfVar) {
            if (ftfVar == null) {
                System.out.println("AM_REALDATA"+ "ColObj_parse():stream is null");
                return -1;
            }
            try {
                short readShort = ftfVar.readShort();
                this.f37161b = 0xFF00 & readShort;
                this.f37162c = readShort & 0xFF;
                this.f = ftfVar.readByte();
                this.f37163d = eus.b(ftfVar.readByte());
                this.f37160a = ftfVar.readUnsignedShort();
                int i = this.f + 3 + 1 + 2;
                a(this.f37161b, ftfVar);
                System.out.println("AM_REALDATA"+ "ColObj_parse():" + this + ", ColLength=" + i);
                return i;
            } catch (IOException e2) {
                System.out.println("AM_REALDATA"+ "ColObj_parse():IOException e=" + e2.getMessage() + ", ColObj=" + this);
                evr.b(ftfVar);
                return -1;
            } catch (Exception e3) {
                System.out.println("AM_REALDATA"+ "ColObj_parse():Exception e=" + e3.getMessage() + ", ColObj=" + this);
                evr.b(ftfVar);
                return -1;
            }
        }

        private void a(int i, ftf ftfVar) throws IOException {
            switch (i) {
                case 0:
                    this.f37164e = ftfVar.a(this.f / 2);
                    return;
                case 4096:
                    if (this.f == 4) {
                        long a2 = ftfVar.a();
                        fth fthVar = new fth();
                        fthVar.a(a2);
                        StringBuffer stringBuffer = new StringBuffer();
                        eus.a(fthVar, this.f37162c, stringBuffer);
                        this.f37164e = stringBuffer.toString();
                        stringBuffer.setLength(0);
                        return;
                    }
                    System.out.println("AM_REALDATA"+ "ColObj_parseValue:hxlong length is error");
                    return;
                case 8192:
                    this.f37164e = String.valueOf(ftfVar.readInt());
                    return;
                default:
                    return;
            }
        }

        public int a() {
            return this.f37163d;
        }

        public Object b() {
            return this.f37164e;
        }

        public String toString() {
            return "ColObj [mId=" + this.f37160a + ", mType=" + this.f37161b + ", mColor=" + this.f37163d + ", mValue=" + this.f37164e + "]";
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: evr$c */
    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private int f37169a;

        /* renamed from: b  reason: collision with root package name */
        private String f37170b;

        /* renamed from: c  reason: collision with root package name */
        private String f37171c;

        /* renamed from: d  reason: collision with root package name */
        private SparseArray<a> f37172d = new SparseArray<>();

        public c a(ftf ftfVar) {
            if (ftfVar == null) {
                System.out.println("AM_REALDATA"+ "RealDataRow_parse():stream is null");
                return null;
            }
            try {
                this.f37169a = ftfVar.readUnsignedShort();
                if (ftfVar.available() < this.f37169a) {
                    System.out.println("AM_REALDATA"+ "RealDataRow_parse():stream available is not enough");
                    evr.b(ftfVar);
                    return null;
                }
                int readByte = ftfVar.readByte();
                if (readByte > 0) {
                    byte[] bArr = new byte[readByte];
                    if (ftfVar.read(bArr) != readByte) {
                        System.out.println("AM_REALDATA"+ "RealDataRow_parse():parse stockcode error");
                        return null;
                    }
                    this.f37170b = new String(bArr);
                }
                byte readByte2 = ftfVar.readByte();
                System.out.println("AM_REALDATA"+ "RealDataRow_parse():colNum" + ((int) readByte2));
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= readByte2 || ftfVar == null) {
                        break;
                    }
                    i2++;
                    a aVar = new a();
                    int a2 = aVar.a(ftfVar);
                    if (a2 != -1) {
                        int i3 = a2 + i;
                        this.f37172d.put(aVar.f37160a, aVar);
                        if (aVar.f37160a == 34338 && (aVar.b() instanceof String)) {
                            this.f37171c = (String) aVar.b();
                            //frr.d("AM_REALDATA"+ "RealDataRow_parse():parse ColObj stockcode= " + this.f37170b + ", marketid=" + this.f37171c);
                            i = i3;
                        } else {
                            i = i3;
                        }
                    } else {
                        System.out.println("AM_REALDATA"+ "RealDataRow_parse():parse ColObj error, break!");
                        break;
                    }
                }
                if (this.f37172d.size() != readByte2) {
                    System.out.println("AM_REALDATA"+ "RealDataRow_parse():colNum is not equal[" + this.f37172d.size() + Constants.ACCEPT_TIME_SEPARATOR_SP + ((int) readByte2) + "]");
                    evr.b(ftfVar);
                    return null;
                } else if (i + 1 + 1 + readByte != this.f37169a) {
                    System.out.println("AM_REALDATA"+ "RealDataRow_parse():row data length is error");
                    evr.b(ftfVar);
                    return null;
                } else {
                    return this;
                }
            } catch (IOException e2) {
                System.out.println("AM_REALDATA"+ "RealDataRow_parse():IOException e=" + e2 + ", RowData=" + this);
                evr.b(ftfVar);
                return null;
            } catch (Exception e3) {
                System.out.println("AM_REALDATA"+ "RealDataRow_parse():Exception e=" + e3 + ", RowData=" + this);
                evr.b(ftfVar);
                return null;
            }
        }

        public a a(int i) {
            return this.f37172d.get(i);
        }

        public int a() {
            return this.f37169a + 2;
        }

        public String b() {
            return !TextUtils.isEmpty(this.f37171c) ? this.f37170b + "_" + this.f37171c : this.f37170b;
        }

        public eup c() {
            return new eup(null, this.f37170b, this.f37171c);
        }

        public String toString() {
            return "RealDataRow [mDataLen=" + this.f37169a + ", mStockCode=" + this.f37170b + ", mMarketId=" + this.f37171c + ", mColNum=" + this.f37172d.size() + "]";
        }
    }

    @Override // defpackage.eur
    public String toString() {
        return "NewRealData [mDataStruct=" + this.l + ", mData=" + this.m + ", codes=" + Arrays.toString(m()) + "]";
    }
}