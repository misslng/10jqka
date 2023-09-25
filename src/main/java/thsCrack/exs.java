package thsCrack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: HexinClass */
/* renamed from: exs */
/* loaded from: classes4.dex */
public class exs {

    /* renamed from: a */
    private int f37560a = 28;

    /* renamed from: b */
    private int f37561b;

    /* renamed from: c */
    private int f37562c;

    /* renamed from: d */
    private int f37563d;

    /* renamed from: e */
    private int f37564e;
    private int f;
    private int g;
    private int h;

    public static exs a(byte[] bArr, int i, int i2) {
        exs exsVar;
        int length = bArr.length - i;
        if ((i | i2) < 0 || i2 > length || length < 24) {
            return null;
        }
        ftf ftfVar = new ftf(new ByteArrayInputStream(bArr, i, 24));
        try {
            int readUnsignedShort = ftfVar.readUnsignedShort();
            int readInt = ftfVar.readInt();
            int readInt2 = ftfVar.readInt();
            int readUnsignedShort2 = ftfVar.readUnsignedShort();
            int readInt3 = ftfVar.readInt();
            int readInt4 = ftfVar.readInt();
            int readInt5 = ftfVar.readInt();
            exsVar = new exs();
            exsVar.f37560a = readUnsignedShort;//2
            exsVar.f37561b = readInt;//4
            exsVar.f37562c = readInt2;//4
            exsVar.f37564e = readUnsignedShort2;//2
            exsVar.f = readInt3;//4
            exsVar.f37563d = readInt4;//4
            exsVar.g = readInt5;//4
            try {
                ftfVar.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            try {
                ftfVar.close();
            } catch (IOException e4) {
            }
            exsVar = null;
        } catch (Throwable th) {
            try {
                ftfVar.close();
            } catch (IOException e5) {
            }
            throw th;
        }
        return exsVar;
    }

    public void a(ftg ftgVar) {
        try {
            ftgVar.writeShort(this.f37560a);
            ftgVar.writeInt(this.f37561b);
            ftgVar.writeInt(this.f37562c);
            ftgVar.writeShort(this.f37564e);
            ftgVar.writeInt(this.f);
            ftgVar.writeInt(this.f37563d);
            ftgVar.writeInt(this.g);
            ftgVar.writeInt(0);
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ftg ftgVar = new ftg(byteArrayOutputStream);
        a(ftgVar);
        try {
            ftgVar.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
    public void a(ftg ftgVar, int i) {
        int i2;
        int i3;
        int i4 = 0;
        if (ftgVar != null) {
            eyc a2 = eyc.a();
            try {
                ftgVar.writeShort(this.f37560a);
                ftgVar.writeInt(this.f37561b);
                ftgVar.writeInt(this.f37562c);
                ftgVar.writeShort(this.f37564e);
                ftgVar.writeInt(this.f);
                ftgVar.writeInt(this.f37563d);
                ftgVar.writeInt(this.g);
                if (a2 != null) {
                    ext c2 = a2.c();
                    if (c2 != null) {
                        int f = c2.f();
                        i2 = c2.e();
                        i3 = f;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    i4 = (i3 & 0xFFFF) | ((i2 & 0xFFFF) << 16);
                }
                ftgVar.writeInt(i4);
            } catch (IOException e2) {
            }
        }
    }

//    public void a(ftg ftgVar, int i) {
//        int i2;
//        int i3;
//        int i4 = 0;
//        if (ftgVar != null) {
//            eyc a2 = eyc.a();
//            try {
//                ftgVar.writeShort(this.f37560a);
//                ftgVar.writeInt(this.f37561b);
//                ftgVar.writeInt(this.f37562c);
//                ftgVar.writeShort(this.f37564e);
//                ftgVar.writeInt(this.f);
//                ftgVar.writeInt(this.f37563d);
//                ftgVar.writeInt(this.g);
//                if (a2 != null) {
//                    ext c2 = a2.c();
//                    if (c2 != null) {
//                        int f = c2.f();
//                        i2 = c2.e();
//                        i3 = f;
//                    } else {
//                        i2 = 0;
//                        i3 = 0;
//                    }
//                    i4 = (i3 & 0xFFFF) | ((i2 & 0xFFFF) << 16);
//                }
//                ftgVar.writeInt(i4);
//            } catch (IOException e2) {
//            }
//        }
//    }

    public int b() {
        return this.f37560a;
    }

    public int c() {
        return this.f37561b;
    }

    public int d() {
        return this.f37562c;
    }

    public int e() {
        return this.f37563d;
    }

    public int f() {
        return this.f37564e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        return this.f37564e;
    }

    public void a(int i) {
        this.f37561b = i;
    }

    public void b(int i) {
        this.f37562c = i;
    }

    public void c(int i) {
        this.f37563d = i;
    }

    public void d(int i) {
        this.f37564e = i;
    }

    public void e(int i) {
        this.f = i;
    }

    public void f(int i) {
        this.g = i;
    }

    public int j() {
        return this.h;
    }

    public void g(int i) {
        this.h = i;
    }

    public String toString() {
        return "MiniDataHead [headLength=" + this.f37560a + ", id=" + this.f37561b + ", type=" + this.f37562c + ", frameId=" + this.f37563d + ", pageId=" + this.f37564e + ", dataLength=" + this.f + ", textLength=" + this.g + " session type="+ + this.h +  "]";
    }

    public boolean h(int i) {
        return b() >= 24 && (b() + g()) + h() <= i;
    }
}