package orodja;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Oro {

	public static String izpisiDatum(Calendar c) {
		if (c == null)
			return "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(c.getTime());
		
	}
}
