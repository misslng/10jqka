package thsCrack;

import java.math.BigInteger;

/* compiled from: HexinClass */
/* renamed from: fia  reason: default package */
/* loaded from: classes3.dex */
public class fia {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f38322a;

    /* renamed from: b  reason: collision with root package name */
    private BigInteger f38323b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38324c;

    public void a(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f38322a = bigInteger;
        this.f38323b = bigInteger2;
        this.f38324c = z;
    }

    public int a() {
        if (this.f38322a != null) {
            int bitLength = this.f38322a.bitLength();
            if (this.f38324c) {
                return ((bitLength + 7) / 8) - 1;
            }
            return (bitLength + 7) / 8;
        }
        return 0;
    }

    public int b() {
        int bitLength = this.f38322a.bitLength();
        return this.f38324c ? (bitLength + 7) / 8 : ((bitLength + 7) / 8) - 1;
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        if (i2 > a() + 1) {
            return null;
        }
        if (i2 != a() + 1 || (bArr[i] & 128) == 0) {
            if (i != 0 || i2 != bArr.length) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                bArr = bArr2;
            }
            byte[] byteArray = new BigInteger(1, bArr).modPow(this.f38323b, this.f38322a).toByteArray();
            if (this.f38324c) {
                if (byteArray[0] == 0 && byteArray.length > b()) {
                    byte[] bArr3 = new byte[byteArray.length - 1];
                    System.arraycopy(byteArray, 1, bArr3, 0, bArr3.length);
                    return bArr3;
                } else if (byteArray.length < b()) {
                    byte[] bArr4 = new byte[b()];
                    System.arraycopy(byteArray, 0, bArr4, bArr4.length - byteArray.length, byteArray.length);
                    return bArr4;
                }
            } else if (byteArray[0] == 0) {
                byte[] bArr5 = new byte[byteArray.length - 1];
                System.arraycopy(byteArray, 1, bArr5, 0, bArr5.length);
                return bArr5;
            }
            return byteArray;
        }
        return null;
    }

    public byte[] b(byte[] bArr, int i, int i2) {
        int i3 = 2;
        byte[] bArr2 = new byte[256];
        int i4 = (i2 + i) - i;
        if (i4 + 11 > 64) {
            return null;
        }
        bArr2[0] = 0;
        bArr2[1] = 2;
        while (i3 < (64 - i4) - 1) {
            bArr2[i3] = 10;
            i3++;
        }
        bArr2[i3] = 0;
        System.arraycopy(bArr, i, bArr2, i3 + 1, i4);
        return a(bArr2, 0, 64);
    }

    public byte[] c(byte[] bArr, int i, int i2) {
        byte[] a2;
        int i3 = (i2 + i) - i;
        if (i3 <= 64 && (a2 = a(bArr, i, i3)) != null && a2.length == 64 && a2[0] == 0 && a2[1] == 1) {
            int i4 = 2;
            while (i4 < 63 && a2[i4] == -1) {
                i4++;
            }
            int i5 = i4 + 1;
            if (a2[i4] == 0) {
                int i6 = 64 - i5;
                if (i6 + 11 <= 64) {
                    byte[] bArr2 = new byte[i6];
                    System.arraycopy(a2, i5, bArr2, 0, i6);
                    return bArr2;
                }
                return null;
            }
            return null;
        }
        return null;
    }
}