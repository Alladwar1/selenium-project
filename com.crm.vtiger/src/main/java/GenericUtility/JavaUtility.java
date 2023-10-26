package GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method generated random number
	 * 
	 * @return
	 */

	public int getRandom() {
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}

	/**
	 * This method generate system date and time
	 * 
	 * @return
	 */
	public String getsysdate() {
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * This Method create modified system date and time
	 * @return
	 */

	public String getModifiedSysDate() {
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String date1 = date[2];
		String month = date[1];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String currentdate = date1 + " " + time + " " + month + " " + year;
		return currentdate;
	}
}
