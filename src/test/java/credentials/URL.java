package credentials;

import entidades.Globais;

public class URL {

	public static String urlSite;
	public static String urlBackoffice;
	
	public static void setUrl(String ambiente) {
		String[] urls = setAmbiente(ambiente);
		URL.urlSite = urls[0];
		URL.urlBackoffice = urls[1];
		Globais.setAmbienteSite(URL.urlSite);
		Globais.setAmbienteBackoffice(URL.urlBackoffice);
	}
	
	public static String getUrlSite() {
		return urlSite;
	}

	public static String getUrlBackoffice() {
		return urlBackoffice;
	}
	
    private static String[] setAmbiente(String ambiente) {
		
    	String[] urls = new String[2];
    	
    	switch (ambiente) {
		case "dev1":
			urls[0] = "https://accstorefront.cokecxf-commercec1-d1-public.model-t.cc.commerce.ondemand.com/claro/pt/";
			urls[1] = "https://backoffice.cokecxf-commercec1-d1-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul";
			break;
			
		case "dev2":
			urls[0] = "https://accstorefront.cokecxf-commercec1-d2-public.model-t.cc.commerce.ondemand.com/claro/pt/";
			urls[1] = "https://backoffice.cokecxf-commercec1-d2-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul";
			break;
		
		case "stage1":
			urls[0] = "https://accstorefront.cokecxf-commercec1-s1-public.model-t.cc.commerce.ondemand.com/claro/pt/";
			urls[1] = "https://backoffice.cokecxf-commercec1-s1-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul";
			break;
    	
		case "stage2":
			urls[0] = "https://accstorefront.cokecxf-commercec1-s2-public.model-t.cc.commerce.ondemand.com/claro/pt/";
			urls[1] = "https://backoffice.cokecxf-commercec1-s2-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul";
			break;
		
		case "prod1":
			urls[0] = "https://accstorefront.cokecxf-commercec1-p1-public.model-t.cc.commerce.ondemand.com/claro/pt/";
			urls[1] = "https://backoffice.cokecxf-commercec1-p1-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul";
			break;
    	}
    	
    	return urls;
    	
    }
	
}
