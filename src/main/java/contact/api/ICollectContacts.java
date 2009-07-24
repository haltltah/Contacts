/**
 * 
 */
package contact.api;

import java.util.List;

/**
 * @author hirian
 *
 */
public interface ICollectContacts {

	/**
	 * <p>
	 * Return generatedContacts from txt file
	 * </p>
	 * 
	 * @return generatedContacts
	 */
	public List<IContact> getGeneratedContacts();
}
