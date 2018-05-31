package orodja;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Oro {

	public static String izpisiDatum(Calendar c) {
		if (c == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(c.getTime()) + " " +ura(c);
		
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
}
