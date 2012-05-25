/**
 * 
 */
package contact;

import contact.api.IAddress;
import junit.framework.TestCase;

/**
 * @author hirian
 *
 */
public class AddressTest extends TestCase {
	
	private IAddress address1;
	private IAddress address2;
	private IAddress address3;
	private IAddress address4;
	private IAddress address5;
	private IAddress address6;
	
	
	private String addressString1 = "Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl";
	
	private String addressString2 = "Strada Cetatea de Balta 2 Bl.p13, Sc.3, Ap.39 Bucuresti S6";
	
	private String addressString3 = "Strada Morii 3  Targu Bujor Gl";
	private String addressString4 = "Strada Principala   Tatarca Gl";
	
	
//	private String addressString5 = "Strada Principala   Tatarca Sv";
	//private String addressString6 = "Strada Principala   Tatarca Sv8";
	
	public void setUp() {
		address1 = new Address(addressString1);
		address2 = new Address(addressString2);
		address3 = new Address(addressString3);
		address4 = new Address(addressString4);
		
	//	address5 = new Address(addressString5);
		//address6 = new Address(addressString6);
	}
	
	public void testProcessAddressWithEmptyStreet() {
		String addressStringWithEmptyStreet = "Ivesti Gl";
		IAddress addressWithEmptyStreet = new Address(addressStringWithEmptyStreet);
		assertEquals("Ivesti", addressWithEmptyStreet.getCity());
		assertEquals("", addressWithEmptyStreet.getStreet());
		assertEquals("Gl", addressWithEmptyStreet.getCounty());
		assertEquals("", addressWithEmptyStreet.getSector());
	}
	
	public void testProcessAddressCombined() {
		String addressStringCombined = "Strada Anghel Saligny  Bl.1B, Ap.97MAN Galati Gl";
		IAddress addressCombined = new Address(addressStringCombined);
		assertEquals("Strada Anghel Saligny Bl.1B, Ap.97MAN", addressCombined.getStreet());
		assertEquals("Galati", addressCombined.getCity());
		assertEquals("Gl", addressCombined.getCounty());
	}

	
	public void testProcessAddressBucuresti() {
		assertEquals("Strada Cetatea de Balta 2 Bl.p13, Sc.3, Ap.39", address2.getStreet());
		assertEquals("Bucuresti", address2.getCity());
		assertEquals("", address2.getCounty());
		assertEquals("S6", address2.getSector());
	}
	
	public void testProcessAddressWithNotFullStreet() {
		assertEquals("Strada Morii 3", address3.getStreet());
		assertEquals("Targu Bujor", address3.getCity());
		assertEquals("Gl", address3.getCounty());
		assertEquals("", address3.getSector());
		
		assertEquals("Strada Principala", address4.getStreet());
		assertEquals("Tatarca", address4.getCity());
		assertEquals("Gl", address4.getCounty());
		assertEquals("", address4.getSector());
	}
	
	public void testProcessAddressWithAllData() {
		assertEquals("Strada Barbosi 49 Bl.D4, Sc.3, Ap.42", address1.getStreet());
		assertEquals("Galati", address1.getCity());
		assertEquals("Gl", address1.getCounty());
		assertEquals("", address1.getSector());
		
	}
	
/*	public void testProcessAddressWithSv() {
		assertEquals("Strada Principala", address5.getStreet());
		assertEquals("Tatarca", address5.getCity());
		assertEquals("Sv", address5.getCounty());
		assertEquals("", address5.getSector());
	}*/
	
	/*public void testProcessAddressWithSv8() {
		assertEquals("Strada Principala", address6.getStreet());
		assertEquals("Tatarca", address6.getCity());
		assertEquals("Sv8", address6.getCounty());
		assertEquals("", address6.getSector());
	}*/
}
