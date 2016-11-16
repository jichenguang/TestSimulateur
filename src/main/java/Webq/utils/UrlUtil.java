package Webq.utils;

import java.io.UnsupportedEncodingException;
/**
 * url转码、解码
 * @seehttp://www.cnblogs.com/haha12/p/4344992.html
 * @author lifq 
 * @date 2015-3-17 下午04:09:35
 */
public  class UrlUtil {
	
	@SuppressWarnings("unused")
	private String str;
	private static String ENCODE = "UTF-8"; 
	
	/*构造函数，用于外部调用*/
	@SuppressWarnings("static-access")
	public UrlUtil(String str,String ENCODE){
		this.str = str;
		this.ENCODE = ENCODE;
	}
	
    
    /**
     * URL 解码
     * @seehttp://www.cnblogs.com/haha12/p/4344992.html
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:09:51
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * URL 转码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:10:28
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 
     * @return void
     * @author lifq
     * @date 2015-3-17 下午04:09:16
     */
    public static void main(String[] args) {
        String str = "http://webq.700paper.cn/wap/search/%E8%87%AA%E8%A1%8C%E8%BD%A6";
        System.out.println(getURLEncoderString(str));
        System.out.println(getURLDecoderString(str));
        
    }

}