package support;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Generico {
	
	public static String dataHoraAtual(String formato) {
		Locale locale = new Locale("pt","BR");
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat formatador = new SimpleDateFormat(formato, locale);
		return formatador.format(calendar.getTime()).toString();
	}

	public static void log(String msg) {
		System.out.println(dataHoraAtual("dd/MM/yy") + ":" + msg);
	}

}
