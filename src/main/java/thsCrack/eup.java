package thsCrack;

//package defpackage;

//import com.hexin.app.IFundUtil;

/* compiled from: HexinClass */
/* renamed from: eup  reason: default package */
/* loaded from: classes3.dex */
public class eup implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f37115a;

    /* renamed from: b  reason: collision with root package name */
    public String f37116b;

    /* renamed from: c  reason: collision with root package name */
    public String f37117c;

    /* renamed from: d  reason: collision with root package name */
    public String f37118d;

    /* renamed from: e  reason: collision with root package name */
    public int f37119e;
    public String f;
    public int g;
    private boolean h = true;

    public eup() {
    }

    public eup(String str, String str2, String str3) {
        this.f37115a = str;
        this.f37116b = str2;
        this.f37117c = str3;
    }

    public boolean a() {
        return (this.f37117c == null || "".equals(this.f37117c.trim()) || IFundUtil.NULL.equals(this.f37117c) || "-1".equals(this.f37117c) || "--".equals(this.f37117c)) ? false : true;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            System.out.println(e2);
            return this;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("StockName: ");
        if (this.f37115a != null) {
            stringBuffer.append(this.f37115a).append(" StockCode: ");
        } else {
            stringBuffer.append(IFundUtil.NULL).append(" StockCode: ");
        }
        if (this.f37116b != null) {
            stringBuffer.append(this.f37116b).append(" mMarketid: ");
        } else {
            stringBuffer.append(IFundUtil.NULL).append(" mMarketid: ");
        }
        if (this.f37117c != null) {
            stringBuffer.append(this.f37117c);
        } else {
            stringBuffer.append(IFundUtil.NULL);
        }
        return stringBuffer.toString();
    }
}