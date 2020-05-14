package steps;

import cucumber.api.java.pt.Quando;
import pages.HomePage;
import support.Hooks;

public class HomeSteps {
	
	HomePage migracao = new HomePage(Hooks.getDriver());
	
	@Quando("^selecionar a regionalizacao estado \"([^\"]*)\" e cidade \"([^\"]*)\"$")
	public void selecionarARegionalizacaoEstadoECidade(String estado, String cidade) {
		migracao.preencheLocalizacao(estado, cidade);
	}
	
	@Quando("^clicar em Mais detalhes no plano \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void clicarEmMaisDetalhesNoPlano(String nome, String tipo, String preco) throws Throwable {
		migracao.selecionaPlano(nome, tipo, preco);
	}

}
