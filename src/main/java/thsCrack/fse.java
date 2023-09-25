package thsCrack;
//import android.content.SharedPreferences;
//import android.util.SparseArray;

public final class fse {
    private static final int[] a= new int[]{0xFF000000, 0xFF00A8A8, 0xFF00FF00, 0xFF00FFFF, 0xFF5454FF, 0xFF54FF54, 0xFF54FFFF, 0xFFA80000, 0xFFA8A8A8, 0xFFC8C8C8, 0xFFFF0000, 0xFFFF5454, 0xFFFF54FF, 0xFFFFFF00, 0xFFFFFF54, -1};
    private static final SparseArray b = new SparseArray();

    static {
        fse.b.put(16, "万手");
        fse.b.put(0x20, "%");
        fse.b.put(0x30, "亿");
        fse.b.put(0x40, "万");
        fse.b.put(0, "");
    }

    public static int a(byte[] arg4, int arg5) {
        return (arg4[arg5] & 0xFF) + ((arg4[arg5 + 1] & 0xFF) + ((arg4[arg5 + 2] & 0xFF) + ((arg4[arg5 + 3] & 0xFF) << 8) << 8) << 8);
    }

    public static String a() {
        return "--";
    }

    public static String a(int arg1) {
        return (String)fse.b.get(arg1);
    }

//    public static String a(String arg1, String arg2) {
//        return fse.a(arg1, arg2, null);
//    }

//    public static String a(String arg3, String arg4, String arg5) {
//        if(fic.a() == null) {
//            return arg5;
//        }
//
//        SharedPreferences v1 = fic.a().getSharedPreferences(arg3, 0);
//        return v1 == null || arg4 == null ? null : v1.getString(arg4, arg5);
//    }

    private static boolean a(char arg2) {
        Character.UnicodeBlock v0 = Character.UnicodeBlock.of(arg2);
        return (fse.b(arg2)) || v0 == Character.UnicodeBlock.GENERAL_PUNCTUATION || v0 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || v0 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean a(String arg3) {
        if(arg3 != null && arg3.length() > 15 && arg3.charAt(15) == 49) {
            //frr.b("HexinUtils", "vip");
            return true;
        }

        return false;
    }

    public static int b(int arg1) {
        return arg1 < 0 || arg1 >= fse.a.length ? 0 : fse.a[arg1];
    }

//    public static String b() {
//        return fse.a("sp_user_sid", "sp_key_user_sid");
//    }

    private static boolean b(char arg2) {
        Character.UnicodeBlock v0 = Character.UnicodeBlock.of(arg2);
        return v0 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || v0 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || v0 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
    }

    public static boolean b(String arg5) {
        char[] v2 = arg5.toCharArray();
        int v1;
        for(v1 = 0; v1 < v2.length; ++v1) {
            if(fse.a(v2[v1])) {
                return true;
            }
        }

        return false;
    }
}

