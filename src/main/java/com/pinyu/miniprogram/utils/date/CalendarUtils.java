package com.pinyu.miniprogram.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ypp 创建时间：2018年10月10日 下午3:55:09
 */
public class CalendarUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
	private static Calendar startDate = Calendar.getInstance();
	private static Calendar endDate = Calendar.getInstance();
	private static DateFormat df = DateFormat.getDateInstance();
	private static Date earlydate = new Date();
	private static Date latedate = new Date();

	/**
	 * * 计算两个时间相差多少个年 * 
	 * * @param early 
	 * * @param late 
	 * * @return * @throws
	 * ParseException
	 */
	public static int yearsBetween(String start, String end) throws ParseException {
		startDate.setTime(sdf.parse(start));
		endDate.setTime(sdf.parse(end));
		return (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));
	}
	public static int yearsBetween(Date start, Date end) throws ParseException {
		startDate.setTime(start);
		endDate.setTime(end);
		return (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));
	}

	/**
	 * * 计算两个时间相差多少个月 * 
	 * * @param date1 
	 * * @param date2 *
	 * * @return int 
	 * * @throws ParseException
	 */
	public static int monthsBetween(String start, String end) throws ParseException {
		startDate.setTime(sdf.parse(start));
		endDate.setTime(sdf.parse(end));
		int result = yearsBetween(start, end) * 12 + endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH);
		return result == 0 ? 1 : Math.abs(result);
	}
	public static int monthsBetween(Date start, Date end) throws ParseException {
		startDate.setTime(start);
		endDate.setTime(end);
		int result = yearsBetween(start, end) * 12 + endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH);
		return result == 0 ? 1 : Math.abs(result);
	}

	/**	 
	 * * 计算两个时间相差多少个天	 
	 * * 	 
	 * * @param early	 
	 * * @param late	 
	 * * @return	 
	 * * @throws ParseException	 
	 * */	
	public static int daysBetween(String start, String end) throws ParseException {		
		// 得到两个日期相差多少天		
		return hoursBetween(start, end) / 24;	
	}
	public static int daysBetween(Date start, Date end) throws ParseException {		
		// 得到两个日期相差多少天		
		return hoursBetween(start, end) / 24;	
	}
	/**	 * 计算两个时间相差多少小时	 * 	 
	 * * @param early	 
	 * * @param late	 
	 * * @return	 
	 * * @throws ParseException	 
	 * */	
	public static int hoursBetween(String start, String end) throws ParseException {		
		// 得到两个日期相差多少小时		
		return minutesBetween(start, end) / 60;	
	}
	public static int hoursBetween(Date start, Date end) throws ParseException {		
		// 得到两个日期相差多少小时		
		return minutesBetween(start, end) / 60;	
	}
	/**	 * 计算两个时间相差多少分	 * 	 
	 * * @param early	 
	 * * @param late	 
	 * * @return	 
	 * * @throws ParseException	 
	 * */	
	public static int minutesBetween(String start, String end) throws ParseException {		
		// 得到两个日期相差多少分		
		return secondesBetween(start, end) / 60;	 	
	}
	public static int minutesBetween(Date start, Date end) throws ParseException {		
		// 得到两个日期相差多少分		
		return secondesBetween(start, end) / 60;	 	
	}
	/**	 * 计算两个时间相差多少秒	 * 	 
	 * * @param early	 
	 * * @param late	 
	 * * @return	 
	 * * @throws ParseException	 
	 * */	
	public static int secondesBetween(String start, String end) throws ParseException {		
		earlydate = df.parse(start);		
		latedate = df.parse(end);		
		startDate.setTime(earlydate);		
		endDate.setTime(latedate);		
		// 设置时间为0时		
		startDate.set(Calendar.HOUR_OF_DAY, 0);		
		startDate.set(Calendar.MINUTE, 0);		
		startDate.set(Calendar.SECOND, 0);		
		endDate.set(Calendar.HOUR_OF_DAY, 0);		
		endDate.set(Calendar.MINUTE, 0);		
		endDate.set(Calendar.SECOND, 0);		
		// 得到两个日期相差多少秒		
		return ((int) (endDate.getTime().getTime() / 1000) - (int) (startDate.getTime().getTime() / 1000));	
	}
	public static int secondesBetween(Date start, Date end) throws ParseException {		
		earlydate = start;		
		latedate = end;		
		startDate.setTime(earlydate);		
		endDate.setTime(latedate);		
		// 设置时间为0时		
		startDate.set(Calendar.HOUR_OF_DAY, 0);		
		startDate.set(Calendar.MINUTE, 0);		
		startDate.set(Calendar.SECOND, 0);		
		endDate.set(Calendar.HOUR_OF_DAY, 0);		
		endDate.set(Calendar.MINUTE, 0);		
		endDate.set(Calendar.SECOND, 0);		
		// 得到两个日期相差多少秒		
		return ((int) (endDate.getTime().getTime() / 1000) - (int) (startDate.getTime().getTime() / 1000));	
	}
	/**	 
	 * * @param args	 
	 * * @throws ParseException	 
	 * */	
	public static void main(String[] args) throws ParseException {		
		System.out.println(yearsBetween("2016-8-15", "2017-2-1"));		
		System.out.println(monthsBetween("2016-8-15", "2017-3-1"));		
		System.out.println(daysBetween("2016-8-15", "2017-3-1")); 	
		System.out.println(getLastYearMonth());
	}
	/***
	 * 获取日期
	 * @author ypp
	 * @Title: secondesBetween 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param start
	 * @param @param end
	 * @param @return
	 * @param @throws ParseException  
	 * @return  返回类型 
	 * @throws
	 */
	public static int getDay(Date date) throws ParseException {	
		Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(date);//设置当前日期
        return calendar.get(Calendar.DATE);//获取日
	}
	/***
	 * 获取年份
	 * @author ypp
	 * @Title: getDay 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param date
	 * @param @return
	 * @param @throws ParseException  
	 * @return  返回类型 
	 * @throws
	 */
	public static int getYear(Date date) throws ParseException {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
	/***
	 * 获取月份
	 * @author ypp
	 * @Title: getMonth 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param date
	 * @param @return
	 * @param @throws ParseException  
	 * @return  返回类型 
	 * @throws
	 */
	public static int getMonth(Date date) throws ParseException {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH)+1;
	}
	
	
	/***
	 * 获取N个工作日后的日期
	 * @author ypp
	 * @Title: getScheduleActiveDate 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param list
	 * @param @return
	 * @param @throws ParseException  
	 * @return  返回类型 
	 * @throws
	 */
    public static Date getScheduleActiveDate(List<String> list) throws ParseException {
//        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());//获取当前日期2018-08-26
        Date today = new Date();//Mon Aug 27 00:09:29 CST 2018
        Date tomorrow = null;
        int delay = 1;
        int num = 10;//根据需要设置,这个值就是业务需要的n个工作日
        while(delay <= num){
            tomorrow = getTomorrow(today);
            //当前日期+1即tomorrow,判断是否是节假日,同时要判断是否是周末,都不是则将scheduleActiveDate日期+1,直到循环num次即可
            if(!isWeekend(sdf.format(tomorrow)) && !isHoliday(sdf.format(tomorrow),list)){
                delay++;
                today = tomorrow;
            } else if (isWeekend(sdf.format(tomorrow))){
//                tomorrow = getTomorrow(tomorrow);
                today = tomorrow;
                System.out.println(sdf.format(tomorrow) + "::是周末");
            } else if (isHoliday(sdf.format(tomorrow),list)){
//                tomorrow = getTomorrow(tomorrow);
                today = tomorrow;
                System.out.println(sdf.format(tomorrow) + "::是节假日");
            }
        }
        System.out.println("10个工作日后,即计划激活日期为::" + sdf.format(today));
        return today;
    }

    /**
     * 获取明天的日期
     *
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断是否是weekend
     *
     * @param sdate
     * @return
     * @throws ParseException
     */
    public static boolean isWeekend(String sdate) throws ParseException {
        Date date = sdf.parse(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            return true;
        } else{
            return false;
        }

    }

    /**
     * 判断是否是holiday
     *
     * @param sdate
     * @param list
     * @return
     * @throws ParseException
     */
    public static boolean isHoliday(String sdate, List<String> list) throws ParseException {
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                if(sdate.equals(list.get(i))){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 获取往后延续N天后的日期
     * @author ypp
     * @Title: getDelayDay 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param num
     * @param @return  
     * @return  返回类型 
     * @throws
     */
    public static Date getDelayDay(Date date,Integer num){
    	Calendar instance = Calendar.getInstance();
    	instance.setTime(date);
    	instance.add(Calendar.DATE, num);
    	return instance.getTime();
    }
    public static Date getDelayMonth(Date date,Integer num){
    	Calendar instance = Calendar.getInstance();
    	instance.setTime(date);
    	instance.add(Calendar.MONTH, num);
    	return instance.getTime();
    }
    /**
     * 获取某月份有多少天
     * @author ypp
     * @Title: getDelayDay 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param year
     * @param @param month
     * @param @return  
     * @return  返回类型 
     * @throws
     */
    public static int getMonthDayCount(int year,int month){
    	Calendar cal = Calendar.getInstance(); 
    	cal.set(Calendar.YEAR,year); 
    	cal.set(Calendar.MONTH, month - 1);//Java月份才0开始算 
    	return cal.getActualMaximum(Calendar.DATE);
    }
    /**
     * 设置日期
     * @author ypp
     * @Title: getMonthDayCount 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param date
     * @param @param day
     * @param @return  
     * @return  返回类型 
     * @throws
     */
    public static Date setDay(Date date,Integer day){
    	Calendar instance = Calendar.getInstance();
    	instance.setTime(date); 
    	instance.set(Calendar.DATE, day);
    	return instance.getTime();
    }
    
    /**
     * 获取上月日期，如现在是2018-11，则返回2018-10
     * @return
     */
    public static String getLastYearMonth(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = ym.format(m);
		return mon;
    }
    
}
