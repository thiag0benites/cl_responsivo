package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import entidades.Globais;
import support.DriverQAM;
import support.Hooks;

public class HomePage {
	
	private Scenario cenario;
	private DriverQAM driver;
	
	//banner
	private String xpathLinkFecharBanner = "//*[@class=\"closeModal gtm-link-event\"]";
	
	// Localizacao
	private String xpathLinkLocalizacao = "//div[@class=\"yCmsContentSlot nav-locationCont\"]/div/a";
	private String xpathSpanLocalizacaoCidade = "//div[@class=\"yCmsContentSlot nav-locationCont\"]/div/a/span[@class=\"storefinderLocationComponent\"]";
	private String xpathSpanLocalizacaoEstado = "//div[@class=\"yCmsContentSlot nav-locationCont\"]/div/a/span[@class=\"storefinderLocationComponentState\"]";
	private String idCboEstado = "address.region";
	private String idTxtCidade = "addressTownCity";
	private String idBtnEntrarLocal = "btnsendcookie";
	
	// Planos
	private String classDivContainerPlanosControle = "carousel-controle";
	private String classDivContainerPlanosPos = "carousel-pos";
	private String classDivCardPlano = "card-planos";
	private String classDivContainerPaginacao = "swiper-pagination";
	private String classSpanPaginador = "swiper-pagination-bullet";
	private String labelLink = "Mais detalhes";
	
	// tela Detalhes
	private String xpathBtnEuQuero = "(//button[@class=\"button button-primary gtm-link-event\"])[position()=2";
	
	public HomePage(DriverQAM driver) {
		this.driver = driver;
		this.cenario = Hooks.getCenario();
	}
	
	public void preencheLocalizacao(String estado, String cidade) {
		
		if (driver.waitElementTimeOut(xpathLinkFecharBanner, "xpath", 30)) {
			driver.click(xpathLinkFecharBanner, "xpath");
		}
		
		driver.click(xpathLinkLocalizacao, "xpath");
		driver.waitElement(idCboEstado, "id");
		driver.selectByText(estado.toUpperCase(), idCboEstado, "id");
		driver.clear(idTxtCidade, "id");
		driver.waitSeconds(2);
//		driver.sendKeys(cidade.toUpperCase(), idTxtCidade, "id");
		driver.sendKeysTab(cidade.toUpperCase(), idTxtCidade, "id");
		driver.click(idBtnEntrarLocal, "id");
		
		driver.waitSeconds(3);
		
		if(driver.waitElementTimeOut(xpathLinkLocalizacao, "id", 3)) {
			driver.report(cenario, false, "Falha ao tentar selecionar a localização", true);
		} else {
			String cidadeAtual = driver.getText(xpathSpanLocalizacaoCidade, "xpath").toUpperCase();
			String estadoAtual = driver.getText(xpathSpanLocalizacaoEstado, "xpath").toUpperCase();
			
			if (!cidade.toUpperCase().contentEquals(cidadeAtual)) {
				driver.report(cenario, false, "A cidade não foi alterada para " + cidade.toUpperCase(), true);
			}
			
			if (!estado.toUpperCase().contentEquals(estadoAtual)) {
				driver.report(cenario, false, "O estado não foi alterado para " + estado.toUpperCase(), true);
			}
			
			driver.report(cenario, true, "Localização selecionada com sucesso", true);
		}
		
	}
//	
//	public void selecionaPlano(String nome, String tipo, String preco) {
//		
//		Globais.setNomePlano(nome);
//		Globais.setPrecoPlano(preco);
//		List<WebElement> planos = null;
//		WebElement paginacao = null;
//		
//		boolean achouPlano = false;
//		tipo = tipo.toUpperCase();
//
//		if (tipo.equals("CONTROLE")) {
////			driver.moveToElement(classDivContainerPlanosControle, "class");
////			planos = driver.findListElements(classDivContainerPlanosControle, "class");
//			
//		} else if (tipo.equals("PÓS-PAGO") || tipo.equals("POS-PAGO")) {
////			driver.moveToElement(classDivContainerPlanosPos, "class");
////			planos = driver.findListElements(classDivContainerPlanosPos, "class");
//		}
//		
////		driver.browserScroll("down", 50);
//		paginacao = planos.get(0).findElement(By.className(classDivContainerPaginacao));
//		List<WebElement> cardsPlano = planos.get(0).findElements(By.className(classDivCardPlano));
//		
//		int pagina = 0;
//		
//		for (WebElement cardPlano : cardsPlano) {	
//			
//			if(cardPlano.getText().equals("")) {
////			if(cont % 2 == 0) {
//				pagina++;
//				paginacao.findElements(By.className(classSpanPaginador)).get(pagina).click();
//				cardsPlano = planos.get(0).findElements(By.className(classDivCardPlano));
//				driver.waitSeconds(1);
//			}
//			
//			String tituloPlano = cardPlano.findElement(By.className("titulo-produto")).getText().toUpperCase();
//			
//			if (tituloPlano.equals(nome.toUpperCase())) {
//				//List<WebElement> botoes = cardPlano.findElements(By.tagName("button"));
//				List<WebElement> links = cardPlano.findElements(By.tagName("a"));
//				
//				for (WebElement link : links) {
//					if(link.getText().toUpperCase().equals(labelLink.toUpperCase())) {
//						
//						try {
//							link.click();
//						} catch (Exception e) { // Caso a imagem do whattsapp fique em cima do link Mais detalhes
//							driver.waitSeconds(1);
//							pagina++;
//							paginacao.findElements(By.className(classSpanPaginador)).get(pagina).click();
//							driver.waitSeconds(1);
//							link.click();
//						}
//						
//						achouPlano = true;
//						break;
//					}
//				}
//			} 
//			
//			if(achouPlano) break;
//		}
//		
//		if (achouPlano) {
////			driver.waitElement(xpathBtnEuQuero, "xpath");
//			driver.report(cenario, true, "Mais detalhes do plano " + tipo + " - " + nome + " selecionado com sucesso" , true);
//
//		} else {
//			driver.report(cenario, false, "Mais detalhes do plano " + tipo + " - " + nome + " não foi encontrado", true);
//		}
//	
}

