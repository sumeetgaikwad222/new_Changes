package test;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import pages.Cart;
import pages.Landing_Page;

public class Landipage_test extends BaseClass{
	@Test
	public void perform()
	{
		Landing_Page lp = new Landing_Page(driver);
		lp.plus();
		
//		Cart cr = new Cart(driver);
//		cr.qty();
	}

}
