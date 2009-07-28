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
	 * Set sector attribute
	 * </p>
	 * 
	 * @param sector
	 *            - String
	 */
	public void setSector(String sector);

	/**
	 * <p>
	 * Return street attribute
	 * </p>
	 * 
	 * @return Street - String
	 */
	public String getStreet();

	/**
	 * <p>
	 * Return city attribute
	 * </p>
	 * 
	 * @return City - String
	 */
	public String getCity();

	/**
	 * <p>
	 * Return county attribute
	 * </p>
	 * 
	 * @return county - String
	 */
	public String getCounty();

	/**
	 * <p>
	 * Return sector attribute
	 * </p>
	 * 
	 * @return sector - String
	 */
	public String getSector();

}
