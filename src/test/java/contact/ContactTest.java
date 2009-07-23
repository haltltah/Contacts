/**
 * 
 */
package contact;


import contact.api.IContact;
import junit.framework.TestCase;


/**
 * @author hirian
 *
 */
public class ContactTest extends TestCase {
	
	IContact contactTestCreate;
	
	@Override
	public void setUp() {
		contactTestCreate = new Contact("0236418670#GRIGORE GEANINA#Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl#2740412370036 ");
	}
}
