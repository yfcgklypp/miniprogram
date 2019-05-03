package com.pinyu.miniprogram.utils.http;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.pinyu.miniprogram.utils.date.DateUtils;
/**
 * @author ypp
 */
public final class HttpUtils {

    public static String getURL(HttpServletRequest request) {
        StringBuffer sb = request.getRequestURL();
        String queryString = request.getQueryString();
        if(queryString!=null)
            return sb.toString() + "?" + queryString;
        return sb.toString();
    }
    public static Date getDate(HttpServletRequest request, String paramName, Date defaultValue) throws ParseException {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return new SimpleDateFormat(DateUtils.YYYY_MM_DD).parse(s);
    }
    public static int getInt(HttpServletRequest request, String paramName, int defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return Integer.parseInt(s);
    }
    public static int getInt(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Integer.parseInt(s);
    }
    public static long getLong(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Long.parseLong(s);
	}
    public static boolean getBoolean(HttpServletRequest request, String paramName, boolean defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return Boolean.parseBoolean(s);
    }
    public static boolean getBoolean(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Boolean.parseBoolean(s);
    }
    public static float getFloat(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        return Float.parseFloat(s);
    }
    public static String getString(HttpServletRequest request, String paramName, String defaultValue) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            return defaultValue;
        return s;
    }
    public static String getString(HttpServletRequest request, String paramName) {
        String s = request.getParameter(paramName);
        if(s==null || s.equals(""))
            throw new NullPointerException("Null parameter: " + paramName);
        return s;
    }
    private static String htmlEncode(String text) {
        if(text==null || "".equals(text))
            return "";
        text = text.replace("<", "&lt;");
        text = text.replace(">", "&gt;");
        text = text.replace(" ", "&nbsp;");
        text = text.replace("\"", "&quot;");
        text = text.replace("\'", "&apos;");
        return text.replace("\n", "<br/>");
    }
    
    public static final Integer[] convertStringToIntArray(String source, String split) {
		String[] strArray = source.split(split);
		Integer[] intArray = new Integer[strArray.length];
		for (int i = 0, size = intArray.length; i < size; i++) {
			intArray[i] = NumberUtils.toInt(strArray[i].trim());
		}
		return intArray;
	}
	public static final Long[] convertStringToLongArray(String source, String split) {
		String[] strArray = source.split(split);
		Long[] longArray = new Long[strArray.length];
		for (int i = 0, size = longArray.length; i < size; i++) {
			longArray[i] = NumberUtils.toLong(strArray[i].trim());
		}
		return longArray;
	}
	/**
	 * 除法，计算保留小数点两位
	 * @param i
	 * @param j
	 * @return
	 */
	public static String getDouble(double i,double j){
		if(i==0){
			return "0";
		}
		double k = (i/j)*100;
		if(k==0){
			return "0";
		}
		DecimalFormat df = new DecimalFormat("#.00");
        return df.format(k)+"%";

	}
    /**
     * Create a FormBean and bind data to it. Example: If found a parameter named "age", 
     * the object's setAge() method will be invoked if this method exists. 
     * If a setXxx() method exists but no corrsponding parameter, this setXxx() 
     * method will never be invoked.<br/>
     * <b>NOTE:</b> only public setXxx() method can be invoked successfully.
     */
	public static Object createFormBean(HttpServletRequest request, Class<?> c) {
        Object bean;
        try {
            bean = c.newInstance();
        }
        catch (Exception e) {
            return new Object();
        }
        Method[] ms = c.getMethods();
        for(int i=0; i<ms.length; i++) {
            String name = ms[i].getName();
            if(name.startsWith("set")) {
                @SuppressWarnings("rawtypes")
				Class[] cc = ms[i].getParameterTypes();
                if(cc.length==1) {
                    String type = cc[0].getName(); // parameter type
                    try {
                        // get property name:
                        String prop = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        // get parameter value:
                        String param = getString(request, prop);
                        if(param!=null && !param.equals("")) {
                            if(type.equals("java.lang.String")) {
                                ms[i].invoke(bean, new Object[] {htmlEncode(param)});
                            }
                            else if(type.equals("int") || type.equals("java.lang.Integer")) {
                                ms[i].invoke(bean, new Object[] {new Integer(param)});
                            }
                            else if(type.equals("long") || type.equals("java.lang.Long")) {
                                ms[i].invoke(bean, new Object[] {new Long(param)});
                            }
                            else if(type.equals("boolean") || type.equals("java.lang.Boolean")) {
                                ms[i].invoke(bean, new Object[] { Boolean.valueOf(param) });
                            }
                            else if(type.equals("float") || type.equals("java.lang.Float")) {
                                ms[i].invoke(bean, new Object[] {new Float(param)});
                            }
                            else if(type.equals("java.util.Date")) {
                                Date date = null;
                                if(param.indexOf(':')!=(-1))
                                    date = DateUtils.parseDate(DateUtils.YYYY_MM_DD_HH_MM_SS,param);
                                else
                                    date = DateUtils.parseDate(DateUtils.YYYY_MM_DD,param);
                                if(date!=null)
                                    ms[i].invoke(bean, new Object[] {date});
                                else
                                    System.err.println("WARNING: date is null: " + param);
                            }
                        }
                    }
                    catch(Exception e) {
                        System.err.println("WARNING: Invoke method " + ms[i].getName() + " failed: " + e.getMessage());
                    }
                }
            }
        }
        return bean;
    }
}