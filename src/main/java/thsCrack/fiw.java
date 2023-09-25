package thsCrack;

import utils.Utils;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fiw {
    private final boolean a(ftf ftfVar) throws IOException {
        //读取有效信息长度
        int readShort = ftfVar.readShort();
        if (readShort <= 0) {
            return false;
        }
        byte[] bArr = new byte[readShort];
        ftfVar.read(bArr);
        System.out.println("生成的护照信息");
        Utils.printByteArray(bArr);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\passport.dat");
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (IOException ioException){
            System.out.println("写入passport文件失败");
            return false;
        }
        return true;
    }

    public void a(eur eurVar) {
        if (!(eurVar instanceof euv)) {
            System.out.println("AM_AUTH" + "hxlogin_receiveData struct is not StuffResourceStruct");
            a(eurVar);
            return;
        }
        byte[] m = ((euv) eurVar).m();
        if (m == null) {
            System.out.println("AM_AUTH" + "hxlogin_receiveData buffer is null");
            return;
        }
        ftf ftfVar = new ftf(new ByteArrayInputStream(m));
        try {
            if (ftfVar.available() < 9) {
                try {
                    ftfVar.close();
                    return;
                } catch (IOException e2) {
                    System.out.println("护照信息 IOException");
                    return;
                }
            }
            //两个padding
            byte readByte = ftfVar.readByte();
            ftfVar.readShort();
            boolean a2 = a(ftfVar);
        } catch (Throwable th) {
            try {
                ftfVar.close();
            } catch (IOException e9) {
                System.out.println("关闭ftf失败 护照");
            }

        }
    }
}
