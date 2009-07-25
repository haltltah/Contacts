/**
 * 
 */
package txtparser;

import java.io.FileNotFoundException;
import java.util.List;

import junit.framework.TestCase;

import contact.api.ICollectContacts;
import contact.api.IContact;

/**
 * @author hirian
 * 
 */
public class CollectContactsTest extends TestCase {

	private ICollectContacts collectContacts;
	List<IContact> contacts;
	private String filename = "cornel.txt";

	public void setUp() throws FileNotFoundException {
		collectContacts = new CollectContacts(filename);
		contacts = collectContacts.getGeneratedContacts();
	}

	/**
	 * <p>
	 * Test the collection of contacts from an txt file
	 * </p>
	 */
	public void testGeneratedContacts() {
		IContact contact1 = contacts.get(0);

		assertEquals("0236418670", contact1.getPhoneNb());
		assertEquals("GRIGORE GEANINA", contact1.getName());
		assertEquals("Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl", contact1
				.getAddress());
		assertEquals("2740412370036", contact1.getCNP());

		IContact contact2 = contacts.get(1);

		assertEquals("0236301316", contact2.getPhoneNb());
		assertEquals("SPITALUL JUDETEAN SFANTUL APOSTOL ANDREI", contact2
				.getName());
		assertEquals("Strada Brailei 177  Galati Gl", contact2.getAddress());
		assertEquals("", contact2.getCNP());

	}

}
