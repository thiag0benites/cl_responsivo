package entidades;

public class Globais {
	
	private static String ambienteSite;
	private static String ambienteBackoffice;
	private static String nomePlano;
	private static String precoPlano;
	private static String dataHoraCarrinho;
	
	public static String getDataHoraCarrinho() {
		return dataHoraCarrinho;
	}

	public static void setDataHoraCarrinho(String dataHoraCarrinho) {
		Globais.dataHoraCarrinho = dataHoraCarrinho;
	}
	
	public static String getAmbienteBackoffice() {
		return ambienteBackoffice;
	}

	public static void setAmbienteBackoffice(String ambienteBackoffice) {
		Globais.ambienteBackoffice = ambienteBackoffice;
	}
	
	public static String getAmbienteSite() {
		return ambienteSite;
	}

	public static void setAmbienteSite(String ambienteSite) {
		Globais.ambienteSite = ambienteSite;
	}
	
	public static String getNomePlano() {
		return nomePlano;
	}

	public static void setNomePlano(String nomePlano) {
		Globais.nomePlano = nomePlano;
	}

	public static String getPrecoPlano() {
		return precoPlano;
	}

	public static void setPrecoPlano(String precoPlano) {
		Globais.precoPlano = precoPlano;
	}

}
