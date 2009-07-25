/**
 * 
 */
package xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import xls.ContactsXLS.ColumnsHeader;

import contact.api.IContactsXLS;
import junit.framework.TestCase;


/**
 * @author hirian
 *
 */
public class ContactsXLSTest extends TestCase {
	
	private String inputFilename = "test.txt";
	private String outputFilename = "Contacts.xls";
	private IContactsXLS contactsXLS;
	private Workbook wb;
	
	final private String phoneNb1 = "0236418670";
	final private String name1 = "GRIGORE GEANINA";
	final private String address1 = "Strada Barbosi 49 Bl.D4, Sc.3, Ap.42 Galati Gl";
	final private String cnp1 = "2740412370036";
	
	public void setUp() {
		wb  = new HSSFWorkbook();
		try {
			contactsXLS = new ContactsXLS(inputFilename, outputFilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contactsXLS.writeContactsToXLS(outputFilename);
		
		InputStream inp = null;
		try {
			inp = new FileInputStream(outputFilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testWriteHeader() {
		assertEquals("Contacts", wb.getSheetName(0));
		
		Sheet sheet = wb.getSheetAt(0);
		assertEquals(ColumnsHeader.PhoneNumber.toString(), sheet.getRow(0).getCell(ColumnsHeader.PhoneNumber.getColumn()).getStringCellValue());
		assertEquals(ColumnsHeader.Name.toString(), sheet.getRow(0).getCell(ColumnsHeader.Name.getColumn()).getStringCellValue());
		assertEquals(ColumnsHeader.Address.toString(), sheet.getRow(0).getCell(ColumnsHeader.Address.getColumn()).getStringCellValue());
		assertEquals(ColumnsHeader.CNP.toString(), sheet.getRow(0).getCell(ColumnsHeader.CNP.getColumn()).getStringCellValue());
	}
	
	public void testWriteContact() {
		Sheet sheet = wb.getSheetAt(0);
		Row row1 = sheet.getRow(1);
		assertEquals(phoneNb1, row1.getCell(ColumnsHeader.PhoneNumber.getColumn()).getStringCellValue());
		assertEquals(name1, row1.getCell(ColumnsHeader.Name.getColumn()).getStringCellValue());
		assertEquals(address1, row1.getCell(ColumnsHeader.Address.getColumn()).getStringCellValue());
		assertEquals(cnp1, row1.getCell(ColumnsHeader.CNP.getColumn()).getStringCellValue());
	}
	
}
