package core;

import thsCrack.*;
import utils.Constant;
import utils.TextUtils;
import utils.Utils;

import java.io.*;
import java.net.Socket;
import java.net.URLEncoder;
import java.util.Arrays;

public class ThsCore {
    Socket socket;
    Integer packageId = 1;
    OutputStream outputStream;
    InputStream inputStream;
    ewa dataHandler;

    public boolean connectThsServer() {
        try {
            socket = new Socket(Constant.CONNECT_HOST, Constant.CONNECT_PORT);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            dataHandler = new ewa();
            System.out.println("连接同花顺服务器成功");
        } catch (Exception e) {
            System.out.println("连接同花顺服务器失败");
            return false;
        }

        return true;
    }

    public final String generateSendCheckCodeOrPasswordLoginInfo(String str, String str2, boolean z, int i, boolean z2, String str3) {
        StringBuilder sb = new StringBuilder();
        fjc fjc = new fjc();
        if (!z) {
            str = fjc.b(str);
        }
        sb.append("crypt=2\r\nctrlcount=2\r\nctrlid_0=34338\r\nctrlvalue_0=").append(str).append("\r\nctrlid_1=34339\r\nctrlvalue_1=").append(fjc.b(str2)).append("\r\nreqctrl=4304");
        if (i == 4 || z2) {
            sb.append("\r\nloginmode=1");
            if (!TextUtils.isEmpty(str3)) {
                sb.append("\r\nforeign=1\r\nforeign_country=").append(str3);
            }
        }
        if (i == 4) {
            sb.append("\r\nloginType=7");
        } else if (i == 1) {
            sb.append("\r\nloginType=3");
        }
        String sb2 = sb.toString();
        hsl.a((Object) sb2, "requestMsg.toString()");
        return sb2;
    }

