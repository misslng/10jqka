package thsCrack;
//package defpackage;

//import com.facebook.common.util.UriUtil;

/* compiled from: HexinClass */
/* renamed from: euv  reason: default package */
/* loaded from: classes3.dex */
public class euv extends eur {
    protected byte[] l;
    protected int m;
    protected byte[] n;

    public euv(int i, byte[] bArr) {
        this.m = i;
        this.l = bArr;
    }

    public euv(int i, byte[] bArr, byte[] bArr2) {
        this.m = i;
        this.l = bArr;
        this.n = bArr2;
    }

    public byte[] m() {
        return this.l;
    }

    public byte[] n() {
        return this.n;
    }

    public int o() {
        return this.m;
    }

    @Override // defpackage.eur
    public String f() {
//        return UriUtil.LOCAL_RESOURCE_SCHEME;
        return "res";
    }
}