package Webq.utils;

import org.testng.Reporter;

/**
 * Created by zombie on 2015年1月24日
 * chen_peng06@163.com
 */



public class ReportNGLog {


	/**
	 * @author
	 * 负责reportNG的日志输出
	 * Add log info into html report
	 */
	    public static void info(String s) {
	        Reporter.log(s.toString().trim());
	    }
	
}
