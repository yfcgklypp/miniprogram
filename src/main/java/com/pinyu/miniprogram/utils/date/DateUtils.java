package com.pinyu.miniprogram.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author ypp
 */
public class DateUtils {

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYYMMDD = "yyyy年MM月dd日";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM = "yyyy-MM";
	public static final String MM_DD = "MM-dd";
	public static final DateFormat datetimeFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
	public static final String STR_EMPTY = "";
	
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			YYYY_MM_DD);
	public static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(
			YYYY_MM_DD_HH_MM_SS);

	public static String[] pattern = new String[] { "yyyyMMdd", YYYY_MM_DD,
			"yyyy/MM/dd", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMddHHmmss",
			YYYY_MM_DD_HH_MM_SS, "yyyy/MM/dd HH:mm:ss" };

	public static Date previous(int days) {
		return new Date(System.currentTimeMillis() - days * 3600000L * 24L);
	}

	public static Date addDay(Date date, int days) {
		return new Date(date.getTime() + days * 3600000L * 24L);
	}

	public static String formatDateTime(String format, long d) {
		return new SimpleDateFormat(format).format(d);
	}

	public static String formatDate(String format, Date d) {
		return new SimpleDateFormat(format).format(d);
	}
	public static String formatSortDate(Date date) {
		return new SimpleDateFormat(YYYY_MM).format(date);
	}
	public static String formatDate(Date date) {
		return new SimpleDateFormat(YYYY_MM_DD).format(date);
	}
	public static String formatDateZh(Date date) {
		return new SimpleDateFormat(YYYYMMDD).format(date);
	}
	public static String formatLongDate(Date date) {
		return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(date);
	}
	public static String formatFullDate(Date date) {
		return new SimpleDateFormat(YYYYMMDDHHMMSS).format(date);
	}

	public static Date parseDate(String format, String d) {
		try {
			return new SimpleDateFormat(format).parse(d);
		} catch (Exception e) {
		}
		return null;
	}

	public static Date getNextWeekDay(int weekDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		int addDateNumber = 0;
		if (Calendar.SUNDAY == calendar.get(Calendar.DAY_OF_WEEK)) {
			if (Calendar.SUNDAY == weekDay) {
				addDateNumber = 7;
			}
		} else {
			addDateNumber = 7;
			if (Calendar.SUNDAY == weekDay) {
				addDateNumber = 14;
			}
		}
		calendar.add(Calendar.DATE, addDateNumber);
		calendar.set(Calendar.DAY_OF_WEEK, weekDay);
		return calendar.getTime();
	}

	public static Date getThisWeekMonday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); // 获取周开始基准
		int current = calendar.get(Calendar.DAY_OF_WEEK); // 获取当天周内天数
		calendar.add(Calendar.DAY_OF_WEEK, min - current + 1); // 当天-基准，获取周开始日期
		return calendar.getTime();
	}

	/**
	 * 获取所在日期周的星期一(周一到周日为一周)
	 * 
	 * @return 日期所在周的星期一
	 */
	public static Date getWeekMonday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		int min = calendar.getActualMinimum(Calendar.DAY_OF_WEEK); // 获取周开始基准
		int current = calendar.get(Calendar.DAY_OF_WEEK); // 获取当天周内天数
		calendar.add(Calendar.DAY_OF_WEEK, min - current + 1
				+ (current == Calendar.SUNDAY ? -7 : 0)); // 当天-基准，获取周开始日期
		return calendar.getTime();
	}

	public static Date parse(String str) {
		try {
			return yyyyMMdd.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date parseLongDate(String str) {
		try {
			return yyyyMMddHHmmss.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getFirstDayOfMonth(String date) {
		return getFirstDayOfMonth(parse(date));
	}

	public static String getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(5, 1);
		return yyyyMMdd.format(cal.getTime());
	}

	public static Date addMonth(Date date, int count) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(2, count);
		return c.getTime();
	}

	public static String getCurrentDate() {
		return yyyyMMdd.format(new Date());
	}

	public static Date getTodayDate() {
		try {
			return yyyyMMdd.parse(getCurrentDate());
		} catch (ParseException e) {
			throw new RuntimeException();
		}
	}

	public static int getDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(7);
	}

	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(7);
	}

	public static int getDayOfWeek(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		return cal.get(7);
	}

	public static int getMaxDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(5);
	}

	public static String toString(Date date) {
		if (date == null)
			return "";
		else
			return yyyyMMdd.format(date);
	}

	public static String toString(Date date, String format) {
		SimpleDateFormat t = new SimpleDateFormat(format);
		return t.format(date);
	}

	// 获取当前年
	public static String getYear() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(new Date());
	}

	// 获取年
	public static String getYear(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(date);
	}

	// 获取当年月
	public static String getMonth() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		return formatter.format(new Date());
	}

	// 获取上月
	public static String getLastMonth(String month) {
		int month2 = NumberUtils.toInt(month);
		if (month2 == 1) {
			return 12 + "";
		} else {
			return (month2 - 1) + "";
		}
	}

	// 获取月
	public static String getMonth(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		return formatter.format(date);
	}

	// 获取当日
	public static String getDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		return formatter.format(new Date());
	}

	// 获取日
	public static String getDay(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		return formatter.format(date);
	}

	// 获取前后五年，组成10年
	public static List<String> getYearList() {
		List<String> list = new ArrayList<String>();
		int year = NumberUtils.toInt(getYear());
		for (int i = year - 5; i <= (year + 5); i++) {
			list.add(i + "");
		}
		return list;
	}

	/**
	 * 月
	 * 
	 * @return
	 */
	public static List<String> getMonthList() {
		List<String> list = new ArrayList<String>();
		list.add("01");
		list.add("02");
		list.add("03");
		list.add("04");
		list.add("05");
		list.add("06");
		list.add("07");
		list.add("08");
		list.add("09");
		list.add("10");
		list.add("11");
		list.add("12");
		return list;
	}

	// 获取前10年，组成10年
	public static List<String> get10YearList() {
		List<String> list = new ArrayList<String>();
		int year = NumberUtils.toInt(getYear());
		for (int i = year; i >= year - 10; i--) {
			list.add(i + "");
		}
		return list;
	}

	// 计算相差时间
	public static double dateDiff(String startTime, String endTime,
			String format) {
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long diff;
		double hour = 0;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			hour = (diff % nd) * 1.0f / nh;// 计算差多少小时

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// DecimalFormat df = new DecimalFormat("#.00");
		System.out.println(new Double(String.format("%.2f", hour)));
		return new Double(String.format("%.2f", hour));
	}

	// 计算婴儿年龄（月）
	public static float countAge(Date birthday) {
		float age = 0;
		int nowYear = NumberUtils.toInt(getYear());
		int nowMonth = NumberUtils.toInt(getMonth());
		int nowDay = NumberUtils.toInt(getDay());

		int year = NumberUtils.toInt(getYear(birthday));
		int month = NumberUtils.toInt(getMonth(birthday));
		int day = NumberUtils.toInt(getDay(birthday));

		if (nowDay < day) {
			nowMonth = nowMonth - 1;
			int ages = (nowDay + 30 - day) / 3;
			age = age + ((float) ages / 10);
		} else {
			int ages = (nowDay - day) / 3;
			age = ((float) ages / 10);
		}
		if (nowMonth < month) {
			nowYear = nowYear - 1;
			age = age + (nowMonth + 12 - month);
		} else {
			age = age + (nowMonth - month);
		}
		if ((nowYear - year) > 0) {
			age = age + (nowYear - year) * 12;
		}
		return age;

	}

	/**
	 * @param month
	 *            月数（向下取）
	 * @return
	 */
	public static String getMonthName(String month) {
		if (!NumberUtils.isNumber(month)) {
			return null;
		}
		double monthVal = NumberUtils.toDouble(month);
		int monthIntVal = NumberUtils.toInt(month.substring(0, month
				.indexOf(".")));
		if (monthVal < 0) {
			return null;
		} else if (monthVal < 2.5) {
			return "month2";
		} else if (monthVal < 7.0) {
			return "month" + monthIntVal
					+ ((monthVal - monthIntVal) * 10 >= 5 ? "p5" : "");
		} else if (monthVal < 37.0) {
			return "month" + monthIntVal;
		} else {
			return null;
		}
	}

	/**
	 * @param month
	 *            月数（向上取）
	 * @return
	 */
	public static String getMonthNameUpper(String month) {
		if (!NumberUtils.isNumber(month)) {
			return null;
		}
		double monthVal = NumberUtils.toDouble(month);
		int monthIntVal = NumberUtils.toInt(month.substring(0, month
				.indexOf(".")));
		if (monthVal < 0) {
			return null;
		} else if (monthIntVal < 2) {
			return "month2";
		} else if (monthIntVal < 7) {
			int t_month = monthIntVal;
			if ((monthVal - monthIntVal) * 10 > 5.1) {
				t_month += 1;
			}
			return "month" + t_month
					+ ((monthVal - monthIntVal) * 10 < 5.1 ? "p5" : "");
		} else if (monthVal < 36.1) {
			int t_month = monthIntVal;
			if ((monthVal - monthIntVal) * 10 > 0.1) {
				t_month += 1;
			}
			return "month" + t_month;
		} else {
			return null;
		}
	}

	/**
	 * @param month
	 *            月数（中间）
	 * @return
	 */
	public static String getMonthNameMiddle(String month) {
		if (!NumberUtils.isNumber(month)) {
			return null;
		}
		double monthVal = NumberUtils.toDouble(month);
		int monthIntVal = NumberUtils.toInt(month.substring(0, month
				.indexOf(".")));
		if (monthVal < 0) {
			return null;
		} else if (monthIntVal < 2) {
			return "month2";
		} else if (monthIntVal < 7) {
			int t_month = monthIntVal;

			return "month" + t_month + "p5";
		} else if (monthVal < 36.1) {
			int t_month = monthIntVal;

			return "month" + t_month;
		} else {
			return null;
		}
	}

	public static List<WeekDay> getDisplayWeekDays(Date startTime, Date endTime) {
		List<WeekDay> weekDays = new ArrayList<WeekDay>();
		Date date = startTime;
		long endTimeLong = endTime.getTime();
		while (date.getTime() <= endTimeLong) {
			weekDays.add(new WeekDay(date));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			date = calendar.getTime();
		}
		return weekDays;
	}

	public static class WeekDay {

		private Date date;

		private static final String[] WEEK_DAY_NAME = { "星期日", "星期一", "星期二",
				"星期三", "星期四", "星期五", "星期六" };

		public WeekDay() {
		}

		public WeekDay(Date date) {
			this.setDate(date);
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@SuppressWarnings("deprecation")
		@Override
		public String toString() {
			return yyyyMMdd.format(date) + "(" + WEEK_DAY_NAME[date.getDay()]
					+ ")";
		}
		
		public String getDay(){
			return WEEK_DAY_NAME[date.getDay()];
		}
	}
}