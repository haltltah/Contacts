/**
 * 
 */
package contact.api;

/**
 * @author hirian
 * 
 */
public interface IContact {

	/**
	 * <p>
	 * Creates an IContact object
	 * </p>
	 * 
	 * @param roughContact
	 *            - String
	 * @return IContact
	 */
	public IContact createContact(String roughContact);

	/**
	 * <p>
	 * Set the value for id field for a contact
	 * </p>
	 * 
	 * @param id
	 *            - String
	 */
	public void setId(String id);

	/**
	 * <p>
	 * Return the id of a Contact
	 * </p>
	 * 
	 * @return id - String
	 */
	public String getId();

	/**
	 * <p>
	 * Set the value for name field for a contact
	 * </p>
	 * 
	 * @param name
	 *            - String
	 */
	public void setName(String name);

	/**
	 * <p>
	 * Return the name of a Contact
	 * </p>
	 * 
	 * @return name - String
	 */
	public String getName();

	/**
	 * <p>
	 * Set the value for address field for a contact
	 * </p>
	 * 
	 * @param address
	 *            - String
	 */
	public void setAddress(String address);

	/**
	 * <p>
	 * Return the address of a Contact
	 * </p>
	 * 
	 * @return address - String
	 */
	public String getAddress();

	/**
	 * <p>
	 * Set the value for cnp field for a contact
	 * </p>
	 * 
	 * @param cnp
	 *            - String
	 */
	public void setCNP(String cnp);

	/**
	 * <p>
	 * Return the cnp of a Contact
	 * </p>
	 * 
	 * @return cnp - String
	 */
	public String getCNP();
}
