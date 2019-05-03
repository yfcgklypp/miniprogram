package com.pinyu.miniprogram.utils.result;

/**
 * ypp
 */
public class Code {

    public static int UNKNOWN_ERROR = 0;
    public static int NOTFiND_ENTITY = 1;
    public static int PROCEDURE_ABNORMAL = 2;
    public static int  MISSING_PARAMETER = 3;

    public static String[] Msg = new String[]{
            "未知错误",
            "没有找到对应模型信息",
            "程序异常",
            "缺少参数"
    };
}
