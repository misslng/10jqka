package thsCrack;

public class ftj {
    public static final int a(byte[] arg11, int arg12, int arg13, byte[] arg14, int arg15) {
        int v3_10;
        int v6_5;
        byte v5_7;
        int v2_8;
        int v0_7;
        int v3_6;
        int v2_5;
        int v5_4;
        int v3_2;
        byte v6_1;
        byte v5_3;
        int v0_2;
        int v2_2;
        byte v6;
        byte v5_2;
        int v1_2;
        int v7_1;
        int v4 = arg12 + 1;
        byte v1 = arg11[arg12];
        int v3 = 1;
        int v2 = v4 + 1;
        byte v4_1 = arg11[v4];
        arg14[0] = v4_1;
        byte v7 = 8;
        byte v8 = v1;
        while(v3 < arg15) {
            int v5 = v8 & 0x80;
            byte v1_1 = (byte)(v8 + v8);
            byte v0 = (byte)(v7 - 1);
            if(v0 == 0) {
                v7_1 = v2 + 1;
                v1_1 = arg11[v2];
                v0 = 8;
            }
            else {
                v7_1 = v2;
            }

            if(v5 == 0) {
                int v5_1 = v3 + 1;
                int v4_2 = v7_1 + 1;
                arg14[v3] = arg11[v7_1];
                v3 = v5_1 + 1;
                v2 = v4_2 + 1;
                v4_1 = arg11[v4_2];
                arg14[v5_1] = v4_1;
                v7 = v0;
                v8 = v1_1;
                continue;
            }

            int v8_1 = v1_1 & 0x80;
            byte v2_1 = (byte)(v1_1 + v1_1);
            byte v0_1 = (byte)(v0 - 1);
            if(v0_1 == 0) {
                v1_2 = v7_1 + 1;
                v5_2 = 8;
                v6 = arg11[v7_1];
            }
            else {
                v5_2 = v0_1;
                v6 = v2_1;
                v1_2 = v7_1;
            }

            if(v8_1 == 0) {
                v2_2 = v3 + 1;
                v0_2 = v1_2 + 1;
                byte v1_3 = arg11[v1_2];
                arg14[v3] = v1_3;
                v4_1 = v1_3;
            }
            else {
                v0_2 = v1_2;
                v2_2 = v3;
            }

            int v10 = v2_2 + 1;
            arg14[v2_2] = v4_1;
            int v7_2 = v6 & 0x80;
            byte v3_1 = (byte)(v6 + v6);
            byte v1_4 = (byte)(v5_2 - 1);
            if(v1_4 == 0) {
                v2 = v0_2 + 1;
                v5_3 = 8;
                v6_1 = arg11[v0_2];
            }
            else {
                v5_3 = v1_4;
                v6_1 = v3_1;
                v2 = v0_2;
            }

            if(v7_2 != 0) {
                int v9 = v10 + 1;
                arg14[v10] = v4_1;
                int v7_3 = v6_1 & 0x80;
                byte v1_5 = (byte)(v6_1 + v6_1);
                byte v0_3 = (byte)(v5_3 - 1);
                if(v0_3 == 0) {
                    v3_2 = v2 + 1;
                    v1_5 = arg11[v2];
                    v0_3 = 8;
                }
                else {
                    v3_2 = v2;
                }

                if(v7_3 != 0) {
                    int v2_3 = v9 + 1;
                    arg14[v9] = v4_1;
                    int v9_1 = v2_3 + 1;
                    arg14[v2_3] = v4_1;
                    int v2_4 = v1_5 & 0x80;
                    byte v1_6 = (byte)(v1_5 + v1_5);
                    byte v0_4 = (byte)(v0_3 - 1);
                    if(v0_4 == 0) {
                        v5_4 = v3_2 + 1;
                        v1_6 = arg11[v3_2];
                        v0_4 = 8;
                    }
                    else {
                        v5_4 = v3_2;
                    }

                    if(v2_4 != 0) {
                        int v6_2 = v9_1 + 1;
                        arg14[v9_1] = v4_1;
                        int v3_3 = v1_6 & 0x80;
                        byte v1_7 = (byte)(v1_6 + v1_6);
                        byte v0_5 = (byte)(v0_4 - 1);
                        if(v0_5 == 0) {
                            v2_5 = v5_4 + 1;
                            v1_7 = arg11[v5_4];
                            v0_5 = 8;
                        }
                        else {
                            v2_5 = v5_4;
                        }

                        if(v3_3 != 0) {
                            int v3_4 = v6_2 + 1;
                            arg14[v6_2] = v4_1;
                            int v5_5 = v3_4 + 1;
                            arg14[v3_4] = v4_1;
                            int v3_5 = v5_5 + 1;
                            arg14[v5_5] = v4_1;
                            int v5_6 = v3_5 + 1;
                            arg14[v3_5] = v4_1;
                            int v6_3 = v1_7 & 0x80;
                            byte v1_8 = (byte)(v1_7 + v1_7);
                            byte v0_6 = (byte)(v0_5 - 1);
                            if(v0_6 == 0) {
                                v3_6 = v2_5 + 1;
                                v1_8 = arg11[v2_5];
                                v0_6 = 8;
                            }
                            else {
                                v3_6 = v2_5;
                            }

                            if(v6_3 != 0) {
                                int v6_4 = v1_8 & 0x80;
                                byte v2_6 = (byte)(v1_8 + v1_8);
                                byte v1_9 = (byte)(v0_6 - 1);
                                if(v1_9 == 0) {
                                    v0_7 = v3_6 + 1;
                                    v7 = 8;
                                    v8 = arg11[v3_6];
                                }
                                else {
                                    v7 = v1_9;
                                    v8 = v2_6;
                                    v0_7 = v3_6;
                                }

                                if(v6_4 != 0) {
                                    int v1_10 = v5_6 + 1;
                                    arg14[v5_6] = v4_1;
                                    int v2_7 = v1_10 + 1;
                                    arg14[v1_10] = v4_1;
                                    int v1_11 = v2_7 + 1;
                                    arg14[v2_7] = v4_1;
                                    do {
                                        int v3_7 = v0_7 + 1;
                                        byte v0_8 = arg11[v0_7];
                                        if(v0_8 < 0) {
                                            int v0_9 = v0_8 + 0x100;
                                            v2_8 = v0_9;
                                            v5_7 = (byte)v0_9;
                                        }
                                        else {
                                            v2_8 = v0_8;
                                            v5_7 = v0_8;
                                        }

                                        if(v5_7 > 0x7F) {
                                            int v0_10 = v5_7 - 0x80 << 8;
                                            int v5_8 = v3_7 + 1;
                                            byte v2_9 = arg11[v3_7];
                                            if(v2_9 < 0) {
                                                v0_10 += 0x100;
                                            }

                                            int v3_8 = v0_10 + v2_9;
                                            v2_8 = v3_8;
                                            v0_7 = v5_8;
                                            v6_5 = v3_8;
                                        }
                                        else {
                                            v0_7 = v3_7;
                                            v6_5 = v5_7;
                                        }

                                        while(true) {
                                            int v3_9 = v2_8 - 1;
                                            if(v2_8 == 0) {
                                                break;
                                            }

                                            arg14[v1_11] = v4_1;
                                            v2_8 = v3_9;
                                            ++v1_11;
                                        }
                                    }
                                    while(v6_5 == 0x7FFF);

                                    v2 = v0_7;
                                    v3 = v1_11;
                                    continue;
                                }

                                int v1_12 = v5_6 + 1;
                                arg14[v5_6] = v4_1;
                                v3 = v1_12 + 1;
                                arg14[v1_12] = v4_1;
                                v2 = v0_7;
                                continue;
                            }

                            int v6_6 = v1_8 & 0x80;
                            byte v1_13 = (byte)(v1_8 + v1_8);
                            byte v0_11 = (byte)(v0_6 - 1);
                            if(v0_11 == 0) {
                                v2 = v3_6 + 1;
                                v1_13 = arg11[v3_6];
                                v0_11 = 8;
                            }
                            else {
                                v2 = v3_6;
                            }

                            if(v6_6 != 0) {
                                v3 = v5_6 + 1;
                                arg14[v5_6] = v4_1;
                                v7 = v0_11;
                                v8 = v1_13;
                                continue;
                            }

                            v7 = v0_11;
                            v8 = v1_13;
                            v3 = v5_6;
                            continue;
                        }

                        int v5_9 = v1_7 & 0x80;
                        byte v1_14 = (byte)(v1_7 + v1_7);
                        byte v0_12 = (byte)(v0_5 - 1);
                        if(v0_12 == 0) {
                            v3_10 = v2_5 + 1;
                            v1_14 = arg11[v2_5];
                            v0_12 = 8;
                        }
                        else {
                            v3_10 = v2_5;
                        }

                        if(v5_9 != 0) {
                            int v5_10 = v1_14 & 0x80;
                            byte v1_15 = (byte)(v1_14 + v1_14);
                            byte v0_13 = (byte)(v0_12 - 1);
                            if(v0_13 == 0) {
                                v2 = v3_10 + 1;
                                v1_15 = arg11[v3_10];
                                v0_13 = 8;
                            }
                            else {
                                v2 = v3_10;
                            }

                            if(v5_10 != 0) {
                                int v3_11 = v6_2 + 1;
                                arg14[v6_2] = v4_1;
                                int v5_11 = v3_11 + 1;
                                arg14[v3_11] = v4_1;
                                v3 = v5_11 + 1;
                                arg14[v5_11] = v4_1;
                                v7 = v0_13;
                                v8 = v1_15;
                                continue;
                            }

                            int v5_12 = v6_2 + 1;
                            arg14[v6_2] = v4_1;
                            v3 = v5_12 + 1;
                            arg14[v5_12] = v4_1;
                            v7 = v0_13;
                            v8 = v1_15;
                            continue;
                        }

                        int v5_13 = v1_14 & 0x80;
                        byte v1_16 = (byte)(v1_14 + v1_14);
                        byte v0_14 = (byte)(v0_12 - 1);
                        if(v0_14 == 0) {
                            v2 = v3_10 + 1;
                            v1_16 = arg11[v3_10];
                            v0_14 = 8;
                        }
                        else {
                            v2 = v3_10;
                        }

                        if(v5_13 != 0) {
                            v3 = v6_2 + 1;
                            arg14[v6_2] = v4_1;
                            v7 = v0_14;
                            v8 = v1_16;
                            continue;
                        }

                        v7 = v0_14;
                        v8 = v1_16;
                        v3 = v6_2;
                        continue;
                    }

                    v7 = v0_4;
                    v8 = v1_6;
                    v2 = v5_4;
                    v3 = v9_1;
                    continue;
                }

                int v5_14 = v1_5 & 0x80;
                byte v1_17 = (byte)(v1_5 + v1_5);
                byte v0_15 = (byte)(v0_3 - 1);
                if(v0_15 == 0) {
                    v2 = v3_2 + 1;
                    v1_17 = arg11[v3_2];
                    v0_15 = 8;
                }
                else {
                    v2 = v3_2;
                }

                if(v5_14 != 0) {
                    v3 = v9 + 1;
                    arg14[v9] = v4_1;
                    v7 = v0_15;
                    v8 = v1_17;
                    continue;
                }

                v7 = v0_15;
                v8 = v1_17;
                v3 = v9;
                continue;
            }

            v7 = v5_3;
            v8 = v6_1;
            v3 = v10;
        }

        return arg15;
    }
}

