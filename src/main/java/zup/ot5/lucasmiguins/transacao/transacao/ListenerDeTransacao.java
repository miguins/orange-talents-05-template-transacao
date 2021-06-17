package zup.ot5.lucasmiguins.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import zup.ot5.lucasmiguins.transacao.cartao.Cartao;
import zup.ot5.lucasmiguins.transacao.cartao.CartaoRepository;
import zup.ot5.lucasmiguins.transacao.estabelecimento.Estabelecimento;

@Component
public class ListenerDeTransacao {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);

        Cartao cartaoExistente = cartaoRepository.findByNumero(eventoDeTransacao.getCartao().getId());
        Estabelecimento estabelecimento = eventoDeTransacao.getEstabelecimento().toModel();

        if (cartaoExistente != null) {
            Transacao transacao = eventoDeTransacao.toModel(cartaoExistente, estabelecimento);
            transacaoRepository.save(transacao);
        } else {
            Cartao cartao = eventoDeTransacao.getCartao().toModel();
            cartaoRepository.save(cartao);
            Transacao transacao = eventoDeTransacao.toModel(cartao, estabelecimento);
            transacaoRepository.save(transacao);
        }
    }
}

