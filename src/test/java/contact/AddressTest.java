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
	
	private String addressString1 = "Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl";
	
	private String addressString2 = "Strada Cetatea de Balta 2 Bl.p13, Sc.3, Ap.39 Bucuresti S6";
	
	private String addressString3 = "Strada Morii 3  Targu Bujor Gl";
	private String addressString4 = "Strada Principala   Tatarca Gl";	
	
	public void setUp() {
		address1 = new Address(addressString1);
		address2 = new Address(addressString2);
		address3 = new Address(addressString3);
		address4 = new Address(addressString4);
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
}
