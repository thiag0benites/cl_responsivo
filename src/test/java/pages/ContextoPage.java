package pages;

import credentials.URL;
import cucumber.api.Scenario;
import support.DriverQAM;
import support.DriverQAM_old;
import support.Hooks;

public class ContextoPage {
	
	private Scenario cenario;
	private DriverQAM driver;
	
	private String classModalPromocao = "closeModal";
	private String classSpanLocalizacao = "storefinderLocationComponentState";
	
	public ContextoPage(DriverQAM driverQAM) {
		this.driver = driverQAM;
		this.cenario = Hooks.getCenario();
	}
	
	public void acessarSite() {
		
		driver.openURL(URL.urlSite);
		
		if (driver.waitElementTimeOut(classModalPromocao, "class", 5)) {
			driver.click(classModalPromocao, "class");
		}
		
		//driver.waitElementAll(classSpanLocalizacao, "class");
		driver.report(cenario, true, "Acesso realizado com sucesso", true);
	}

}
