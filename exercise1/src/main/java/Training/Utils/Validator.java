/*
	* @author bacng
	* @ Date Jun 16, 2022
*/
package Training.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]" + "+\\.[a-zA-Z]{2,6}$";
	final static String DATE_FORMAT = "dd-MM-yyyy";

	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}

	public static boolean isvalidEmail(String email) {
		Pattern p = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
