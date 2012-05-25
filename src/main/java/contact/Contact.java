/**
 * 
 */
package contact;

import java.util.List;

import contact.api.IAddress;
import contact.api.IContact;

/**
 * @author hirian
 * 
 */
public class Contact implements IContact {

	private String phoneNb;
	private String name;
	private String addressString;
	private String cnp;
	private IAddress address;
	
	/**
	 * <p>
	 * Create a Contact object from input string
	 * </p>
	 * 
	 * @param roughContact
	 *            - String
	 */
	public Contact(List<String> contactDetails) {
		setPhoneNb(contactDetails.get(0));
		setName(contactDetails.get(1));
		address = new Address(contactDetails.get(2));
		//setAddress(contactDetails.get(2));
		setCNP(contactDetails.get(3));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#getAddress()
	 */
	public String getAddress() {
		return addressString;
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
		return phoneNb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setAddress(java.lang.String)
	 */
	public void setAddress(String addressString) {
		this.addressString = addressString;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setCNP(java.lang.String)
	 */
	public void setCNP(String cnp) {
		this.cnp = cnp;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContact#setPhoneNb(java.lang.String)
	 */
	public void setPhoneNb(String phoneNb) {
		this.phoneNb = phoneNb;

	}

	public String getCity() {
		// TODO Auto-generated method stub
		return address.getCity();
	}

	public String getCounty() {
		// TODO Auto-generated method stub
		return address.getCounty();
	}

	public String getSector() {
		// TODO Auto-generated method stub
		return address.getSector();
	}

	public String getStreet() {
		// TODO Auto-generated method stub
		return address.getStreet();
	}

}
