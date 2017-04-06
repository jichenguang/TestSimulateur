package Webq.Operator;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import Webq.Page.PageAd;
import Webq.Page.PageCart;
import Webq.Page.PageOrder;
import Webq.Page.PageOrderDetails;
import Webq.Page.PageOrderLists;
import Webq.Page.PageOrderPay;
import Webq.Page.PageProduct;
import Webq.Page.PageTransitional;
import Webq.utils.TestNGListener;


/**
 * Case:从加购物车到取消订单
 * Operator:操作顺序，根据需要可编辑
 * Action：业务层，根据需要可编辑
 * @author 700sfriend
 *
 */
@Listeners({ TestNGListener.class })
public class OpStoreAll  {

	WebDriver driver = null;


	public OpStoreAll(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	@Test(groups = "loginTest")
	public void actionCartSubCancleOrder() throws Exception {				
		/*先清空购物车*/
		PageCart.ClearCart(driver);
		/*商品AD页面*/
		PageAd.PlCartAd(driver);
		/*商品详情页的操作*/
		PageProduct.PlCartProduct(driver);
		/*过渡页面*/
		PageTransitional.PlTransitional(driver);
		/*加入购物车*/
		PageCart.PlCart(driver);
		/*提交订单*/
		PageOrder.PlOrder(driver);
		/*支付页面确认提交状态*/
		PageOrderPay.PlOrderPay(driver);
		/*订单列表页面*/
		PageOrderLists.PlOrder(driver);
		/*订单详情页面*/
		PageOrderDetails.PlOrder(driver);		
	}
	

	@Test(groups = "loginTest")
	public void actionCartSubCancleOrderWap() throws Exception {

		/*商品AD页面*/
		PageAd.PlCartAdWap(driver);
		/*商品详情页的操作*/
		PageProduct.PlCartProductWap(driver);
		/*加入购物车*/
		PageCart.PlCartWap(driver);
		/*提交订单*/
		PageOrder.PlOrderWap(driver);
		/*支付页面确认提交状态*/
//		PageOrderPay.PlOrderPayWap(driver);
		/*订单列表页面*/
		PageOrderLists.PlOrderListWap(driver);
		/*订单详情页面*/
		PageOrderDetails.PlOrderDetailsWap(driver);	
	}
	
	/**
	 * 用例：验证运费。
	 * @throws InterruptedException 
	 */
	public void actionCarriage() throws InterruptedException{
		/*商品AD页面*/
		PageAd.PlCartAd(driver);
		/*商品详情页的操作*/
		PageProduct.PlCartProduct(driver);
		/*过渡页面*/
		PageTransitional.PlTransitional(driver);
		/*加入购物车*/
		PageCart.PlCart(driver);
		/*提交订单*/
		PageOrder.PlOrder(driver);
		/*支付页面确认提交状态*/
		PageOrderPay.PlOrderPay(driver);
		/*订单列表页面*/
		PageOrderLists.PlOrder(driver);
		/*订单详情页面*/
		PageOrderDetails.PlOrder(driver);		
	}
	

}
