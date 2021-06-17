package zup.ot5.lucasmiguins.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zup.ot5.lucasmiguins.transacao.cartao.Cartao;
import zup.ot5.lucasmiguins.transacao.cartao.CartaoRepository;

@RestController
@RequestMapping("api/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    CartaoRepository cartaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> lista(@PathVariable("id") String numeroCartao,
                                   @PageableDefault(
                                           page = 0,
                                           size = 10,
                                           sort = "efetivadaEm",
                                           direction = Sort.Direction.DESC) Pageable paginacao) {

        Cartao cartao = cartaoRepository.findByNumero(numeroCartao);

        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }

        Page<Transacao> transacoes = transacaoRepository.findByCartao(cartao, paginacao);

        return ResponseEntity.ok().body(TransacaoResponse.converter(transacoes));
    }
}
