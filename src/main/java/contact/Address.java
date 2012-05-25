package contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contact.api.IAddress;

public class Address implements IAddress {


	private String street;
	private String city;
	private String county;
	private String sector;
	final static private String CAPITALA = "Bucuresti"; 
	
	public Address(String address) {
		List<String> addressDetails = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			addressDetails.add("");
		}
		processAddress(addressDetails, address);
		System.out.println("addressDetails.get(0):  " + addressDetails.get(0));
		System.out.println("addressDetails.get(1):  " + addressDetails.get(1));
		if (addressDetails.get(1).equals("")) {
			setStreet("");
			setCity(addressDetails.get(0));
			System.out.println("Empty - street: addressDetails.get(0):  " + addressDetails.get(0));
			System.out.println("Empty - street: addressDetails.get(1): " + addressDetails.get(1));
		}
		else {
			setStreet(addressDetails.get(0));
			setCity(addressDetails.get(1));
		}
		setCounty(addressDetails.get(2));
		setSector(addressDetails.get(3));
	}
	
	private void processAddress(List<String> addressDetails, String address) {
		String delimiter = " ";
		String lastSubstring = getLastSubstring(address, delimiter);
		System.out.println("lastSubstring: " + lastSubstring);
		
		int indexToBeRemoved = address.lastIndexOf(lastSubstring);
		System.out.println("indexToBeRemoved: " + indexToBeRemoved);
		String addressWithoutLast = address.substring(0, indexToBeRemoved - 1);
		System.out.println("addressWithoutLast: " + addressWithoutLast);
		
		
		if ((lastSubstring.length() == 2) && (lastSubstring.charAt(0) == 'S') && lastSubstring.charAt(1) != 'v') {
			processAddressBucuresti(addressDetails, addressWithoutLast, lastSubstring);
		} else {
			addressDetails.set(2, lastSubstring);
			if (address.contains("  ")) {
				processAddressWithNotFullStreet(addressDetails, addressWithoutLast, lastSubstring);
			} else {
				processAddressWithFullData(addressDetails, addressWithoutLast, lastSubstring);
			}
		}
		
	}

	private void processAddressWithFullData(List<String> addressDetails,
			String address, String countyString) {
		String delimiter = ", ";	
		String[] tempPartialStreetList = address.split(delimiter);
		String tempPartialStreet = "";
		for (int i = 0; i < tempPartialStreetList.length - 1; i++) {
			tempPartialStreet = tempPartialStreet + tempPartialStreetList[i] + delimiter;
		}
	
		String lastPartStreet = tempPartialStreetList[tempPartialStreetList.length - 1];
		
		Scanner scannerAddress = new Scanner(lastPartStreet);
		scannerAddress.useDelimiter(" ");
		String tempAp = scannerAddress.next();
		tempPartialStreet = tempPartialStreet  + tempAp;
		addressDetails.set(0, tempPartialStreet);
		addressDetails.set(1, address.substring(tempPartialStreet.length()).trim());
		
	}

	private void processAddressWithNotFullStreet(List<String> addressDetails,
			String address, String countyString) {
		Scanner scannerAddress = new Scanner(address);
		scannerAddress.useDelimiter("  ");
		String streetTemp = scannerAddress.next();
		String streetTemp2 = scannerAddress.next();
		if (streetTemp2.contains(", ")) {
			String delimiter = ", ";	
			String[] tempPartialStreetList = streetTemp2.split(delimiter);
			//String tempPartialStreet = "";
			streetTemp = streetTemp + " ";
			for (int i = 0; i < tempPartialStreetList.length - 1; i++) {
				streetTemp = streetTemp + tempPartialStreetList[i] + delimiter;
			}
		
			String lastPartStreet = tempPartialStreetList[tempPartialStreetList.length - 1];
			Scanner scannerAddress2 = new Scanner(lastPartStreet);
			scannerAddress2.useDelimiter(" ");
			String tempAp = scannerAddress2.next();
			streetTemp = streetTemp  + tempAp;
			streetTemp2 = address.substring(streetTemp.length() + 1).trim();
		}
		addressDetails.set(0, streetTemp);
		addressDetails.set(1, streetTemp2.trim());

	}

	private void processAddressBucuresti(List<String> addressDetails,
			String address, String sectorString) {
		addressDetails.set(1, CAPITALA);
		addressDetails.set(3, sectorString);
		int indexToBeRemoved = address.lastIndexOf(CAPITALA);
		addressDetails.set(0, address.substring(0, indexToBeRemoved - 1));
	}
	
	private String getLastSubstring(String address, String delimiter) {
		String[] addressSplited =  address.split(delimiter);
		return addressSplited[addressSplited.length - 1];
	}

	public String getCity() {
		return city;
	}

	public String getCounty() {
		return county;
	}

	public String getSector() {
		return sector;
	}

	public String getStreet() {
		return street;
	}

	public void setCity(String city) {
		this.city = city;
		
	}

	public void setCounty(String county) {
		this.county = county;
		
	}

	public void setSector(String sector) {
		this.sector = sector;
		
	}

	public void setStreet(String street) {
		this.street = street;
		
	}

}
