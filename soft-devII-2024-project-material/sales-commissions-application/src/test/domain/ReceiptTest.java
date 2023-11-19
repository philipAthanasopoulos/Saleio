package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.*;

public class ReceiptTest {
	
	String expectedReceiptString = 
			"Receipt ID: 152\r\n"
			+ "Date: 11/10/2016\r\n"
			+ "Kind: Shirts\r\n"
			+ "Sales: 6025.0\r\n"
			+ "Items: 400\r\n"
			+ "Company: Granazi\r\n"
			+ "Country: Greece\r\n"
			+ "City: Drama\r\n"
			+ "Street: Papandreou\r\n"
			+ "Number: 46\r\n";

	@Test
	public void testReceiptIntStringProductTypeDoubleIntCompany() {
		Address address = new Address(
				"Greece",
				"Drama",
				"Papandreou",
				46);
		
		Company company = new Company(
				"Granazi",
				address);
		
		Receipt receipt = new Receipt(
				152,
				"11/10/2016",
				ProductType.Shirts,
				6025,
				400,
				company);
		
		assertNotNull("Constructor returned empty receipt.", receipt);
		assertEquals("Print does not match initial input", expectedReceiptString, receipt.toString());
	}

}
