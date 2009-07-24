/**
 * 
 */
package xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

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
	private InputStream inp;
	private FileOutputStream fileOut; //= new FileOutputStream("Contacts.xls");;
	
	public enum ColumnsHeader{PhoneNumber(0), Name(1), Address(2), CNP(3);
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
		wb = new HSSFWorkbook();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contact.api.IContactsXLS#writeContactsToXLS(java.lang.String,
	 * java.lang.String)
	 */
	public void writeContactsToXLS(String outputFilename){
		try {
			writeHeader(outputFilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (IContact contact: contacts) {
			writeContact(contact);
		}
	}

	private void writeContact(IContact contact) {
		// TODO Auto-generated method stub
		
	}

	private void writeHeader(String outputFilename) throws FileNotFoundException {
		Sheet sheet = wb.createSheet(sheetName);
		System.out.println("Sheet Created");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(ColumnsHeader.PhoneNumber.getColumn());
		cell.setCellValue(ColumnsHeader.PhoneNumber.toString());
		cell = row.createCell(ColumnsHeader.Name.getColumn());
		cell.setCellValue(ColumnsHeader.Name.toString());
		cell = row.createCell(ColumnsHeader.Address.getColumn());
		cell.setCellValue(ColumnsHeader.Address.toString());
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
			System.out.println("File closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
