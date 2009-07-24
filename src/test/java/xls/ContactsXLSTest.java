/**
 * 
 */
package xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	
	private String inputFilename = "Test.txt";
	private String outputFilename = "Contacts.xls";
	private IContactsXLS contactsXLS;
	private Workbook wb;
	
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
		assertEquals(ColumnsHeader.PhoneNumber.toString(), sheet.getRow(0).getCell(ColumnsHeader.PhoneNumber.getColumn()).toString());
		assertEquals(ColumnsHeader.Name.toString(), sheet.getRow(0).getCell(ColumnsHeader.Name.getColumn()).toString());
		assertEquals(ColumnsHeader.Address.toString(), sheet.getRow(0).getCell(ColumnsHeader.Address.getColumn()).toString());
		assertEquals(ColumnsHeader.CNP.toString(), sheet.getRow(0).getCell(ColumnsHeader.CNP.getColumn()).toString());
	}
	
}
