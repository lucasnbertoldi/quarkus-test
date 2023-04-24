package br.com.lucasnbertoldi;

import java.util.List;
import java.util.function.Consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.list.ListCommands;
import io.vertx.redis.client.Command;

@ApplicationScoped
public class FrutasService {

    private final String CHAVE = "fruta";
    private final Integer TTL_SEGUNDOS_CACHE = 10;

    private final ListCommands<String, Fruta> listCommands;

    public FrutasService(RedisDataSource ds) {
        listCommands = ds.list(Fruta.class);
    }

    public List<Fruta> lista() {
        List<Fruta> lista;
        if (listCommands.llen("fruta") > 0) {
            lista = listCommands.lrange(CHAVE, 0, -1);
            System.out.println("Cache");
        } else {
            lista = Fruta.listAll();
            lista.forEach(adicionarCache());
            listCommands.getDataSource().execute(Command.EXPIRE, CHAVE, TTL_SEGUNDOS_CACHE + "");
            System.out.println("Banco de dados");
        }
        return lista;
    }

    private Consumer<Fruta> adicionarCache() {
        return (Fruta fruta) -> {
            listCommands.rpush("fruta", fruta);
        };
    }

    @Transactional
    public void novaFruta(InserirFrutaDTO frutaDTO) {
        Fruta fruta = new Fruta();
        fruta.nome = frutaDTO.getNome();
        fruta.qtd = frutaDTO.getQtd();
        fruta.persist();
    }
}
