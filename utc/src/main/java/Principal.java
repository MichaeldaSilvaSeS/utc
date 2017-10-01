

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Principal {
	public static void main(String[] args) throws ParseException {
		Date now  = new Date();
		System.out.println("BRA " +getISO8601StringForDateBrazil(now));
		System.out.println("EUA "+ getISO8601StringForDateUSA(now));
		System.out.println("ALE " +getISO8601StringForDateGerman(now));
		
		System.out.println("============================================");
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"), Locale.US);
		c.add(Calendar.HOUR, -2);
		System.out.println("EUA "+ getISO8601StringForDateUSA(c.getTime()));
		System.out.println("ALE " +getISO8601StringForDateGerman(c.getTime()));
		
		System.out.println(getISO8601StringFor("2017-10-01T12:00:00.000Z"));
	}
	
	private static String getISO8601StringForDateUSA(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		return dateFormat.format(date);
	}
	
	private static String getISO8601StringForDateGerman(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMAN);
		dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
		return dateFormat.format(date);
	}
	
	private static String getISO8601StringForDateBrazil(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.GERMAN);
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
		return dateFormat.format(date);
	}
	
	private static Date getISO8601StringFor(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		return df.parse(date);
	}
}
