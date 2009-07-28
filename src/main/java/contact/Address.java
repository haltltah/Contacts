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
	
	public Address(String address) {
		List<String> addressDetails = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			addressDetails.add("");
		}
		processAddress(addressDetails, address);
		setStreet(addressDetails.get(0));
		setCity(addressDetails.get(1));
		setCounty(addressDetails.get(2));
		setSector(addressDetails.get(3));
	}
	
	private void processAddress(List<String> addressDetails, String address) {
		String lastSubstring = getLastSubstring(address);
		if ((lastSubstring.length() == 2) && (lastSubstring.charAt(0) == 'S')) {
			processAddressBucuresti(addressDetails, address);
		} else 
			if (address.contains("  ")) {
				processAddressWithNotFullStreet(addressDetails, address);
			} else {
				processAddressWithFullData(addressDetails, address);
		}
		
	}

	private void processAddressWithFullData(List<String> addressDetails,
			String address) {
		Scanner scannerAddress3 = new Scanner(address);
		scannerAddress3.useDelimiter(",");
		
		List<String> tempPartialStreetList = new ArrayList<String>();
		while (scannerAddress3.hasNext()) {
			 tempPartialStreetList.add(scannerAddress3.next());
		}
		System.out.println(tempPartialStreetList);
		String tempPartialStreet = "";
		for (int i = 0; i < tempPartialStreetList.size() - 1; i++) {
			tempPartialStreet = tempPartialStreet + tempPartialStreetList.get(i) + ",";
		}
	//	tempPartialStreet = tempPartialStreet.substring(0, tempPartialStreet.length() - 2);
		String lastPartAddress = tempPartialStreetList.get(tempPartialStreetList.size() - 1);
		Scanner scannerAddress4 = new Scanner(lastPartAddress);
		scannerAddress4.useDelimiter(" ");
		String tempAp = scannerAddress4.next();
		tempPartialStreet = tempPartialStreet + " " + tempAp;
		addressDetails.set(0, tempPartialStreet);
	//	String street = tempPartialStreet + ", " + tempAp;
		System.out.println("full street: " + tempPartialStreet);
		String cityCounty = lastPartAddress.substring(tempAp.length() + 2).trim();
		System.out.println("cityCounty: " + cityCounty);
		Scanner scannerAddress5 = new Scanner(cityCounty);
		String county = "";
		while (scannerAddress5.hasNext()) {
			county = scannerAddress5.next();
		}
		addressDetails.set(2, county);
		System.out.println("county: " + county);
		int indexCounty = cityCounty.lastIndexOf(county);
		String city = cityCounty.substring(0, indexCounty).trim();
		addressDetails.set(1, city);
		System.out.println("city: " + city);
		
		
	}

	private void processAddressWithNotFullStreet(List<String> addressDetails,
			String address) {
		String lastSubstring = getLastSubstring(address);
		Scanner scannerAddress2 = new Scanner(address);
		scannerAddress2.useDelimiter("  ");
		addressDetails.set(0, scannerAddress2.next());
		addressDetails.set(2, lastSubstring);
		int indexBegin = addressDetails.get(0).length();
		int indexEnd = address.lastIndexOf(lastSubstring) - 1;
		String tempCity = address.substring(indexBegin, indexEnd).trim();
		addressDetails.set(1, tempCity);
		
	}

	private void processAddressBucuresti(List<String> addressDetails,
			String address) {
		String sector = null;
		Scanner scannerAddress = new Scanner(address);
		scannerAddress.useDelimiter(" ");
		while (scannerAddress.hasNext()) {
			sector = scannerAddress.next();
		}
		addressDetails.set(1, "Bucuresti");
		addressDetails.set(2, "");
		addressDetails.set(3, sector);
		int indexToBeRemoved = address.lastIndexOf("Bucuresti");
		addressDetails.set(0, address.substring(0, indexToBeRemoved - 1));
	}
	
	private String getLastSubstring(String address) {
		String lastSubstring = null;
		Scanner scannerAddress = new Scanner(address);
		scannerAddress.useDelimiter(" ");
		while (scannerAddress.hasNext()) {
			lastSubstring = scannerAddress.next();
		}
		return lastSubstring;
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
