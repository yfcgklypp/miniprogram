package com.pinyu.miniprogram.utils.result;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pinyu.miniprogram.utils.date.DateUtils;

/***
 * @author ypp
 */
public class JsonMsg {
	private final static String Msg_SUCCESS = "success";
	private final static String Msg_ERROR = "error";

	public final static Integer Msg_SUCCESS_CODE = 1;
	public final static Integer Msg_ERROR_CODE = 0;

	public static String OK(Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_SUCCESS_CODE);
		map.put("msg", Msg_SUCCESS);
		map.put("data", data);
		// return new JSONObject(map,
		// SerializerFeature.WriteMapNullValue).toString();
		String string = JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
		
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}

	public static String OKSaas(Map<String, Object> map) {
		map.put("code", Msg_SUCCESS_CODE);
		map.put("msg", Msg_SUCCESS);
		// return new JSONObject(map,
		// SerializerFeature.WriteMapNullValue).toString();
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}

	public static String OKCentralized(Object wifiDevice, Object lockDevice, Object electricDevice) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_SUCCESS_CODE);
		map.put("msg", Msg_SUCCESS);
		map.put("wifiDevice", wifiDevice);
		map.put("lockDevice", lockDevice);
		map.put("electricDevice", electricDevice);
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}

	public static String OK() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_SUCCESS_CODE);
		map.put("msg", Msg_SUCCESS);
		return new JSONObject(map).toString();
	}
	
	public static String Error() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_ERROR_CODE);
		map.put("msg", Msg_ERROR);
		return new JSONObject(map).toString();
	}

	public static String Error(int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_ERROR_CODE);
		map.put("msg", Code.Msg[i]);
		return new JSONObject(map).toString();
	}

	public static String Error(String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_ERROR_CODE);
		map.put("msg", msg);
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}

	public static String Error(int i, String data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", Msg_ERROR_CODE);
		map.put("msg", Code.Msg[i]);
		map.put("data", data);
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}
}
