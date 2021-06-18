package zup.ot5.lucasmiguins.transacao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveRetornarUnauthorizedQuandoNaoExistirToken() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/transacoes"))
                                              .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    void deveRetornarForbiddenParaScopeIncorreto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/transacoes/{id}", "123456")
                .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_naoexiste"))))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    void deveRetornarOkComScopeCorreto() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/transacoes/{id}", "123456")
                        .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_transacoes:read")))
//                .header("Authorization", "Bearer " + tokenJWT)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isNotEmpty())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
