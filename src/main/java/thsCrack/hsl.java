package thsCrack;

//package defpackage;

//import com.assistant.voicecustomized.voicerecord.view.VoiceRecordView;
import java.util.Arrays;
import java.util.List;
//import kotlin.KotlinNullPointerException;
//import kotlin.UninitializedPropertyAccessException;

/* compiled from: HexinClass */
/* renamed from: hsl  reason: default package */
/* loaded from: classes6.dex */
public class hsl {
    private hsl() {
    }

    public static String a(String str, Object obj) {
        return str + obj;
    }

//    public static void a() {
//        throw ((KotlinNullPointerException) a(new KotlinNullPointerException()));
//    }
//
//    public static void a(String str) {
//        throw ((UninitializedPropertyAccessException) a(new UninitializedPropertyAccessException(str)));
//    }

//    public static void b(String str) {
//        a("lateinit property " + str + " has not been initialized");
//    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) a(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            d(str);
        }
    }

    private static void d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + VoiceRecordView.POINT + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean a(Double d2, Double d3) {
        return d2 == null ? d3 == null : d3 != null && d2.doubleValue() == d3.doubleValue();
    }

    public static boolean a(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    public static void b() {
        c("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void c(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void a(int i, String str) {
        b();
    }

    private static <T extends Throwable> T a(T t) {
        return (T) a((Throwable) t, hsl.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}