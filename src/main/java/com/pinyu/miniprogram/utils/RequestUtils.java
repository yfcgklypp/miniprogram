package com.pinyu.miniprogram.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getHeader(HttpServletRequest request,String headerName) {
        return request.getHeader(headerName);
    }
}
