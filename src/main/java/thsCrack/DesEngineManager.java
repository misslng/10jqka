package thsCrack;

//ppackage com.hexin.security;

//import com.hexin.android.component.MoniYunyingItemView;

/* compiled from: HexinClass */
/* loaded from: classes6.dex */
public class DesEngineManager {

    /* renamed from: c */
    private byte[] f27542c;

    /* renamed from: d */
    private fhy f27543d;

    /* renamed from: a */
    private boolean f27540a = true;

    /* renamed from: b */
    private boolean f27541b = true;

    /* renamed from: e */
    private ExecuteDesMode f27544e = ExecuteDesMode.JAVA;

    public static DesEngineManager a() {
        return a.f27549a;
    }

    public void a(boolean z) {
        this.f27541b = z;
    }

    public boolean b() {
        return this.f27541b;
    }

    public void a(byte[] bArr) {
        this.f27542c = bArr;
        this.f27540a = this.f27541b;
    }

    public boolean c() {
        return this.f27540a;
    }

    public void d() {
        if (this.f27543d != null) {
            this.f27543d = null;
        }
    }

    public boolean e() {
        return this.f27542c != null;
    }

    public byte[] f() {
        return this.f27542c;
    }

    public byte[] a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0 || i2 == 0) {
            return null;
        }
        if (this.f27540a) {
            if (fib.a().c()) {
                System.out.println("encryptDataBuf: native encrypt");
                byte[] a2 = a(bArr, true);
                if (a2 == null) {
                    System.out.println( "encryptDataBuf: use native des onEnOrDecryptFailed");
                    if (fib.a().b() != null) {
                        fib.a().b().b();
                    }
                } else {
                    return a2;
                }
            } else {
                System.out.println("encryptDataBuf: use native des onLoadError");
                if (fib.a().b() != null) {
                    fib.a().b().a();
                }
            }
        }
        System.out.println("encryptDataBuf: manual encrypt");
        return b(bArr, i, i2);
    }

    public byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0 || i == 0) {
            return null;
        }
        if (this.f27540a) {
            if (fib.a().c()) {
                bArr2 = a(bArr, false);
                if (bArr2 != null) {
                    this.f27544e = ExecuteDesMode.NATIVE;
                    return bArr2;
                }
                System.out.println("decryptDataBuf: use native des onEnOrDecryptFailed");
                if (fib.a().b() != null) {
                    fib.a().b().b();
                }
            } else {
                System.out.println( "decryptDataBuf: use native des onLoadError");
                if (fib.a().b() != null) {
                    fib.a().b().a();
                }
            }
        }
        this.f27544e = ExecuteDesMode.JAVA;
        System.out.println("decryptDataBuf: manual Decrypt");
        if (this.f27543d != null) {
            this.f27543d.a(bArr, i, false);
        } else {
            bArr = bArr2;
        }
        return bArr;
    }

    private void b(byte[] bArr) {
        if (this.f27543d == null) {
            this.f27543d = new fhy(bArr);
        }
    }

    private byte[] b(byte[] bArr, int i, int i2) {
        b(this.f27542c);
        this.f27543d.a(bArr, i, i2, true);
        return bArr;
    }

    private byte[] a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            System.out.println( "nativeEnOrDecrypt: use native");
            return fib.a().a(this.f27542c, bArr, z);
        } catch (IllegalArgumentException | UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public ExecuteDesMode g() {
        return this.f27544e;
    }

    /* compiled from: HexinClass */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a */
        private static final DesEngineManager f27549a = new DesEngineManager();
    }

    /* compiled from: HexinClass */
    /* loaded from: classes5.dex */
    public static final String JUMP_TYPE_NATIVE = "native";

    public enum ExecuteDesMode {
        JAVA("java"),
        NATIVE(JUMP_TYPE_NATIVE);


        /* renamed from: c */
        private String f27548c;

        ExecuteDesMode(String str) {
            this.f27548c = str;
        }

        public String a() {
            return this.f27548c;
        }
    }
}