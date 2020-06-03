package steps;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.DetalhesPlanoPage;
import support.Hooks;

public class DetalhesPlanoSteps {

	DetalhesPlanoPage detalhes = new DetalhesPlanoPage(Hooks.getDriver());

	@Quando("^escolher forma de pagamento \"([^\"]*)\"$")
	public void EscolherFormaDePagamento(String formaPagamento) {
		detalhes.escolhePagamento(formaPagamento);
	}

	@Entao("^validar as promoções e aplicativos$")
	public void validarAsPromoçõesEAplicativos() {
		detalhes.obtemTamanhoListaBeneficios();
	}

	@Quando("^seleciona a fidelizacao \"([^\"]*)\"$")
	public void selecionaAFidelizacao(String fidelizacao) {
		detalhes.selecionaFidelizacao(fidelizacao);
	}

	@Entao("^Validar que as promoções e aplicativos foram alterados$")
	public void validarQueAsPromoçõesEAplicativosForamAlterados() {
		detalhes.validaAlteracaoListaBeneficios();
	}
}
