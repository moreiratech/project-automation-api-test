package steps;

import org.junit.Assert;

import hooks.ServiceHooks;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class CommonsSteps {

	@Então("valido o retorno da api com status code {string}")
	public void validoRetorndoDaApi(String retorno) {
		Assert.assertEquals("Status HTTP diferente do esperado", Integer.parseInt(retorno),
				ServiceHooks.getResponse().getStatusCode());
	}
}
