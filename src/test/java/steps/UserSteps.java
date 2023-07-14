package steps;

import com.github.javafaker.Faker;
import dto.UserDTO;
import hooks.ServiceHooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.junit.Assert;
import service.UserService;

import java.io.File;

public class UserSteps {

    UserService userService = new UserService();
    UserDTO userDto = new UserDTO();
    Faker faker = new Faker();

       @Dado("que realizo um cadastro de usuário")
    public void realizoCadastroUsuario() {
        userDto.setName(faker.address().firstName());
        userDto.setJob(faker.job().title());

        userService.postCreateUser(userDto);
    }

    @E("valido a criação do usuário")
    public void validoCriacaoUsuario() {
        Assert.assertEquals("Nome diferente do cadastrado", userDto.getName(),
                ServiceHooks.getResponse().jsonPath().getString("name"));
        Assert.assertEquals("Job diferente do cadastrado", userDto.getJob(),
                ServiceHooks.getResponse().jsonPath().getString("job"));
        Assert.assertNotNull("Nenhum dado retornado para id",
                ServiceHooks.getResponse().jsonPath().getString("id"));
    }

    @E("valido a estrutura do retorno da api create user")
    public void validoEstrutaRetornoCreateUser() {
        validarSchema("schema-create-user");
    }

    private void validarSchema(String schema) {
        File schemaFile = new File("src/test/resources/schemas/" + schema + ".json");
        ServiceHooks.getResponse().then().assertThat().body(matchesJsonSchema(schemaFile));
    }
}
