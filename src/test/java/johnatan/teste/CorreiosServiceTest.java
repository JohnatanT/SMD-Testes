package johnatan.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CorreiosServiceTest {

  @InjectMocks
  private CorreiosService correiosService;

  @Mock
  private CorreiosApi correiosApi;

  @BeforeEach
  public void setup() {
    openMocks(this);
  }

  @Test
  public void getAddressByCepTest() {
    Long cep = 60337380L;
    Address address = new Address();
    address.setCep("60337380");
    address.setBairro("Cristo Redentor");
    address.setCidade("fortaleza");
    address.setComplemento("");
    address.setLogradouro("");
    address.setUf("ce");

    when(correiosApi.getAddressByCep(cep)).thenReturn(address);
    Address result = correiosService.getAddressByCep(cep);
    assertEquals("fortaleza", result.getCidade());
    assertEquals("Cristo Redentor", result.getBairro());
    assertEquals("ce", result.getUf());
    assertEquals("60337380", result.getCep());
    assertEquals("", result.getLogradouro());
    assertEquals("", result.getComplemento());
  }

  @Test
  public void getCityByCepTest() {
    Long cep = 60337380L;
    Address address = new Address();
    address.setCep("60337380");
    address.setBairro("Cristo Redentor");
    address.setCidade("fortaleza");
    address.setComplemento("");
    address.setLogradouro("");
    address.setUf("ce");

    when(correiosApi.getAddressByCep(cep)).thenReturn(address);
    String city = correiosService.getCityByCep(cep);
    assertEquals("fortaleza", city);
  }

  @Test
  public void getCityNullByCepTest() {
    Long cep = 60337380L;

    when(correiosApi.getAddressByCep(cep)).thenReturn(null);
    String city = correiosService.getCityByCep(cep);
    assertNull(city);
  }
}
