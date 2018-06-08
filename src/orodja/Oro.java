package orodja;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Oro {
	
	public static String izpisiDatum(Calendar c) {
		if (c == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(c.getTime()) + " " +ura(c);
		
	}
	public static String izpisiSamoDatum(Calendar c) {
		if (c == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(c.getTime());
		
	}
	public static String ura(Calendar c) {
//		String ura ="";
//		String min="";
//		
//		ura += c.get(Calendar.HOUR_OF_DAY);
//		min += c.get(Calendar.MINUTE);
//		
//		if (ura.length()==1)
//			ura="0"+ura;
//		if(min.length()==1)
//			min="0"+min;
//		
//		return ura + ":"+ min;
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		return format.format(c.getTime());
				
		
	}
	
	public static String mesec(int st) {
		
		switch (st) {
		case 1:
			return "Januar";
		case 2:
			return "Februar";
		case 3:
			return "Marec";
		case 4:
			return "April";
		case 5:
			return "Maj";
		case 6:
			return "Junij";
		case 7:
			return "Julij";
		case 8:
			return "Avgust";
		case 9:
			return "September";
		case 10:
			return "Oktober";
		case 11:
			return "November";
		case 12:
			return "December";
			

		default:
			return "";
		} 
	
		
		
	}
	public static String meseci() {
		String ret = "'Januar', 'Februar', 'Marec', 'April', 'Maj', 'Junij', 'Julij', 'Avgust', 'September', 'Oktober', 'November', 'December'";
		return ret;
		
		
	}
}
