package test;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import pages.Searchresult;

public class Search_test extends BaseClass{

	@Test
	public void perform()
	{
		Searchresult sr = new Searchresult(driver);
		sr.search();
	}
}
