package utils;

public class Utils {
    public static void printByteArray(byte[] bArr){
        int i = 0;
        for (byte b : bArr) {
            System.out.print(b + ",");
//            if(++i % 50 == 0){
//                System.out.println();
//            }
        }
        System.out.println();
    }
    public static byte[] toPrimitives(Byte[] oBytes) {
        byte[] bytes = new byte[oBytes.length];
        for (int i = 0; i < oBytes.length; i++) {
            bytes[i] = oBytes[i];
        }
        return bytes;
    }
}
