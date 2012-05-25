/**
 * 
 */
package xls;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import txtparser.CollectContacts;
import contact.api.ICollectContacts;
import contact.api.IContact;
import contact.api.IContactsXLS;

/**
 * @author hirian
 * 
 */
public class ContactsXLS implements IContactsXLS {

	private ICollectContacts collectContacts;
	private List<IContact> contacts = new ArrayList<IContact>();
	final private String sheetName = "Contacts";

	private Workbook wb;
	private FileOutputStream fileOut;

	public enum ColumnsHeader {
		PhoneNumber(0), Name(1), Street(2), City(3), County(4), Sector(5), CNP(6);
		private int column;

		ColumnsHeader(int column) {
			this.column = column;
		}

		final int getColumn() {
			return column;
		}
	};

	public ContactsXLS(String inputFilename, String outputFilename)
			throws FileNotFoundException {
		collectContacts = new CollectContacts(inputFilename);
		contacts = collectContacts.getGeneratedContacts();
	//	System.out.println("Number of contacts in file: "+ contacts.size());
		wb = new HSSFWorkbook();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContactsXLS#writeContactsToXLS(java.lang.String,
	 * java.lang.String)
	 */
	public void writeContactsToXLS(String outputFilename) {
		try {
			writeHeader(outputFilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		for (IContact contact : contacts) {
			try {
				writeContact(outputFilename, contact);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fileOut = new FileOutputStream(outputFilename);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wb.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOut.close();
			System.out.println("File closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeContact(String outputFilename, IContact contact) throws FileNotFoundException {
		Sheet sheet = wb.getSheet(sheetName);
		int nextRow = sheet.getLastRowNum() + 1;
		Row row = sheet.createRow(nextRow);
		Cell cell = row.createCell(ColumnsHeader.PhoneNumber.getColumn());
		cell.setCellValue(contact.getPhoneNb());
		cell = row.createCell(ColumnsHeader.Name.getColumn());
		cell.setCellValue(contact.getName());
		cell = row.createCell(ColumnsHeader.Street.getColumn());
		cell.setCellValue(contact.getStreet());
		cell = row.createCell(ColumnsHeader.City.getColumn());
		cell.setCellValue(contact.getCity());
		cell = row.createCell(ColumnsHeader.County.getColumn());
		cell.setCellValue(contact.getCounty());
		cell = row.createCell(ColumnsHeader.Sector.getColumn());
		cell.setCellValue(contact.getSector());
		cell = row.createCell(ColumnsHeader.CNP.getColumn());
		cell.setCellValue(contact.getCNP());
	}

	/**
	 * <p>
	 * Write header for xls file
	 * </p>
	 * 
	 * @param outputFilename
	 *            - String
	 * @throws FileNotFoundException
	 */
	private void writeHeader(String outputFilename)
			throws FileNotFoundException {
		Sheet sheet = wb.createSheet(sheetName);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(ColumnsHeader.PhoneNumber.getColumn());
		cell.setCellValue(ColumnsHeader.PhoneNumber.toString());
		cell = row.createCell(ColumnsHeader.Name.getColumn());
		cell.setCellValue(ColumnsHeader.Name.toString());
		cell = row.createCell(ColumnsHeader.Street.getColumn());
		cell.setCellValue(ColumnsHeader.Street.toString());
		cell = row.createCell(ColumnsHeader.City.getColumn());
		cell.setCellValue(ColumnsHeader.City.toString());
		cell = row.createCell(ColumnsHeader.County.getColumn());
		cell.setCellValue(ColumnsHeader.County.toString());
		cell = row.createCell(ColumnsHeader.Sector.getColumn());
		cell.setCellValue(ColumnsHeader.Sector.toString());
		cell = row.createCell(ColumnsHeader.CNP.getColumn());
		cell.setCellValue(ColumnsHeader.CNP.toString());

		fileOut = new FileOutputStream(outputFilename);
		try {
			wb.write(fileOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
