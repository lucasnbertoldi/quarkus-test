package br.com.lucasnbertoldi;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import javax.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;

    @Test
    public void getFrutasEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200);
             //.body(is("Hello RESTEasy"));
    }

    @Test
    public void getFrutas() {
        System.out.println(frutasService);
        List<Fruta> lista = frutasService.lista();
        assertFalse(lista.isEmpty());
    }

}