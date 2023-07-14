package hooks;

import io.restassured.response.Response;

public class ServiceHooks {

	private static Response response;

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		ServiceHooks.response = response;
	}

}
