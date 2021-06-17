package zup.ot5.lucasmiguins.transacao.cartao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Cartao findByNumero(String numeroCartao);
}
