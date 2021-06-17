package zup.ot5.lucasmiguins.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zup.ot5.lucasmiguins.transacao.cartao.Cartao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findByCartao(Cartao cartao, Pageable paginacao);
}
