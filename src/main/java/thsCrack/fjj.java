package thsCrack;
import java.io.UnsupportedEncodingException;

public final class fjj {
    private static final byte[] a = new byte[0];
    private static final byte[] b= new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};

    public static byte[] a(byte[] arg1) {
        return fjj.a(arg1, arg1.length);
    }

    public static byte[] a(byte[] arg13, int arg14) {
        int v2_3;
        int v2_2;
        int v0 = arg14 / 4 * 3;
        if(v0 == 0) {
            return fjj.a;
        }

        byte[] v7 = new byte[v0];
        int v0_1 = 0;
        while(true) {
            byte v2 = arg13[arg14 - 1];
            if(v2 != 10 && v2 != 13 && v2 != 0x20 && v2 != 9) {
                if(v2 != 61) {
                    break;
                }

                ++v0_1;
            }

            --arg14;
        }

        int v6 = 0;
        int v4 = 0;
        int v5 = 0;
        int v3;
        for(v3 = 0; v6 < arg14; v3 = v2_2) {
            byte v2_1 = arg13[v6];
            if(v2_1 == 10 || v2_1 == 13 || v2_1 == 0x20) {
                v2_2 = v3;
            }
            else if(v2_1 == 9) {
                v2_2 = v3;
            }
            else {
                if(v2_1 >= 65 && v2_1 <= 90) {
                    v2_3 = v2_1 - 65;
                }
                else if(v2_1 >= 97 && v2_1 <= 0x7A) {
                    v2_3 = v2_1 - 71;
                }
                else if(v2_1 >= 0x30 && v2_1 <= 57) {
                    v2_3 = v2_1 + 4;
                }
                else if(v2_1 == 43) {
                    v2_3 = 62;
                }
                else {
                    if(v2_1 != 0x2F) {
                        return null;
                    }

                    v2_3 = 0x3F;
                }

                v4 = v4 << 6 | ((byte)v2_3);
                if(v5 % 4 == 3) {
                    int v2_4 = v3 + 1;
                    v7[v3] = (byte)(v4 >> 16);
                    int v3_1 = v2_4 + 1;
                    v7[v2_4] = (byte)(v4 >> 8);
                    v2_2 = v3_1 + 1;
                    v7[v3_1] = (byte)v4;
                }
                else {
                    v2_2 = v3;
                }

                ++v5;
            }

            ++v6;
        }

        if(v0_1 > 0) {
            int v4_1 = v4 << v0_1 * 6;
            int v2_5 = v3 + 1;
            v7[v3] = (byte)(v4_1 >> 16);
            if(v0_1 == 1) {
                v3 = v2_5 + 1;
                v7[v2_5] = (byte)(v4_1 >> 8);
            }
            else {
                v3 = v2_5;
            }
        }

        byte[] v0_2 = new byte[v3];
        System.arraycopy(v7, 0, v0_2, 0, v3);
        return v0_2;
    }

    public static String b(byte[] arg9) {
        byte[] v3 = new byte[(arg9.length + 2) * 4 / 3];
        int v4 = arg9.length - arg9.length % 3;
        int v1 = 0;
        int v0 = 0;
        while(v1 < v4) {
            int v2 = v0 + 1;
            v3[v0] = fjj.b[(arg9[v1] & 0xFF) >> 2];
            int v0_1 = v2 + 1;
            v3[v2] = fjj.b[(arg9[v1] & 3) << 4 | (arg9[v1 + 1] & 0xFF) >> 4];
            int v2_1 = v0_1 + 1;
            v3[v0_1] = fjj.b[(arg9[v1 + 1] & 15) << 2 | (arg9[v1 + 2] & 0xFF) >> 6];
            v0 = v2_1 + 1;
            v3[v2_1] = fjj.b[arg9[v1 + 2] & 0x3F];
            v1 += 3;
        }

        switch(arg9.length % 3) {
            case 1: {
                int v1_1 = v0 + 1;
                v3[v0] = fjj.b[(arg9[v4] & 0xFF) >> 2];
                int v0_2 = v1_1 + 1;
                v3[v1_1] = fjj.b[(arg9[v4] & 3) << 4];
                int v1_2 = v0_2 + 1;
                v3[v0_2] = 61;
                v0 = v1_2 + 1;
                v3[v1_2] = 61;
                break;
            }
            case 2: {
                int v1_3 = v0 + 1;
                v3[v0] = fjj.b[(arg9[v4] & 0xFF) >> 2];
                int v0_3 = v1_3 + 1;
                v3[v1_3] = fjj.b[(arg9[v4] & 3) << 4 | (arg9[v4 + 1] & 0xFF) >> 4];
                int v1_4 = v0_3 + 1;
                v3[v0_3] = fjj.b[(arg9[v4 + 1] & 15) << 2];
                v0 = v1_4 + 1;
                v3[v1_4] = 61;
            }
        }

        try {
            return new String(v3, 0, v0, "US-ASCII");
        }
        catch(UnsupportedEncodingException v0_4) {
            throw new IllegalArgumentException(v0_4);
        }
    }
}

