package service;

import dto.UserDTO;
import hooks.ServiceHooks;
import io.restassured.builder.RequestSpecBuilder;
import org.json.JSONObject;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class UserService {

    private final static String URL = PropertyReader.getProperty("urlApi") + "/api/users";

    public void postCreateUser(UserDTO userDto) {
        RequestSpecBuilder request = new RequestSpecBuilder();

        request.setAccept("*/*");
        request.setContentType("application/json");

        ServiceHooks.setResponse(
                given()
                        .log()
                        .all()
                        .spec(request.build())
                        .body(userDto)
                        .post(URL));

        System.out.println("Retorno da API Create User");
        ServiceHooks.getResponse().then().log().all();
    }
}
