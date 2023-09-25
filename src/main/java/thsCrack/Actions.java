package thsCrack;

//package cx.hell.android.pdfview;

//import com.tencent.connect.common.Constants;

/* compiled from: HexinClass */
/* loaded from: classes3.dex */
public class Actions {
    public static final int ACTION_FULL_PAGE_DOWN = 3;
    public static final int ACTION_FULL_PAGE_UP = 4;
    public static final int ACTION_NEXT_PAGE = 6;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_PREV_PAGE = 5;
    public static final int ACTION_SCREEN_DOWN = 1;
    public static final int ACTION_SCREEN_UP = 2;
    public static final int ACTION_ZOOM_IN_1020 = 7;
    public static final int ACTION_ZOOM_IN_1050 = 8;
    public static final int ACTION_ZOOM_IN_1100 = 9;
    public static final int ACTION_ZOOM_IN_1200 = 10;
    public static final int ACTION_ZOOM_IN_1414 = 11;
    public static final int ACTION_ZOOM_IN_2000 = 12;
    public static final int ACTION_ZOOM_OUT_1020 = 13;
    public static final int ACTION_ZOOM_OUT_1050 = 14;
    public static final int ACTION_ZOOM_OUT_1100 = 15;
    public static final int ACTION_ZOOM_OUT_1200 = 16;
    public static final int ACTION_ZOOM_OUT_1414 = 17;
    public static final int ACTION_ZOOM_OUT_2000 = 18;
    public static final int BOTTOM_TAP = 1000005;
    public static final int LONG_ZOOM_IN = 1000002;
    public static final int LONG_ZOOM_OUT = 1000003;
    public static final int PAIR_NONE = 0;
    public static final int PAIR_PAGE = 2;
    public static final int PAIR_PAGE_REV = 11;
    public static final int PAIR_PAGE_TOP = 9;
    public static final int PAIR_PAGE_TOP_REV = 12;
    public static final int PAIR_SCREEN = 1;
    public static final int PAIR_SCREEN_REV = 10;
    public static final int PAIR_ZOOM_1020 = 3;
    public static final int PAIR_ZOOM_1050 = 4;
    public static final int PAIR_ZOOM_1100 = 5;
    public static final int PAIR_ZOOM_1200 = 6;
    public static final int PAIR_ZOOM_1414 = 7;
    public static final int PAIR_ZOOM_2000 = 8;
    public static final int TOP_TAP = 1000004;
    public static final int ZOOM_IN = 1000000;
    public static final int ZOOM_OUT = 1000001;
    public int zoom = Integer.parseInt("7");
    public int longZoom = Integer.parseInt("8");
    public int upDown = Integer.parseInt("1");
    public int volume = Integer.parseInt("1");
    public int leftRight = Integer.parseInt("2");
    public int rightUpDown = Integer.parseInt("1");
    public int topBottomTap = Integer.parseInt("0");

    public static float getZoomValue(int i) {
        switch (i) {
            case 7:
                return 0.98039216f;
            case 8:
                return 0.952381f;
            case 9:
                return 0.9090909f;
            case 10:
                return 0.8333333f;
            case 11:
            case 12:
                return 0.7072136f;
            case 13:
                return 1.02f;
            case 14:
                return 1.05f;
            case 15:
                return 1.1f;
            case 16:
                return 1.2f;
            case 17:
                return 1.414f;
            case 18:
                return 1.414f;
            default:
                return -1.0f;
        }
    }

    public static int getAction(int i, int i2) {
        switch (i) {
            case 1:
                return i2 != 0 ? 1 : 2;
            case 2:
                return i2 == 0 ? 4 : 3;
            case 3:
                return i2 == 0 ? 13 : 7;
            case 4:
                return i2 == 0 ? 14 : 8;
            case 5:
                return i2 == 0 ? 15 : 9;
            case 6:
                return i2 == 0 ? 16 : 10;
            case 7:
                return i2 == 0 ? 17 : 11;
            case 8:
                return i2 == 0 ? 18 : 12;
            case 9:
                return i2 == 0 ? 5 : 6;
            case 10:
                return i2 != 1 ? 1 : 2;
            case 11:
                return i2 != 1 ? 3 : 4;
            case 12:
                return i2 != 1 ? 6 : 5;
            default:
                return 0;
        }
    }

    public int getAction(int i) {
        switch (i) {
            case 19:
            case 92:
                return getAction(this.upDown, 0);
            case 20:
            case 93:
                return getAction(this.upDown, 1);
            case 21:
                return getAction(this.leftRight, 0);
            case 22:
                return getAction(this.leftRight, 1);
            case 24:
                return getAction(this.volume, 0);
            case 25:
                return getAction(this.volume, 1);
            case 94:
                return getAction(this.rightUpDown, 0);
            case 95:
                return getAction(this.rightUpDown, 1);
            case ZOOM_IN /* 1000000 */:
                return getAction(this.zoom, 1);
            case ZOOM_OUT /* 1000001 */:
                return getAction(this.zoom, 0);
            case LONG_ZOOM_IN /* 1000002 */:
                return getAction(this.longZoom, 1);
            case LONG_ZOOM_OUT /* 1000003 */:
                return getAction(this.longZoom, 0);
            case TOP_TAP /* 1000004 */:
                return getAction(this.topBottomTap, 0);
            case BOTTOM_TAP /* 1000005 */:
                return getAction(this.topBottomTap, 1);
            default:
                return 0;
        }
    }
}