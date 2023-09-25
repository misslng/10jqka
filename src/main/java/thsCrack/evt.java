package thsCrack;

//package defpackage;

//import android.text.TextUtils;
//import com.hexin.android.component.AbsLevel2TradeDetailComponent;
//import com.hexin.middleware.data.mobile.StuffTableStruct;
//import defpackage.evr;
import utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HexinClass */
/* renamed from: evt */
/* loaded from: classes5.dex */
public class evt extends evs {
    @Override // defpackage.evs
    protected void a(eur eurVar) {
        if (eurVar instanceof StuffTableStruct) {
            ArrayList arrayList = new ArrayList();
            String[] a2 = ((StuffTableStruct) eurVar).a(4);
            String[] a3 = ((StuffTableStruct) eurVar).a(AbsLevel2TradeDetailComponent.DATAID_MARKETCODE);
            if (a2 != null && a2.length > 0) {
                int length = a2.length;
                String str = null;
                for (int i = 0; i < length; i++) {
                    if (a3 != null && i < a3.length) {
                        str = a3[i];
                    }
                    arrayList.add(new eup(null, a2[i], str));
                }
            }
            this.f37173a.clear();
            this.f37173a.addAll(arrayList);
        }
    }

    @Override // defpackage.evs
    public void a(eup eupVar, int[] iArr, evr evrVar) {
        eur eurVar;
        if (eupVar != null && !TextUtils.isEmpty(eupVar.f37116b) && iArr != null && iArr.length != 0 && evrVar != null && (eurVar = this.f37175c) != null && (eurVar instanceof StuffTableStruct)) {
            StuffTableStruct stuffTableStruct = (StuffTableStruct) eurVar;
            int a2 = a(eupVar);
            if (a2 == -1) {
                System.out.println( "TableSubscriber_merge():rowIndex is invalid, code=" + eupVar.f37116b + ", market=" + eupVar.f37117c);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("code=").append(eupVar.f37116b).append("\r\n");
            sb.append("marketid=").append(eupVar.f37117c).append("\r\n");
            for (int i : iArr) {
                String[] a3 = stuffTableStruct.a(i);
                int[] b2 = stuffTableStruct.b(i);
                if (a3 != null && b2 != null && b2.length == a3.length && a3.length > a2) {
                    String str = a3[a2];
                    evr.a a4 = evrVar.a(eupVar, i);
                    if (a4 != null) {
                        Object b3 = a4.b();
                        String str2 = null;
                        if (b3 instanceof String) {
                            str2 = b3.toString();
                        }
                        sb.append("id=").append(i).append(", src value=").append(str).append(", new value=").append(str2).append("\r\n");
                        if (str2 == null || TextUtils.equals(str2, str)) {
                            System.out.println( "TableSubscriber_merge():src value is equal to newvalue,where id=" + i + ", value=" + str2);
                        } else {
                            a3[a2] = str2;
                            b2[a2] = a4.a();
                        }
                    }
                }
            }
            System.out.println("TableSubscriber_merge():" + sb.toString());
        }
    }

    private int a(eup eupVar) {
        List<eup> list = this.f37173a;
        if (list == null || list.size() <= 0 || eupVar == null || TextUtils.isEmpty(eupVar.f37116b)) {
            return -1;
        }
        boolean a2 = eupVar.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return -1;
            }
            eup eupVar2 = list.get(i2);
            if (eupVar2 == null || !TextUtils.equals(eupVar.f37116b, eupVar2.f37116b) || ((!a2 || !TextUtils.equals(eupVar.f37117c, eupVar2.f37117c)) && a2)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }
}