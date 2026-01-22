package basepackage;

public interface Constant {
	String Baseurl = "https://demoqa.com/text-box";
	//FMCG creds
	String FMCGemail = "neha.agarwal@freshbite.in";
	String FMCGpassword = "12345Su@";
	String FMCGdashboard = "https://nutra-menu.in1.apiqcloud.com/fmcg/dashboard";
	
	//FBO creds
	String FBOemail = "sumeetgaikwad222@gmail.com";
	String FBOpassword = "12345Su@";
	String FBOdashboard = "https://nutra-menu.in1.apiqcloud.com/fbo/dashboard";
	
	//Drivers paths
	String ChromeDriverPath = "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	String MSEDGEDriverPath = "C:\\Users\\SUMEET GAIKWAD\\Drivers\\edgedriver_win64\\msedgedriver.exe";
	String ChromDriverKey = "webdriver.chrome.driver";
	String MSEDGEKey = "webdriver.edge.driver";
	
	//Excel Data
	String ValidExcelFile = "./src/test/resources/sheet.xlsx";
	String Validsheet = "Valid";
	String InvalidSheet = "Invalid";
	
	//Config path
	String Config = "./src/test/resources/config.properties";
	
	//Waits
	 int IMPLICIT_WAIT = 10;
	 int EXPLICIT_WAIT = 20; 
	 int PAGE_LOAD_TIMEOUT = 60;
	 int SCRIPT_TIMEOUT = 30;
	 
	 //Invalid creds
	 String Invalidemail = "abcd@gmail.com";
	 String Invaludpassword = "123400Su@";
	 String ScreenShot = "./data";

	 
	 String firstname = "sumeet";
	 String lastname = "gaikwad";
	 String username = "sumeetgaikwad222@gmail.com";
	 String password = "7338443824Su@";
	 String email = "sumeet@gmail.com";
	 String phonenumber = "9988776655";
	 String currentaddress = "123 Main Street\r\n"
	 		+ "Anytown, NY 12345\r\n"
	 		+ "USA";
	 String permanantaddress = "456 Oak Avenue\r\n"
	 		+ "Floor 2, Suite 200\r\n"
	 		+ "Springfield, IL 62704\r\n"
	 		+ "USA";
	 String zipcode = "582540";
	 String appartmentnumber = "456";
	 
	 String screenshotfolder= "./src/test/resources/";
	 String companyname = "aasa technologies";
	 String contryname = "India";
	 String Statename = "maharashtra";
	 String city = "Pune";
	 String Town = "Wadgao";
	 String dummycomment = "There is noting to add";
}
