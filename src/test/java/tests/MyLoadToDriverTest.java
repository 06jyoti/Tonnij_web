package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import web.pages.CloseLoad;
import web.pages.CreateLoadPage;
import web.pages.LoginSignUPPage;
import web.testdata.CreateLoad;
import web.testdata.LoginSignUP;

public class MyLoadToDriverTest extends BaseTest {

	public LoginSignUPPage login;
	public CreateLoadPage load;
	public CloseLoad closeLoad;

	@BeforeClass
	public void setup() {
		driver.set(driverFactory.initialize());
		login = new LoginSignUPPage(driver.get());
		login.navigateToURL(URL);
		login.userLoginn(LoginSignUP.EMAIL, LoginSignUP.PASSWORD);
		load = new CreateLoadPage(driver.get());
		closeLoad= new CloseLoad(driver.get());

	}

	
	
	@Test( priority = 1, enabled=true)
	public void VerifyiClientIsAbleToAssignMyLoadToDriver() throws Exception {
		load.MyLoad( CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME,  CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);
		
		load.dispatchBoard(CreateLoad.REMARKS);

			
	}
	
	@Test( priority = 2, enabled=true)
	public void VerifyiClientIsAbleToAssignMyLoadToVendor() throws Exception {
		load.MyLoad( CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME,  CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);
		
		load.assignLoadToVendor(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);					
	}
	
	
	@Test( priority = 3, enabled=true)
	public void VerifyiClientIsAbleToAssignMyLoadToBoth() throws Exception {
		load.MyLoad( CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME,  CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);
			
		load.assignLoadToBoth(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);		

	}
	
	@Test( priority = 4, enabled=true)
	public void VerifyiClientIsAbleToAssignMyLoadToBothclose() throws Exception {
		load.MyLoad( CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME,  CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);
			
		load.assignLoadToVendor(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);		
		
		closeLoad.closeVendorLoad(CreateLoad.UPLOAD_PDF,CreateLoad.UNIT_1, CreateLoad.UNIT_2, CreateLoad.TKT_1, CreateLoad.TKT_2); 

	}
	
}


