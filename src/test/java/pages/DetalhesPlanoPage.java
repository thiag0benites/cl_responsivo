package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import entidades.Globais;
import support.DriverQAM;
import support.Hooks;

public class DetalhesPlanoPage {
	
	private Scenario cenario;
	private DriverQAM driver;

	// checkbox formas pagamento
	private String xpathRdoDebito = "//div[@class='product-page-payment-options product-details-payment-mode js-payment-options js-payment-mode']/label[1]";
	private String xpathRdoBoleto = "//div[@class='product-page-payment-options product-details-payment-mode js-payment-options js-payment-mode']/label[2]";
	private String xpathBtnEuQuero = "(//button[@class='button button-primary gtm-link-event'])[position()=2]";

	// Carrinho
	private String classH3NomePlano = "c_nome-plano";
	private String classPValor = "p-valor";

	// Fidelização
	private String xpathDivContainerFidelizacao = "//div[@class=\"product-page-payment-options product-details-payment-loyalty js-payment-options js-loyalty\"]";
	private String xpathH4ContainerFidelizacao = "//div[@class=\"product-page-payment-options product-details-payment-loyalty js-payment-options js-loyalty\"]/h4";
	private String classLabelRdoFidelizacao = "radio";

	// Beneficios Apps e Serviços 
	private String xpathtest = "//div[@id=\"product-page-description\"]/div[@class=\"container-tablet\"]/button";
	private String xpathBeneficiosApps ="//button[@class=\"button button-collapse button-block is-open\"]";
	private String xpathContainerApps = "//div[@class=\"component-apps-ilimitados apps-ilimitados\"]";
	private String xpathContainerServicos = "//div[@class=\"component-apps-ilimitados claro-services\"]";

	private int tamanhoListaApps;
	private int tamanhoListaServicos;

	public DetalhesPlanoPage(DriverQAM driver) {
		this.driver = driver;
		this.cenario = Hooks.getCenario();
	}

	public void escolhePagamento(String formaPagamento) {

		switch (formaPagamento) {
		case "Débito em conta + fatura digital":
			driver.click(xpathRdoDebito, "xpath");
			break;

		case "Boleto bancário":
			driver.click(xpathRdoBoleto, "xpath");
			driver.waitSeconds(1);

			if (Globais.getAmbienteSite().contains("d1")) {
				Globais.setPrecoPlano(String.valueOf(Double.parseDouble(Globais.getPrecoPlano().replace(",", ".")) + 10)
						.replace(".", ","));

			} else if (Globais.getAmbienteSite().contains("s1")) {
				Globais.setPrecoPlano(String.valueOf(Double.parseDouble(Globais.getPrecoPlano().replace(",", ".")) + 10)
						.replace(".", ","));
			}

		}

		driver.click(xpathBtnEuQuero, "xpath");
		driver.waitElement(classH3NomePlano, "class");

		String planoAtual = driver.getText(classH3NomePlano, "class");
		String nome = Globais.getNomePlano();
		String preco = Globais.getPrecoPlano();

		if (planoAtual.equals(nome)) {
			String valorAtual = driver.getText(classPValor, "class");

			if (!valorAtual.equals(preco)) {
				driver.report(cenario, false, "O preço do plano " + nome + " não esta correto\nValor Correto: " + preco
						+ "\nValor Apresentado: " + valorAtual, true);
			}

		} else {
			driver.report(cenario, false, "O plano apresentado " + planoAtual + " é diferente do selecionado " + nome,
					true);
		}
	}

	public void selecionaFidelizacao(String fidelizacao) {

		boolean achouRdo = false;
		
		driver.waitSeconds(5);
		driver.moveToElement(xpathRdoDebito, "xpath");
		//driver.browserScroll("down", 400);
		WebElement containerFidelizacao = driver.findElem(xpathDivContainerFidelizacao, "xpath");
		List<WebElement> rdos = containerFidelizacao.findElements(By.className(classLabelRdoFidelizacao));

		for (WebElement rdo : rdos) {
			if (rdo.getText().equals(fidelizacao)) {
				rdo.click();
				achouRdo = true;
				break;
			}
		}

		if (achouRdo) {
			driver.report(cenario, true, "A opção foi selecionada " + fidelizacao, true);
		} else {
			driver.report(cenario, false, "Não foi possível selecionar a opção " + fidelizacao, true);
		}

	}

	public void obtemTamanhoListaBeneficios() {
		driver.click(xpathBeneficiosApps, "xpath");
	//	driver.moveToElement(xpathContainerApps, "xpath");
	
		String[] apps = listaBeneficios(xpathContainerApps, "xpath");

		if (apps != null) {

			tamanhoListaApps = apps.length;

			if (tamanhoListaApps > 0) {
				driver.report(cenario, true, "Lista de apps obtida com sucesso", true);
			} else {
				driver.report(cenario, true, "Lista de apps igual 0", true);
			}

		} else {
			driver.report(cenario, false, "Erro ao tentar obter a lista de apps", true);
		}

//		String[] servicos = listaBeneficios(xpathContainerServicos, "xpath");
//
//		if (servicos != null) {
//
//			tamanhoListaServicos = servicos.length;
//
//			if (tamanhoListaServicos > 0) {
//				driver.report(cenario, true, "Lista de serviços obtida com sucesso", true);
//			} else {
//				driver.report(cenario, true, "Lista de serviços igual 0", true);
//			}
//
//		} else {
//			driver.report(cenario, false, "Erro ao tentar obter a lista de serviços", true);
//		}

	}

	public void validaAlteracaoListaBeneficios() {
		driver.click(xpathtest, "xpath");
		driver.moveToElement(xpathContainerApps, "xpath");
		
		boolean listaAppsAlterada = false;
//		boolean listaServicosAlterada = false;

		int tamanhoListaAppsAtual = listaBeneficios(xpathContainerApps, "xpath").length;
//		int tamanhoListaServicosAtual = listaBeneficios(xpathContainerServicos, "xpath").length;

		if (tamanhoListaAppsAtual != tamanhoListaApps) 
			listaAppsAlterada = true;
		
//		if (tamanhoListaServicosAtual != tamanhoListaServicos)
//			listaServicosAlterada = true;

		if (listaAppsAlterada) {
			driver.report(cenario, true, "A lista de apps foi alterada com sucesso", true);
		} else {
			driver.report(cenario, false, "As lista de apps não foi alterada", true);
		}
			
			
//		if (listaAppsAlterada && listaServicosAlterada) {
//			driver.report(cenario, true, "A lista de apps e serviços foram alteradas com sucesso", true);
//
//		} else if (!listaAppsAlterada && listaServicosAlterada) {
//			driver.report(cenario, false, "A lista de apps não foi alterada", true);
//
//		} else if (listaAppsAlterada && !listaServicosAlterada) {
//			driver.report(cenario, false, "A lista de serviços não foi alterada", true);
//
//		} else {
//			driver.report(cenario, false, "As lista de apps e serviços não foram alteradas", true);
//		}

	}

	@SuppressWarnings({ "unused", "null" })
	private String[] listaBeneficios(String parName, String parType) {

		String[] arr = null;

		try {

			WebElement container = driver.findListElements(parName, parType).get(0);
			List<WebElement> imgs = container.findElements(By.tagName("img"));
			arr = new String[imgs.size()];

			int cont = 0;

			for (WebElement img : imgs) {
				arr[cont] = img.getAttribute("title");
				cont++;
			}

			return arr;

		} catch (Exception e) {
			return arr;
		}

	}
}
