package johnatan.teste;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
@ContextConfiguration(classes = {MockServletContext.class})
public class CorreiosControllerTest {

  @InjectMocks
  private CorreiosController controller;

  @Mock
  private CorreiosService correiosService;

  protected MockMvc mvc;

  @BeforeEach
  public void setup() {
    openMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void getAddressByCepTest() throws Exception {
    Long cep = 123456789L;
    Address address = new Address();
    address.setCep("60337380");
    address.setBairro("Cristo Redentor");
    address.setCidade("fortaleza");
    address.setComplemento("");
    address.setLogradouro("");
    address.setUf("ce");

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(address);

    when(correiosService.getAddressByCep(cep)).thenReturn(address);

    ResultActions perform = mvc.perform(
        get("/correios/cep/" + cep)
            .content(jsonString)
            .contentType(MediaType.APPLICATION_JSON));

    perform.andExpect(status().isOk());
  }

  @Test
  public void getCityByCepTest() throws Exception {
    Long cep = 123456789L;
    when(correiosService.getCityByCep(cep)).thenReturn("fortaleza");

    ResultActions perform = mvc.perform(
        get("/correios/cep/" + cep + "/cidade")
            .content("fortaleza")
            .contentType(MediaType.APPLICATION_JSON));

    perform.andExpect(status().isOk());
  }
}
