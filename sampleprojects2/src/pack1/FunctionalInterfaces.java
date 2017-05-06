package pack1;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class FunctionalInterfaces {
		String id;
//		 String changeToString(int i){
//			return String.valueOf(i);
//		}
	
	public static void main(String[] args){
		
		Converter c = (f) -> Integer.valueOf((String) f);
		
		System.out.println(c.convert("23"));
		
		Converter k = (f) -> f.toString().charAt(0);
		
		System.out.println(k.convert("Arun"));
		FunctionalInterfaces f = new FunctionalInterfaces();
		
//		Converter p = f::changeToString;
//		Converter p = Integer::valueOf;
//		System.out.println();
		
		Clock c1 = Clock.systemDefaultZone();
		System.out.println(c1 + "" +c1.millis());
		
		Instant i1 = c1.instant();
		java.util.Date d = Date.from(i1);
		
		ZoneId z1 = ZoneId.of("Europe/Berlin");
		System.out.println(z1 + "" +z1.getRules());
		
		ZoneId z2 = ZoneId.of("America/New_York");
//		System.out.println(z2);
		LocalTime l1 = LocalTime.now(z1);
		LocalTime l2 = LocalTime.now(z2);
		
		System.out.println(l1);
		long hrsDiff = ChronoUnit.HOURS.between(l1, l2);
		System.out.println(hrsDiff);
		
		
		
	}
}