    public boolean passportLogin(byte[] passport) {
        Utils.printByteArray(passport);
        String a2 = "";
        int length = passport != null ? passport.length : 0;
        exs exsVar = new exs();
        exsVar.a(0);
        exsVar.b(exsVar.d() | 458752);
        exsVar.e((a2.length() * 2) + 2 + 2 + length);
        exsVar.d((short) 65280);
        exsVar.c(0);
        exsVar.f(0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ftg ftgVar = new ftg(byteArrayOutputStream);
        exsVar.a(ftgVar);
        try {
            ftgVar.writeShort(a2.length());
            ftgVar.writeChars(a2);
            ftgVar.writeShort(length);
            if (length > 0) {
                ftgVar.write(passport, 0, length);
            }
            try {
                ftgVar.close();
            } catch (Exception e) {
                System.out.println("关闭ftgVar失败");
                return false;
            }
        } catch (Exception e) {
            System.out.println("设备信息转字节失败");
            return false;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Utils.printByteArray(byteArray);
        if (!sendHxData(byteArray)) return false;

        a recvHxData = recvHxDataByPackageId(0);
        Utils.printByteArray(recvHxData.databytes);
        euv euv = (euv)dataHandler.a(recvHxData.databytes, 0, recvHxData.databytes.length, recvHxData.sessionType, recvHxData.sessionId, recvHxData.headmask_and_datalen);
        String string = new String(euv.m());
        if (string.contains("sid=8")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败 删除D盘的passport文件后重新登录");
            System.exit(0);
        }
        return true;
    }

    public boolean verifyCheckCode(String phoneNumber, String checkCodeOrPassword, Integer loginType) {
        //loginType 1 为手机密码登录
        eya eya = fjf.a().a(2054, 1001, null, generateSendCheckCodeOrPasswordLoginInfo(phoneNumber, checkCodeOrPassword, false, loginType, loginType != 1, "86")).a();
        erf c = c(eya);
        byte[] bytes = a(c, 0);
        Utils.printByteArray(bytes);
        if (!sendHxData(bytes)) return false;
        a recvHxData = recvHxDataByPackageId(c.k());
        Utils.printByteArray(recvHxData.databytes);
        euv euv = (euv)dataHandler.a(recvHxData.databytes, 0, recvHxData.databytes.length, recvHxData.sessionType, recvHxData.sessionId, recvHxData.headmask_and_datalen);
        String string = new String(euv.m());
        if (string.contains("sid=8")){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败 请重新输入短信验证码");
            return false;
        }
        fiw fiw = new fiw();
        fiw.a(euv);
        return true;
    }

    public boolean sendSmsLogin(String phoneNumber) {
        String generateSendCheckCodeInfo = generateSendCheckCodeInfo(phoneNumber);
        //frameId pageId
        eya eya = fjf.a().a(4222, 1101, null, generateSendCheckCodeInfo(phoneNumber)).a();
        erf c = c(eya);
        byte[] bytes = a(c, 0);
        Utils.printByteArray(bytes);
        if (!sendHxData(bytes)) return false;
        a recvHxData = recvHxDataByPackageId(c.k());
        Utils.printByteArray(recvHxData.databytes);
        eur eur = dataHandler.a(recvHxData.databytes, 0, recvHxData.databytes.length, recvHxData.sessionType, recvHxData.sessionId, recvHxData.headmask_and_datalen);
        //如果要判断有没有发送成功可以解析一下返回的xml
        return true;
    }

    private String generateSendCheckCodeInfo(String phoneNumber) {
        String str = Constant.UDID;
        fjc fjc = new fjc();
        String enc_string = fjc.b(phoneNumber);
        try {
            return String.format("host=auth\r\nurl=verify?reqtype=wlh_thsreg_modify&mobile_login=1&qsid=800&regflag&udid=%s&encoding=GBK&mobile=%s&rsa_version=default_4&foreign=1&foreign_country=86", str, URLEncoder.encode(enc_string, "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
//            fza.f39719a.a(e2);
            System.out.println("加密手机号码出错");
            return "";
        }
    }

    public boolean sendDeviceInfo() {
        final int ACTION_POINTER_INDEX_MASK = 0xFF00;

        String deviceInfo = this.generateInitDeviceInfo();
        exs exsVar = new exs();
        exsVar.a(0);
        exsVar.b(exsVar.d() | 458752);
        exsVar.e((deviceInfo.length() * 2) + 2 + 2);
        exsVar.d(ACTION_POINTER_INDEX_MASK);
        exsVar.c(0);
        exsVar.f(0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ftg ftgVar = new ftg(byteArrayOutputStream);
        exsVar.a(ftgVar);

        try {
            ftgVar.writeShort(deviceInfo.length());
            ftgVar.writeChars(deviceInfo);
            ftgVar.writeShort(0);
            try {
                ftgVar.close();
            } catch (Exception e) {
                System.out.println("关闭ftgVar失败");
                return false;
            }
        } catch (Exception e) {
            System.out.println("设备信息转字节失败");
            return false;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Utils.printByteArray(byteArray);
        if (!sendHxData(byteArray)) return false;

        a recvHxData = recvHxDataByPackageId(0);
        Utils.printByteArray(recvHxData.databytes);
        eur eur = dataHandler.a(recvHxData.databytes, 0, recvHxData.databytes.length, recvHxData.sessionType, recvHxData.sessionId, recvHxData.headmask_and_datalen);

        return true;
    }

    public a recvHxDataByPackageId(Integer packageId) {
        while (true) {
            a a = recvHxData();
            if (a == null) break;
            if (a.packageid == packageId) return a;
        }
        return null;
    }

    public a recvHxData() {
        try {
            byte[] head = new byte[13];

            int i3 = 0;
            //确保读到四字节fd
            while (i3 < 4) {
                int i4 = inputStream.read();
                if (i4 == -1) {
                    System.out.println("接受到-1char 停止运行");
                } else if (i4 == 253) {
                    head[i3] = (byte) i4;
                    i3++;
                } else {
                    i3 = 0;
                }
            }
//            Utils.printByteArray(head);
            //读后面9字节
            while (i3 < 13) {
                int i5 = inputStream.read();
                head[i3] = (byte) i5;
                i3++;
            }
//            Utils.printByteArray(head);

            int parseInt = Integer.parseInt(new String(head, 4, 8), 16);
//            System.out.println(parseInt);
            byte[] bArr = new byte[12];
            byte[] bArr2 = new byte[parseInt];
            int i6 = 0;
            int i7 = 0;
//            byte 0xFF = (byte) 0xFF;
            while (i6 != parseInt && i7 != -1) {
                i7 = inputStream.read(bArr2, i6, parseInt - i6);
                i6 += i7;
            }
            if (bArr2.length < i6) {
                System.out.println("PackageDeliverer_dataReceived(): return cause data error.");
                return null;
            }
            System.arraycopy(bArr2, 0, bArr, 0, bArr.length);
            //i2 packageId
            int i2 = (bArr[3] << 8) | (bArr[2] & 0xFF);
            //i instanceId
            int i = ((bArr[bArr.length - 1] << 8) & 0xFF00) | (bArr[bArr.length - 2] & 0xFF);

            a aVar = new a();
            aVar.databytes = bArr2;
            /*
            sessionType 0是行情 cbas不知道是啥
            private String e(int i) {
                return i == 0 ? "hq" : "cbas";
            }
             */
            aVar.sessionType = 0;
            //这个是session id 每次new一个新的socket出来这个就会++，应该是用不着的
            aVar.sessionId = 1;
            aVar.packageid = i2;
            aVar.instanceid = i;
            aVar.headmask_and_datalen = head;
//            System.out.println(Arrays.toString(bArr));
            return aVar;
        } catch (IOException e) {
            return null;
        }
    }

    private byte[] a(erf erfVar, int i) {
        int i2;
        byte[] byteArray = new byte[0];
        boolean z = true;
        byte[] g = erfVar.g();
        String h = erfVar.h();
//        int c2 = erfVar.k(); 自增packageid的
//        erfVar.h(c2);
        int f = erfVar.f() != 0 ? erfVar.f() : 0x10000;
        if (h != null && h.length() > 0 && !fse.b(h) && (f == 0x10000 || f == 0x60000)) {
            f |= 16777216;
        }
        exs exsVar = new exs();
        boolean z2 = (f & 0x1000000) == 0x1000000;
        if (h != null) {
            i2 = z2 ? h.length() : h.length() * 2;
        } else {
            i2 = 0;
        }
        int length = g != null ? g.length : 0;
        if (i2 != 0 || length <= 0) {
            z = false;
        }
        if (z) {
            //动态调试后之后委托才走des加密 所以忽略
            //这部分其实没太看明白
            //粗略理解下就是textlength和datalength都是会设置的 但是必定有一个值会是0，所以哪怕都设置也没有关系
            System.out.println("数据需要des加密");
//            if (this.i == null || this.i.length <= 0) {
//                this.i = h();
//                DesEngineManager.a().a(this.i);
//            }
//            int d2 = d(0);
//            if (d2 == 0) {
//                return null;
//            }
//            this.h = a(this.i, d2);
//            if (this.h != null) {
//                exsVar.f(this.h.length);
//            }
        } else {
            exsVar.f(i2);
        }
        exsVar.c(erfVar.b());
        exsVar.d(erfVar.c());
        exsVar.e(length);
        exsVar.a(erfVar.k());
        exsVar.b(f | exsVar.d());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ftg ftgVar = new ftg(byteArrayOutputStream);
        exsVar.a(ftgVar, erfVar.k());
        System.out.println(exsVar);
//        if (this.l != null) {
// 有走这个函数 但是手动跳过之后数据还是能拿 貌似关系不大 this.l继承自etu 貌似是对心跳包id的一些更新操作
//            this.l.a(i, exsVar, erfVar);
//        }
        try {
            if (h != null) {
                try {
                    try {
                        if (h.length() > 0) {
                            if (z2) {
                                ftgVar.write(h.getBytes());
                            } else {
                                ftgVar.writeChars(h);
                            }
                            if (g != null && g.length > 0) {
                                ftgVar.write(g);
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            ftgVar.close();
                            return byteArray;
                        }
                    } finally {
                        try {
                            ftgVar.close();
                        } catch (IOException e2) {
                            //frr.e("CommunicationManager", "transformToBytes: " + e2);
                        }
                    }
                } catch (IOException e3) {
                    //frr.e("CommunicationManager", e3.getLocalizedMessage());
                    return null;
                }
            }
            ftgVar.close();
            return byteArray;
        } catch (IOException e4) {
            //frr.e("CommunicationManager", "transformToBytes: " + e4);
            //return byteArray;
        }
//        if (z && this.h != null && this.h.length > 0) {
//            ftgVar.write(this.h);
//        }
        try {
            if (g != null) {
                ftgVar.write(g);
            }
        } catch (IOException e) {
            System.out.println("write ftg error");
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }

    private erf c(eya eyaVar) {
        erf erfVar = new erf();
        erfVar.b(eyaVar.f37598b);
        erfVar.d(eyaVar.f37599c);
        erfVar.e(eyaVar.f37600d);
        erfVar.a(eyaVar.m);
        erfVar.a(eyaVar.b());
        erfVar.c(0xFF00);
        erfVar.f(eyaVar.f != 0 ? eyaVar.f : 65536);
        erfVar.g(eyaVar.k);
        erfVar.b(eyaVar.h);
        erfVar.a(!eyaVar.g);
        erfVar.h(packageId++);
        erfVar.j(eyaVar.i);
        erfVar.i(eyaVar.l);
        erfVar.a(eyaVar.a());
        String c2 = eyaVar.c();
        if (c2 != null && c2.length() > 0 && eyaVar.f != 983040) {
            erfVar.a(c2);
        }
        if (eyaVar.n != null && eyaVar.n.length > 0) {
            erfVar.a(eyaVar.n);
        }
        return erfVar;
    }

    public boolean sendHxData(byte[] bArr) {
        try {
            //加协议头
            byte[] writeHexinPackageProtocol = writeHexinPackageProtocol(bArr.length);
            byte[] bArr2 = new byte[writeHexinPackageProtocol.length + bArr.length];
            System.arraycopy(writeHexinPackageProtocol, 0, bArr2, 0, writeHexinPackageProtocol.length);
            System.arraycopy(bArr, 0, bArr2, writeHexinPackageProtocol.length, bArr.length);
//            Utils.printByteArray(bArr2);
            //发送数据
            outputStream.write(bArr2, 0, bArr2.length);
            outputStream.flush();
        } catch (Exception exception) {
//            exception.printStackTrace();
            System.out.println("发送HX数据包失败");
            return false;
        }

        return true;
    }

    private static byte[] writeHexinPackageProtocol(int i) throws Exception {
        final byte LF_NORMAL = 48;
        byte[] bArr = new byte[13];
        int i2 = 0;
        while (i2 < 4) {
            bArr[i2] = -3;
            i2++;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i2 + i3] = LF_NORMAL;
        }
        String hexString = Integer.toHexString(i);
        System.arraycopy(hexString.getBytes(), 0, bArr, 12 - hexString.length(), hexString.length());
        bArr[bArr.length - 1] = 0;
        return bArr;
    }

    private String generateInitDeviceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ScreenWidth=").append("720").append("\r\n");
        stringBuffer.append("ScreenHeight=").append("1280").append("\r\n");
        stringBuffer.append("smallestWidth=").append("0dp").append("dp\r\n");
        stringBuffer.append("density=").append("1.0").append("\r\n");
        stringBuffer.append("realdata=").append("true").append("\r\n");
        stringBuffer.append("time2012=").append("1").append("\r\n");
        stringBuffer.append("AppletVersion=").append(Constant.APPLET_VERSION).append("\r\n");
        //版本控制
        stringBuffer.append("svnver=").append(Constant.SVN_VER).append("\r\n");
        stringBuffer.append("TestVersion=").append(Constant.TEST_VERSION).append("\r\n");
        stringBuffer.append("Branch0xFF=").append(Constant.BRANCH_NAME).append("\r\n");

        stringBuffer.append("FunClientSupport=").append("0111111111100011111111").append("\r\n");
        stringBuffer.append("app=").append("android").append("\r\n");
        stringBuffer.append("for=").append("ths_am_gphone_login").append("\r\n");
        stringBuffer.append("progid=").append("500").append("\r\n");
        stringBuffer.append("net=").append("1").append("\r\n");
        stringBuffer.append("qsid=").append("800").append("\r\n");
        stringBuffer.append("sourceid=").append(Constant.SOURCE_ID).append("\r\n");
        stringBuffer.append("spcode=").append(Constant.SP_CODE).append("\r\n");
        stringBuffer.append("channelid=").append("714").append("\r\n");
        stringBuffer.append("type=").append(Constant.TYPE).append("\r\n");
        stringBuffer.append("udid=").append(Constant.UDID).append("\r\n");
        stringBuffer.append("imei=").append(Constant.IMEI).append("\r\n");
        stringBuffer.append("sim=").append(Constant.SIM).append("\r\n");
        stringBuffer.append("imsi=").append(Constant.IMSI).append("\r\n");
        stringBuffer.append("macA=").append(Constant.MACA).append("\r\n");
        stringBuffer.append("sdk=").append(Constant.SDK).append("\r\n");
        stringBuffer.append("sdkn=").append(Constant.SDKN).append("\r\n");
        stringBuffer.append("CA=").append("4").append("\r\n");
        stringBuffer.append("dev=").append(Constant.DEV).append("\r\n");

        return stringBuffer.toString();
    }

    public class a {

        /* re0xFFd from: a */
        public byte[] databytes;

        /* re0xFFd from: b */
        public int sessionType;

        /* re0xFFd from: c */
        public int sessionId;

        /* re0xFFd from: d */
        public int packageid;

        /* re0xFFd from: e */
        public int instanceid;

        /* re0xFFd from: f */
        public byte[] headmask_and_datalen;

        @Override
        public String toString() {
            return "a{" +
                    "databytes=" + Arrays.toString(databytes) +
                    ", sessionType=" + sessionType +
                    ", sessionId=" + sessionId +
                    ", packageid=" + packageid +
                    ", instanceid=" + instanceid +
                    ", headmask_and_datalen=" + Arrays.toString(headmask_and_datalen) +
                    '}';
        }

        private a() {
        }

    }

}
