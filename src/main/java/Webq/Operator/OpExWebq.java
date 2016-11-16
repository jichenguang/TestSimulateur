package Webq.Operator;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import Webq.Page.PageAd;
import Webq.Page.PageProduct;
import Webq.utils.TestNGListener;

@Listeners({ TestNGListener.class })
public class OpExWebq  {

	WebDriver driver = null;
	
	public OpExWebq(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@Test
	public void actionExProPages() throws Exception {

		/*商品AD页面*/
		PageAd.PlCartAd(driver);	
		/*商品详情页的操作*/
		PageProduct.PlCartProduct(driver);
	
	}
	
	/*
	 * Wap：操作
	 */
	@Test
	public void actionExProPagesWap() throws Exception {

		/*商品AD页面*/
		PageAd.PlCartAdWap(driver);	
		/*商品详情页的操作*/
		PageProduct.PlCartProductWap(driver);
	
	}

}
