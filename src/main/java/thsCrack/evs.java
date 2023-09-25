package thsCrack;

//import android.text.TextUtils;
import utils.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: HexinClass */
/* renamed from: evs  reason: default package */
/* loaded from: classes6.dex */
public abstract class evs {

    /* renamed from: b  reason: collision with root package name */
    protected a f37174b;

    /* renamed from: c  reason: collision with root package name */
    protected eur f37175c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile boolean f37176d = false;

    /* renamed from: a  reason: collision with root package name */
    protected List<eup> f37173a = new ArrayList();

    public void a(int i, int i2, int[] iArr) {
        if (i < 0) {
            throw new IllegalArgumentException("instanceid is error " + i);
        }
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("dataids must not be empty");
        }
        if (this.f37174b == null) {
            this.f37174b = new a();
            this.f37174b.f37177a = i;
            this.f37174b.f37178b = i2;
            this.f37174b.f37179c = iArr;
        }
    }

    protected void a(eur eurVar) {
    }

    public void a() {
        this.f37176d = true;
    }

    protected boolean b() {
        return this.f37176d;
    }

    public boolean a(eup eupVar, int[] iArr) {
        if (eupVar == null || iArr == null || TextUtils.isEmpty(eupVar.f37116b) || iArr.length <= 0 || !a(eupVar) || this.f37174b == null || this.f37174b.f37179c == null) {
            return false;
        }
        int length = this.f37174b.f37179c.length;
        for (int i = 0; i < length; i++) {
            for (int i2 : iArr) {
                if (this.f37174b.f37179c[i] == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] b(eup eupVar, int[] iArr) {
        a aVar;
        int i;
        if (eupVar == null || iArr == null || TextUtils.isEmpty(eupVar.f37116b) || iArr.length <= 0) {
            return null;
        }
        if (a(eupVar) && (aVar = this.f37174b) != null) {
            int length = aVar.f37179c.length;
            int[] iArr2 = new int[length];
            if (aVar.f37179c != null) {
                i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    for (int i3 = 0; i3 < iArr.length; i3++) {
                        if (aVar.f37179c[i2] == iArr[i3]) {
                            iArr2[i] = iArr[i3];
                            i++;
                        }
                    }
                }
            } else {
                i = 0;
            }
            if (i > 0) {
                int[] iArr3 = new int[i];
                System.arraycopy(iArr2, 0, iArr3, 0, i);
                System.out.println( "RTDataSubscriber_getSubscribedIdByCode():" + Arrays.toString(iArr3));
                return iArr3;
            }
            return null;
        }
        return null;
    }

    private boolean a(eup eupVar) {
        boolean z;
        if (eupVar == null || TextUtils.isEmpty(eupVar.f37116b) || this.f37173a == null || this.f37173a.size() <= 0) {
            return false;
        }
        boolean a2 = eupVar.a();
        boolean z2 = false;
        for (eup eupVar2 : this.f37173a) {
            if (eupVar2 != null) {
                if (!TextUtils.equals(eupVar2.f37116b, eupVar.f37116b)) {
                    z = z2;
                } else if (a2) {
                    z = TextUtils.equals(eupVar2.f37117c, eupVar.f37117c);
                    if (z) {
                        return z;
                    }
                } else {
                    return true;
                }
                z2 = z;
            }
        }
        return z2;
    }

    public eur a(evr evrVar) {
        eup[] m;
        int[] b2;
        if (evrVar == null || b()) {
            return null;
        }
        for (eup eupVar : evrVar.m()) {
            int[] a2 = evrVar.a(eupVar);
            if (a2 != null && a2.length > 0 && (b2 = b(eupVar, a2)) != null && !b()) {
                a(eupVar, b2, evrVar);
            }
        }
        if (this.f37175c != null) {
            return this.f37175c.k();
        }
        return null;
    }

    public void a(eup eupVar, int[] iArr, evr evrVar) {
    }

    public int c() {
        if (this.f37174b == null) {
            return 0;
        }
        return this.f37174b.f37177a;
    }

    public void b(eur eurVar) {
        this.f37175c = eurVar;
        a(eurVar);
    }

    public void a(List<eup> list) {
        if (list != null) {
            this.f37173a = list;
        }
    }

    /* compiled from: HexinClass */
    /* renamed from: evs$a */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f37177a;

        /* renamed from: b  reason: collision with root package name */
        private int f37178b;

        /* renamed from: c  reason: collision with root package name */
        private int[] f37179c;
    }
}