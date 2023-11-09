package test.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.domain.Address;

public class AddressTest {
	
	Address ZaraIoannina;
	
	@Before
	public void setUp() {
		ZaraIoannina = new Address("Greece", "Ioannina",
				"Char. Trikoupi", 28);
	}

	@Test
	public void testAddress() {
		assertNotNull("Address Constructor is not functional",ZaraIoannina);
		assertEquals(ZaraIoannina.getCountry(), "Greece");
		assertEquals(ZaraIoannina.getCity(), "Ioannina");
		assertEquals(ZaraIoannina.getStreet(), "Char. Trikoupi");
		assertEquals(ZaraIoannina.getStreetNumber(), 28);
	}
}
