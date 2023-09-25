package thsCrack;
//import com.hexin.middleware.data.mobile.StuffCurveStruct;

public class ewa {
    private static final byte[] a = new byte[0];
    private exi b;

//    static {
//        ewa.a = new byte[0];
//    }

    private void a(StuffCurveStruct arg6, byte[] arg7) {
        if(arg6.p != null && arg7 != null) {
            byte[] v0 = new byte[arg6.p.length + arg7.length];
            System.arraycopy(arg7, 0, v0, 0, arg7.length);
            System.arraycopy(arg6.p, 0, v0, arg7.length, arg6.p.length);
            arg6.p = v0;
        }
    }

    public eur a(byte[] bArr, int offset, int datalen, int session_type, int sessionId, byte[] bArr2) {
        
        System.out.println("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + ") called with: offset = [" + offset + "], length = [" + datalen + "]");
        if(bArr == null) {
            //frr.e("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "): return cause buffer is null.");
            return null;
        }

        if((offset | datalen) < 0 || datalen > bArr.length - offset) {
            //frr.e("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "): return cause data lenth error.");
            return null;
        }
        //解析datahead
        exs v2 = exs.a(bArr, offset, datalen);
        if(v2 == null) {
            //frr.e("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "): return cause hxHead is null.");
            return null;
        }

        v2.g(session_type);
        System.out.println("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "):MiniDataHead-> \n" + v2);
        if(ewb.a(v2)) {
            System.out.println("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "): return cause head dispatcher interceptioned");
            return null;
        }

        if(!v2.h(datalen)) {
            //frr.e("AM_DATA_REC"+ "DataReceiveHandler_dataReceived(sessionType=" + session_type + "): return cause head lenth error.");
            return null;
        }

        eyc.a().a(v2.c());
        if(v2.i() == 8888) {
            v2.b(v2.d() | 10);
        }

        eur v1 = euq.a(bArr, offset + 24, datalen - 24, v2);
        if((v1 instanceof StuffCurveStruct)) {
            this.a(((StuffCurveStruct)v1), bArr2);
        }

        byte[] v3 = ewa.a;
        synchronized(v3) {
            if(this.b != null) {
                int v4 = v2.c();
                int v5 = v2.i();
                this.b.a(v4, v5);
            }
        }

        ewd.a(v2, v1);
        return v1;
    }

    public void a() {
        byte[] v1 = ewa.a;
        synchronized(v1) {
            this.b = null;
            return;
        }
    }

    public void a(exi arg3) {
        byte[] v1 = ewa.a;
        synchronized(v1) {
            this.b = arg3;
            return;
        }
    }
}

