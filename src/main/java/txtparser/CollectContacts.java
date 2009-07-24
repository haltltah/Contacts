/**
 * 
 */
package txtparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contact.Contact;
import contact.api.ICollectContacts;
import contact.api.IContact;

/**
 * @author hirian
 * 
 */
public class CollectContacts implements ICollectContacts{

	private FileReader inputFile;
	private List<IContact> generatedContacts = new ArrayList<IContact>();
	List<String> contactDetails;

	/**
	 * <p>
	 * Create a CollectContacts object
	 * </p>
	 * 
	 * @param filename
	 *            - String
	 * @throws FileNotFoundException
	 */
	public CollectContacts(String filename) throws FileNotFoundException {
		generatedContacts = new ArrayList<IContact>();
		inputFile = new FileReader(filename);
		parseTXTFile(inputFile);
	}

	/**
	 * <p>
	 * Parse input file to populate the generatedContacts list
	 * </p>
	 * 
	 * @param inputFile
	 *            - FileReader
	 * @throws IOException
	 */
	private void parseTXTFile(FileReader inputFile) {
		Scanner scannerFile = new Scanner(inputFile);
		try {
			// first use a Scanner to get each line
			while (scannerFile.hasNextLine()) {
				parseLine(scannerFile.nextLine());
				fillContactDetailList(contactDetails);
				IContact contact = new Contact(contactDetails);
				generatedContacts.add(contact);
			}
		} finally {
			// ensure the underlying stream is always closed
			scannerFile.close();
		}

	}

	/**
	 * <p>
	 * Create a IContact object based on input line
	 * </p>
	 * 
	 * @param line
	 *            - String
	 */
	private void parseLine(String line) {
		contactDetails = new ArrayList<String>();
		Scanner scannerLine = new Scanner(line);
		scannerLine.useDelimiter("#");
		while (scannerLine.hasNext()) {
			contactDetails.add(scannerLine.next());
		}
		scannerLine.close();
	}

	/**
	 * <p>
	 * Populates the contact details with empty values for the missing
	 * attributes for a contact
	 * </p>
	 * 
	 * @param contactDetails
	 *            - List<String>
	 */
	private void fillContactDetailList(List<String> contactDetails) {
		while (contactDetails.size() < 4) {
			contactDetails.add("");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.ICollectContacts#getGeneratedContact()
	 */
	public List<IContact> getGeneratedContacts() {
		return generatedContacts;
	}

}
