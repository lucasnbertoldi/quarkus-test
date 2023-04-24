package br.com.lucasnbertoldi;

import java.time.Instant;
import java.util.Random;

public class IdentificadorTransacao {

    private String prefixo;
    private int idTransacao;
    private Instant inicio;

    public IdentificadorTransacao(String prefixo) {
        this.prefixo = prefixo;
        this.idTransacao = Math.abs(new Random().nextInt());
        this.inicio = Instant.now();
    }

    public String get() {
        return this.prefixo + idTransacao + " - " + inicio;
    }

}
