package zup.ot5.lucasmiguins.transacao.transacao;

import zup.ot5.lucasmiguins.transacao.cartao.Cartao;
import zup.ot5.lucasmiguins.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String uuid;

    @NotNull
    private BigDecimal valor;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estabelecimento estabelecimento;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String uuid, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.uuid = uuid;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public void paraOCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
