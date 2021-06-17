package zup.ot5.lucasmiguins.transacao.cartao;

import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Cartao findByNumeroAndEmail(String id, String email);
}
