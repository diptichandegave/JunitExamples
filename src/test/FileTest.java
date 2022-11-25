package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class FileTest {

	@Test
	public void testFixedMatchingString() {
		 
	        BufferedReader br;
	        String strToPass = "testingss";
	        boolean test_passed = false;
			try {
				br = new BufferedReader(new FileReader("src/Test File Finance.txt"));
				String st;
		        while((st=br.readLine())!=null){
		        	if(st.contains(strToPass)){
		        		test_passed = true;
		        		break;
		        	}
		        }
		        
		        assertTrue(test_passed);
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			} 
	        
	    }
	
	@Test
	public void testPatternMatchingString() {
		 
	        BufferedReader br;
	        /* The Below pattern matches strings
	         * $83.94,yNx.
	         * $687.87,jkGhg.
	         * $987987.56,oieUrT.
	         * */
	        String pattern = "[\"^\\$\\d*.\\d\\d,\\w*\"gm]";
	        Pattern r = Pattern.compile(pattern);
	        boolean test_passed = false;
			try {
				br = new BufferedReader(new FileReader("src/Test File Finance.txt"));
				String st;
		        while((st=br.readLine())!=null){
		        	Matcher m = r.matcher(st);
		        	if(m.find()){
		        		test_passed = true;
		        		break;
		        	}
		        }
		        
		        assertTrue(test_passed);
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			} 
	        
	    }
	
	@Test
	public void testGivenMatchingString() {
		 
	        BufferedReader br;
	        String strToPass = "S a m p l e    C o m p a n y";
	        boolean test_passed = false;
			try {
				br = new BufferedReader(new FileReader("src/Test File Finance.txt"));
				String st;
		        while((st=br.readLine())!=null){
		        	if(st.contains(strToPass)){
		        		test_passed = true;
		        		break;
		        	}
		        }
		        
		        assertTrue(test_passed);
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			} 
	        
	    }

}
