package thsCrack;

//import com.bairuitech.anychat.AnyChatDefine;
//import com.facebook.imageutils.JfifUtil;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
//import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: HexinClass */
/* renamed from: ftg  reason: default package */
/* loaded from: classes6.dex */
public class ftg extends OutputStream implements DataOutput {

    /* renamed from: a  reason: collision with root package name */
    private int f39216a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f39217b;

    public ftg(OutputStream outputStream) {
        this.f39217b = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f39217b.flush();
    }

    public final int a() {
        if (this.f39216a < 0) {
            this.f39216a = Integer.MAX_VALUE;
        }
        return this.f39216a;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.f39217b.write(bArr, i, i2);
        this.f39216a += i2;
    }

    @Override // java.io.OutputStream, java.io.DataOutput
    public void write(int i) throws IOException {
        this.f39217b.write(i);
        this.f39216a++;
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z) throws IOException {
        this.f39217b.write(z ? 1 : 0);
        this.f39216a++;
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i) throws IOException {
        this.f39217b.write(i);
        this.f39216a++;
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        if (str.length() != 0) {
            byte[] bArr = new byte[str.length()];
            for (int i = 0; i < str.length(); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            this.f39217b.write(bArr);
            this.f39216a += bArr.length;
        }
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i) throws IOException {
        this.f39217b.write(i);
        this.f39217b.write(i >> 8);
        this.f39216a += 2;
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        byte[] bArr = new byte[str.length() * 2];
        int i = 0;
        while (i < str.length()) {
            int i2 = i == 0 ? i : i * 2;
            bArr[i2] = (byte) str.charAt(i);
            bArr[i2 + 1] = (byte) (str.charAt(i) >> '\b');
            i++;
        }
        this.f39217b.write(bArr);
        this.f39216a += bArr.length;
    }

    @Override
    public void writeUTF(String s) throws IOException {

    }

    public final void a(String str) throws IOException {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        this.f39217b.write(bArr);
        this.f39216a += bArr.length;
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d2) throws IOException {
        writeLong(Double.doubleToLongBits(d2));
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i) throws IOException {
        this.f39217b.write(i);
        this.f39217b.write(i >> 8);
        this.f39217b.write(i >> 16);
        this.f39217b.write(i >> 24);
        this.f39216a += 4;
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j) throws IOException {
        writeInt((int) j);
        writeInt((int) (j >> 32));
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i) throws IOException {
        writeChar(i);
    }

//    @Override // java.io.DataOutput
//    public final void writeUTF(String str) throws IOException {
//        int i;
//        int length = str.length();
//        if (length <= 2730) {
//            byte[] bArr = new byte[length * 3];
//            int i2 = 0;
//            int i3 = 0;
//            while (i2 < length) {
//                char charAt = str.charAt(i2);
//                if (charAt > 0 && charAt <= 127) {
//                    i = i3 + 1;
//                    bArr[i3] = (byte) charAt;
//                } else if (charAt <= 2047) {
//                    int i4 = i3 + 1;
//                    bArr[i3] = (byte) ((charAt & '?') | 128);
//                    i = i4 + 1;
//                    bArr[i4] = (byte) (((charAt >> 6) & 31) | JfifUtil.MARKER_SOFn);
//                } else {
//                    int i5 = i3 + 1;
//                    bArr[i3] = (byte) ((charAt & '?') | 128);
//                    int i6 = i5 + 1;
//                    bArr[i5] = (byte) (((charAt >> 6) & 63) | 128);
//                    i = i6 + 1;
//                    bArr[i6] = (byte) (((charAt >> '\f') & 15) | AnyChatDefine.BRAC_SO_CORESDK_PPTFILECTRL);
//                }
//                i2++;
//                i3 = i;
//            }
//            writeShort(i3);
//            write(bArr, 0, i3);
//            return;
//        }
//        if (length <= 65535) {
//            long b2 = b(str);
//            if (b2 <= 65535) {
//                writeShort((int) b2);
//                a(str, b2);
//                return;
//            }
//        }
//        throw new UTFDataFormatException();
//    }

    long b(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt > 0 && charAt <= 127) {
                i = i3 + 1;
            } else if (charAt <= 2047) {
                i = i3 + 2;
            } else {
                i = i3 + 3;
            }
            i2++;
            i3 = i;
        }
        return i3;
    }

//    void a(String str, long j) throws IOException {
//        int i;
//        int i2;
//        boolean z = true;
//        int i3 = (int) j;
//        if (j > IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
//            i3 = 8192;
//            z = false;
//        }
//        byte[] bArr = new byte[i3];
//        int length = str.length();
//        int i4 = length;
//        int i5 = 0;
//        int i6 = 0;
//        while (i5 < length) {
//            if (z) {
//                i = i4;
//            } else {
//                i = ((bArr.length - i6) / 3) + i5;
//                if (i > length) {
//                    i = length;
//                }
//            }
//            while (i5 < i) {
//                char charAt = str.charAt(i5);
//                if (charAt > 0 && charAt <= 127) {
//                    i2 = i6 + 1;
//                    bArr[i6] = (byte) charAt;
//                } else if (charAt <= 2047) {
//                    int i7 = i6 + 1;
//                    bArr[i6] = (byte) ((charAt & '?') | 128);
//                    i2 = i7 + 1;
//                    bArr[i7] = (byte) (((charAt >> 6) & 31) | JfifUtil.MARKER_SOFn);
//                } else {
//                    int i8 = i6 + 1;
//                    bArr[i6] = (byte) ((charAt & '?') | 128);
//                    int i9 = i8 + 1;
//                    bArr[i8] = (byte) (((charAt >> 6) & 63) | 128);
//                    i2 = i9 + 1;
//                    bArr[i9] = (byte) (((charAt >> '\f') & 15) | AnyChatDefine.BRAC_SO_CORESDK_PPTFILECTRL);
//                }
//                i5++;
//                i6 = i2;
//            }
//            if (z || i6 > bArr.length - 300) {
//                write(bArr, 0, i6);
//                if (z) {
//                    return;
//                }
//                i6 = 0;
//            }
//            i4 = i;
//            i5 = i;
//        }
//        if (i6 > 0) {
//            write(bArr, 0, i6);
//        }
//    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
        } catch (IOException e2) {
        }
        this.f39217b.close();
    }
}