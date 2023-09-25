import core.ThsCore;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ThsCore thsCore = new ThsCore();
        //创建一个新的连接到同花顺服务器
        if (!thsCore.connectThsServer()){
            System.exit(0);
        }

        //查看是否存在passport.dat
        try (FileInputStream fis = new FileInputStream("D:\\passport.dat");){
            //直接使用passport登录
            thsCore.passportLogin(fis.readAllBytes());
        }catch (Exception exception){
            //发送相关的设备初始化信息
            if (!thsCore.sendDeviceInfo()){
                System.out.println("发送初始化设备信息失败");
            }
            //发送登录验证包
            thsCore.sendSmsLogin("your phone");
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("输入短信验证码:");
                String checkCode = scanner.next();
                if (thsCore.verifyCheckCode("your phone",checkCode,4)) break;
            }
        }

    }
}