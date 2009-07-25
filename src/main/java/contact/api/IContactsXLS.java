/**
 * 
 */
package contact.api;

/**
 * @author hirian
 * 
 */
public interface IContactsXLS {

	/**
	 * <p>
	 * Write contacts to specified XLS file
	 * </p>
	 * 
	 * @param outputFilename
	 *            - String
	 */
	public void writeContactsToXLS(String outputFilename);
	
}
