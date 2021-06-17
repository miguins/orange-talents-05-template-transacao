package zup.ot5.lucasmiguins.transacao.transacao;

import org.springframework.data.domain.Page;
import zup.ot5.lucasmiguins.transacao.cartao.CartaoResponse;
import zup.ot5.lucasmiguins.transacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;

    private EstabelecimentoResponse estabelecimento;

    private CartaoResponse cartao;

    private LocalDateTime efetivadaEm;


    public TransacaoResponse(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<TransacaoResponse> converter(Page<Transacao> transacoes) {
        return transacoes.map(TransacaoResponse::new);
    }
}
