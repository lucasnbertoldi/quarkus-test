package br.com.lucasnbertoldi;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.vertx.mutiny.redis.client.RedisAPI;

@Path("/frutas")
public final class FrutasResource {

    @Inject
    FrutasService frutasService;
    @Inject
    IdentificadorTransacao identificadorTransacao;
    @Inject RedisAPI lowLevelClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> lista() {
        System.out.println(identificadorTransacao.get());
        return frutasService.lista();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        System.out.println(identificadorTransacao.get());
        frutasService.novaFruta(inserirFrutaDTO);
    }
}