package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.pages.BasePage;
import web.pages.CloseLoad;
import web.pages.CreateLoadPage;
import web.pages.LoginSignUPPage;
import web.testdata.CreateLoad;
import web.testdata.LoginSignUP;

public class CreateLoadTest extends BaseTest {

	public LoginSignUPPage login;
	public CreateLoadPage load;
	public CloseLoad closeLoad;
	public SoftAssert softAssert;
	public BasePage basePage;



	@BeforeClass
	public void setup() {
		driver.set(driverFactory.initialize());
		login = new LoginSignUPPage(driver.get());
		login.navigateToURL(URL);
		login.userLoginn(LoginSignUP.EMAIL, LoginSignUP.PASSWORD);
		softAssert = new SoftAssert();
		load = new CreateLoadPage(driver.get());
		closeLoad = new CloseLoad(driver.get());
		basePage= new BasePage(driver.get());		

	}

	@Test( priority = 1, enabled = true)
	public void VerifyiClientIsAbleToCreateMyLoad() throws Exception {
		load.MyLoad(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY, CreateLoad.PICKUP_POSTAL_CODE,
				CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY,
				CreateLoad.TRUCK_QUANTITY);
		
		softAssert.assertEquals(basePage.getTostMessage(), "Load added Successfully", "Message do not match" );
		softAssert.assertAll();

	}

	@Test( priority = 2, enabled = true)
	public void VerifyClientIsAbleToCreateLoadOfNewCustomer() throws Exception {
		load.CustomerInfo(CreateLoad.COMPANY_NAME, CreateLoad.CONTACT_PERSON_NAME, CreateLoad.BUILDING_NUMBER,
				CreateLoad.STREET_NAME, CreateLoad.CITY, CreateLoad.POSTAL_CODE, CreateLoad.CUSTOMER_CELLPHONE_NO,
				CreateLoad.OFFICE_NO, CreateLoad.EMAIL);

		load.CustomerLoadInfo(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY, CreateLoad.PICKUP_POSTAL_CODE,
				CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY);

		load.CustomerOrderInfo(CreateLoad.AGREED_RATE, CreateLoad.TRUCK_QUANTITY, CreateLoad.PO_NUMBER,
				CreateLoad.CUSTOMER_CELLPHONE_NO);
		
		softAssert.assertEquals(basePage.getTostMessage(), "Load added Successfully", "Message do not match" );
		softAssert.assertAll();
	}

	@Test( priority = 3, enabled = true)
	public void CreateLoadOfExistingCustomer() throws Exception {
		load.createLoadByDropdown(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME,
				CreateLoad.DUMP_POSTAL_CODE, CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER,
				CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);

		load.CustomerOrderInfo(CreateLoad.AGREED_RATE, CreateLoad.TRUCK_QUANTITY, CreateLoad.PO_NUMBER,
				CreateLoad.CUSTOMER_CELLPHONE_NO);

		softAssert.assertEquals(basePage.getTostMessage(), "Load added Successfully", "Message do not match" );
		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void VerifyiClientIsAbleToAssignCustomerLoadToDriver() throws Exception {
		load.createLoadByDropdown(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME,
				CreateLoad.DUMP_POSTAL_CODE, CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER,
				CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);

		load.CustomerOrderInfo(CreateLoad.AGREED_RATE, CreateLoad.TRUCK_QUANTITY, CreateLoad.PO_NUMBER,
				CreateLoad.CUSTOMER_CELLPHONE_NO);

		load.dispatchBoard(CreateLoad.REMARKS);
	}

	
	@Test( priority = 5, enabled = true)
	public void VerifyiClientIsAbleToAssignCustomerLoadToVendor() throws Exception {
		load.createLoadByDropdown(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME,
				CreateLoad.DUMP_POSTAL_CODE, CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER,
				CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);

		load.CustomerOrderInfo(CreateLoad.AGREED_RATE, CreateLoad.TRUCK_QUANTITY, CreateLoad.PO_NUMBER,
				CreateLoad.CUSTOMER_CELLPHONE_NO);

		// load.dispatchBoard(CreateLoad.REMARKS);

		load.assignLoadToVendor(CreateLoad.PICKUP_STREET_NAME,CreateLoad.AGREED_RATE);

	}

	@Test( priority = 6, enabled = true)
	public void VerifyiClientIsAbleToAssignCustomerLoadToBoth() throws Exception {
		load.createLoadByDropdown(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY,
				CreateLoad.PICKUP_POSTAL_CODE, CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME,
				CreateLoad.DUMP_POSTAL_CODE, CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER,
				CreateLoad.DUMP_CITY, CreateLoad.TRUCK_QUANTITY);

		load.CustomerOrderInfo(CreateLoad.AGREED_RATE, CreateLoad.TRUCK_QUANTITY, CreateLoad.PO_NUMBER,
				CreateLoad.CUSTOMER_CELLPHONE_NO);

		load.assignLoadToBoth(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);

	}

	@Test( priority = 7, enabled = true)
	public void VerifyiClientIsAbleToAssignMyLoadToDriver() throws Exception {
		load.MyLoad(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY, CreateLoad.PICKUP_POSTAL_CODE,
				CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY,
				CreateLoad.TRUCK_QUANTITY);

		load.dispatchBoard(CreateLoad.REMARKS);

	}

	@Test( priority = 8, enabled = true)
	public void VerifyiClientIsAbleToAssignMyLoadToVendor() throws Exception {
		load.MyLoad(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY, CreateLoad.PICKUP_POSTAL_CODE,
				CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY,
				CreateLoad.TRUCK_QUANTITY);

		load.assignLoadToVendor(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);

	}
	@Test( priority = 8, enabled = true)
	public void VerifyiClientIsAbleToAssignMyLoadBothCases() throws Exception {
		load.MyLoad(CreateLoad.PICKUP_BUILDING_NUMBER, CreateLoad.PICKUP_CITY, CreateLoad.PICKUP_POSTAL_CODE,
				CreateLoad.PICKUP_STREET_NAME, CreateLoad.DROP_NAME, CreateLoad.DUMP_POSTAL_CODE,
				CreateLoad.DUMP_STREET_NAME, CreateLoad.DUMP_BUILDING_NUMBER, CreateLoad.DUMP_CITY,
				CreateLoad.TRUCK_QUANTITY);

		load.assignLoadToVendor(CreateLoad.PICKUP_STREET_NAME, CreateLoad.AGREED_RATE);

	}
}
