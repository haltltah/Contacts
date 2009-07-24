/**
 * 
 */
package contact;

import java.util.ArrayList;
import java.util.List;

import contact.api.IContact;
import junit.framework.TestCase;

/**
 * @author hirian
 * 
 */
public class ContactTest extends TestCase {

	IContact contact;
	final private String phoneNb = "0236418670";
	final private String name = "GRIGORE GEANINA";
	final private String address = "Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl";
	final private String cnp = "2740412370036";
	final private List<String> contactDetails = new ArrayList<String>();
	final private String emptyString = "";
	final private List<String> contactDetailsEmpty = new ArrayList<String>();

	public void setUp() {
		contactDetails.add(phoneNb);
		contactDetails.add(name);
		contactDetails.add(address);
		contactDetails.add(cnp);

		contact = new Contact(contactDetails);
	}

	/**
	 * <p>
	 * Test the creation of a IContact object
	 * </p>
	 */
	public void testContact() {
		assertEquals(phoneNb, contact.getPhoneNb());
		assertEquals(name, contact.getName());
		assertEquals(address, contact.getAddress());
		assertEquals(cnp, contact.getCNP());
	}

	/**
	 * <p>
	 * Test the creation of a IContact object with empty values
	 * </p>
	 */
	public void testContactEmptyValues() {
		contactDetailsEmpty.add(emptyString);
		contactDetailsEmpty.add(emptyString);
		contactDetailsEmpty.add(emptyString);
		contactDetailsEmpty.add(emptyString);
		IContact contactEmpty = new Contact(contactDetailsEmpty);
		assertEquals(emptyString, contactEmpty.getPhoneNb());
		assertEquals(emptyString, contactEmpty.getName());
		assertEquals(emptyString, contactEmpty.getAddress());
		assertEquals(emptyString, contactEmpty.getCNP());
	}
}
