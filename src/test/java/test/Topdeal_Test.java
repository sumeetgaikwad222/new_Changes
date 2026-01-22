package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import junit.framework.Assert;
import pages.Topdeals;

public class Topdeal_Test extends BaseClass{
	@Test
	public void check()
	{
		Topdeals tp = new Topdeals(driver);
		tp.pefrom();
		
		List<String> actualnames = tp.sort();
		
		List<String> exp = new ArrayList<>(actualnames);
		Collections.sort(exp);
		
		Assert.assertEquals(exp, actualnames);
		System.out.println(actualnames);
		System.out.println(exp);
		
		System.out.println("ln");
		List<Integer> act = tp.sortbyprice();
		
		List<Integer> exp3 = new ArrayList<>(act);
		
		Collections.sort(exp3);
		
		Assert.assertEquals(exp3, act);
		System.out.println(exp3);
		System.out.println(act);
		
		System.out.println("ln");
		List<Integer> actdisprice = tp.discountprice();
		
		List<Integer> expdisprice = new ArrayList<>(actdisprice);
		
		Assert.assertEquals(expdisprice, actdisprice);
		System.out.println(expdisprice);
		System.out.println(actdisprice);
		}
}
