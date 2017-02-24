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
		/*商品详情页的操作:判断库存--重选颜色--进入购物车*/
		PageProduct.PlCartProduct(driver);	
	}
	
	
	/*
	 * Wap：操作
	 */
	@Test
	public void actionExProPagesWap() throws Exception {

		/*商品AD页面*/
		PageAd.PlCartAdWap(driver);	
		/*商品详情页的操作:判断库存--重选颜色--进入购物车*/
		PageProduct.PlCartProductWap(driver);
	}

	/**
	 * 验证商品的状态为“预定”
	 * @throws InterruptedException
	 */
	public void actionExProInfoState() throws InterruptedException {
		// TODO Auto-generated method stub
		PageProduct.PlCheckSubScribeState(driver);
	}

	public void actionExProInfoSize() throws InterruptedException {
		// TODO Auto-generated method stub	
	}

	public void actionExProInfoStock() throws InterruptedException {
		// TODO Auto-generated method stub
	}

	/**
	 * 验证商品缺省显示为有货的SKU颜色，且按钮状态正确
	 */
	public void actionExProInfoAutoChangeSKU() {
		// TODO Auto-generated method stub
		PageProduct.PlCheckAutoChangeSKU(driver,"灰色","加入购物车");
	}
	
	/**
	 * 验证商品+和-号的数量
	 */
	public void actionExProInfoChangeNum() {
		// TODO Auto-generated method stub
		PageProduct.PlCheckChangeNum(driver);
	}
	
	/**
	 * 检查商品的最大数量和最小数量
	 */
	public void actionExProInfoTopNum() {
		// TODO Auto-generated method stub
		PageProduct.PlCheckTopNum(driver);
	}
}
