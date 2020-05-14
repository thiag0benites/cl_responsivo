package steps;

import cucumber.api.java.pt.Dado;
import pages.ContextoPage;
import support.Hooks;

public class ContextoSteps {
	
	ContextoPage contexto = new ContextoPage(Hooks.getDriver());
	
	@Dado("^que ao acessar o site do ecommerce$")
	public void queAoAcessarOSiteDoEcommerce() {
		contexto.acessarSite();
	}

}
