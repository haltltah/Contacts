/**
 * 
 */
package contact;

import contact.api.IContact;

/**
 * @author hirian
 * 
 */
public class Contact implements IContact {

	private String phoneNumber;
	private String name;
	private String address;
	private String cnp;
	
	/**
	 * <p>
	 * Create a Contact object from input string
	 * </p>
	 * 
	 * @param roughContact
	 *            - String
	 */
	public Contact(String roughContact) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#getAddress()
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#getCNP()
	 */
	public String getCNP() {
		return cnp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#getPhoneNb()
	 */
	public String getPhoneNb() {
		return phoneNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setAddress(java.lang.String)
	 */
	public void setAddress(String address) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setCNP(java.lang.String)
	 */
	public void setCNP(String cnp) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setName(java.lang.String)
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setPhoneNb(java.lang.String)
	 */
	public void setPhoneNb(String phoneNb) {
		// TODO Auto-generated method stub

	}

}
