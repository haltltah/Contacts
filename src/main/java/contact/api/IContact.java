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
	 * Set the value for phone number field for a contact
	 * </p>
	 * 
	 * @param phoneNb
	 *            - String
	 */
	public void setPhoneNb(String phoneNb);

	/**
	 * <p>
	 * Return the phone number of a Contact
	 * </p>
	 * 
	 * @return phoneNb - String
	 */
	public String getPhoneNb();

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
