package Webq.Locator;

import java.io.IOException;
import java.util.HashMap;

import Webq.utils.Log;

/**
 * This is for element library
 * Locator类包含：元素的定位信息或者名称，元素位置信息的类型
 * locator对象，包含三要素，：元素名称或者路径，停留时间，元素类型
 * 之所以称为locator，是因为包含了位置信息
 * @author Young
 *
 */
public class WebqLocator {
	
	private String element;
	private int waitSec;


	/**
	 * create a enum variable for By
	 * @author 700sfriend ！！！！调用什么值，就返回什么值
	 * @author Young
	 *
	 */
	public enum WebqByType {
		xpath, id, linkText, name, className, cssSelector, partialLinkText, tagName
	}

	private WebqByType byType;

	
	/**
	 * 
	 * 
	 * 4 个构造函数
	 * 
	 */
	
	public WebqLocator() {

	}

	/**
	 * defaut Locator ,use Xpath
	 * 1、接受传入的参数，该参数用来描述元素的位置或者名称,即该参数=element
	 * 2、返回一个byType对象，该对象为ByType类型的字符串，值为参数传进来时的xpath路径
	 * 3、设置了element为元素路径或者名称
	 * @author Young
	 * @param element
	 */
	public WebqLocator(String element) {
		this.element = element;
		this.waitSec = 3;
		this.byType = WebqByType.xpath;
	}

	public WebqLocator(String element, int waitSec) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = WebqByType.xpath;
	}

	public WebqLocator(String element, int waitSec, WebqByType byType) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = byType;
	}

	/**
	 * @author 700sfriend
	 * 1、返回一个String
	 * 2、该String是常规的元素定位路径的名称，即locatorname
	 * @return
	 */
	public String getElement() {
		return element;
	}

	public int getWaitSec() {
		return waitSec;
	}

	/**
	 * @author 700sfriend
	 * 明确元素定位信息的类型
	 * @return
	 */
	public WebqByType getBy() {
		return byType;
	}

	public void setBy(WebqByType byType) {
		this.byType = byType;
	}
	
	
	
	
}
