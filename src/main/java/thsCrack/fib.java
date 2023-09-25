package thsCrack;

//package defpackage;
//
//import android.content.Context;
//import com.hexin.android.security.SecurityModule;
//import defpackage.aad;

/* compiled from: HexinClass */
/* renamed from: fib  reason: default package */
/* loaded from: classes3.dex */
public class fib {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f38325a;

    /* renamed from: b  reason: collision with root package name */
    private SecurityModule f38326b;

    /* renamed from: c  reason: collision with root package name */
    private fhz f38327c;

    public static fib a() {
        return a.f38329a;
    }

    private fib() {
        this.f38325a = false;
    }

    public void a(fhz fhzVar) {
        this.f38327c = fhzVar;
    }

    public fhz b() {
        return this.f38327c;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        if (bArr2 == null || bArr2.length == 0) {
            return null;
        }
        if (bArr.length > 24) {
            throw new IllegalArgumentException("des key length must equal 24");
        }
        if (bArr.length < 24) {
            byte[] bArr3 = new byte[24];
            int length = 24 - bArr.length;
            int length2 = length / bArr.length;
            for (int i = 0; i <= length2; i++) {
                System.arraycopy(bArr, 0, bArr3, bArr.length * i, bArr.length);
            }
            int length3 = length % bArr.length;
            if (length3 != 0) {
                System.arraycopy(bArr, 0, bArr3, bArr.length * (length2 + 1), length3);
            }
            bArr = bArr3;
        }
        if (this.f38326b != null) {
            if (z) {
                return this.f38326b.encrypt3DES(bArr, bArr2);
            }
            return this.f38326b.decrypt3DES(bArr, bArr2);
        }
        return null;
    }

    public void a(boolean z) {
        if (this.f38326b != null) {
            this.f38326b.debugMode(z);
        }
    }

    public boolean c() {
        return this.f38325a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HexinClass */
    /* renamed from: fib$a */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final fib f38329a = new fib();
    }

//    public void a(Context context) {
//        if (context != null) {
//            aad.a(context, "hxsecurity", new aad.c() { // from class: fib.1
//                @Override // defpackage.aad.c
//                public void success() {
//                    fib.this.f38326b = new SecurityModule();
//                    fib.this.f38325a = true;
//                }
//
//                @Override // defpackage.aad.c
//                public void failure(Throwable th) {
//                    fib.this.f38325a = false;
//                }
//            });
//        } else {
//            frr.c("AM_REALDATA", "SecurityModuleManager static block with null context.");
//        }
//    }
}