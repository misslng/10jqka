package thsCrack;

public class SecurityModule {
    public native void debugMode(boolean z);

    public native byte[] decrypt3DES(byte[] bArr, byte[] bArr2);

    public native byte[] encrypt3DES(byte[] bArr, byte[] bArr2);

    public native byte[] generatorRandomKey(int i);

    public native String sayHello(String str);
}
