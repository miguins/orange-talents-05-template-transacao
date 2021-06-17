package zup.ot5.lucasmiguins.transacao.transacao;

import zup.ot5.lucasmiguins.transacao.cartao.Cartao;
import zup.ot5.lucasmiguins.transacao.cartao.EventoCartao;
import zup.ot5.lucasmiguins.transacao.estabelecimento.Estabelecimento;
import zup.ot5.lucasmiguins.transacao.estabelecimento.EventoEstabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    private String id;

    private BigDecimal valor;

    private EventoEstabelecimento estabelecimento;

    private EventoCartao cartao;

    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EventoEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public EventoCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(Cartao cartao, Estabelecimento estabelecimento) {

        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}

