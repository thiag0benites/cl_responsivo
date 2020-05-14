package support;

import java.util.HashMap;
import java.util.List;

import credentials.URL;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private static DriverQAM driver;
	private static Scenario cenario;
	private static List<HashMap<String,Object>> credenciais;

	@Before
	public void ConfiguracaoInicial(Scenario cenario) {
		Hooks.cenario = cenario;
		URL.setUrl("stage1");
		
//		MassaDadosBD massa = new MassaDadosBD();
//		
//		//Obtem a do banco tabela automacao
//		credenciais = massa.consultaDados(TabelasDadosBD.automacao);
//		System.out.println(credenciais.get(2).get(CamposAutomacaoBD.sistema));
//		
//		//Obtem a do banco tabela massa
//		List<HashMap<String,Object>> massa = MassaDadosBD.consultaDados(TabelasDadosBD.massa);
//		System.out.println(massa.get(2).get(CamposMassaBD.plano));
		
//		String plano = "PRÉ-PAGO";
//		
//		for (int i = 1; i <= 100; i++) {
//			//Inseri massa no banco
//			switch (i) {
//			case 33:
//				plano = "PÓS-PAGO";
//				break;
//			case 66:
//				plano = "CONTROLE";
//				break;
//			}
//			
//			String novaMassa[] = {plano, "24"+ String.valueOf(i), String.valueOf(i) + "5710437658872222", String.valueOf(i) + "2222", generico.dataHoraAtual("dd/MM/yy, HH:mm:ss")};
//			MassaDadosBD.inserirNovaMassaDados(novaMassa);
//		}
		
		//Muda status massa
//		MassaDadosBD.mudaStatusMassaDados("10");
		
		Generico.log("*** Iniciando Teste MOBILE***");
		Generico.log("Executando cenario " + cenario.getName());
    	driver = new DriverQAM(cenario);
        driver.start("ChromeMobile");

	}
    
	@After
	public void FecharJanela() {
		driver.stop();
		Generico.log("*** Fim dos testes MOBILE***");	
	}
	
	public static DriverQAM getDriver() {
		return driver;
	}
	
	public static Scenario getCenario() {
		return cenario;
	}
	
	public static List<HashMap<String,Object>> getCredenciais(){
		return credenciais;
	}
    
//    @After("@printScreenDF")
//    public void testScreenshot(Scenario scenario) throws InterruptedException {
//        driver.setContext("NATIVE_APP");
//        driver.takeScreenshotDF("teste Screenshot");
//        //System.out.println(scenario.getName());
//    }
//
//    @After("@reportScreenshot")
//    public void printScreen(Scenario scenario) throws InterruptedException {
//        Thread.sleep(1000);
//        byte[] screenshot = (((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.BYTES));
//    }
//
//    @After("@fecharApp")
//    public void closeBrowser() {
//        driver.stop();
//    }
//
//    @Before("@fecharAppBefore")
//    public void closeBrowserBefore() {
//        driver.stop();
//    }
}
