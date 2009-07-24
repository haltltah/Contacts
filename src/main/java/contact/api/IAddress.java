/**
 * 
 */
package contact.api;

/**
 * @author hirian
 * 
 */
public interface IAddress {

	/**
	 * <p>
	 * Set street attribute
	 * </p>
	 * 
	 * @param street
	 *            - String
	 */
	public void setStreet(String street);

	/**
	 * <p>
	 * Set street attribute
	 * </p>
	 * 
	 * @param city
	 *            - String
	 */
	public void setCity(String city);

	/**
	 * <p>
	 * Set county attribute
	 * </p>
	 * 
	 * @param county
	 *            - String
	 */
	public void setCounty(String county);

	/**
	 * <p>
	 * Return street attribute
	 * </p>
	 * 
	 * @return
	 */
	public String getStreet();

	/**
	 * <p>
	 * Return city attribute
	 * </p>
	 * 
	 * @return
	 */
	public String getCity();

	/**
	 * <p>
	 * Return county attribute
	 * </p>
	 * 
	 * @return
	 */
	public String getCounty();

}
