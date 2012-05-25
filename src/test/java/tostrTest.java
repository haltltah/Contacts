import junit.framework.TestCase;



public class tostrTest extends TestCase {

	byte b1 = 0;
	byte b2 = 0;
	byte b3 = 0;
	byte[] b5 = {0, 0, 0, 0, 0};
	long l1 = 0;
	long l2 = 0;
	int i1 = 0;
	int i2 = 0;
	
	 
	 
	private String tostr() {
		StringBuilder sb = new StringBuilder();
		sb.append(b1);
		sb.append(b2);
		sb.append(l1);
		sb.append(l2);
		sb.append(i1);
		sb.append(i2);
		sb.append(b3);
		sb.append(b5);
		return sb.toString();
		
	}
	public void testtostr() {
		String s1;
		String s2;
		String s3;
		s1 = tostr();
		System.out.println("S1 " + s1);
		s2 = tostr();
		System.out.println("S2 " + s2);
		s3 = tostr();
		System.out.println("S3 " + s3);
		assertEquals(s1.length(), s2.length());
		assertEquals(s2.length(), s3.length());
		assertEquals(s1.length(), s3.length());
	
	}
}
