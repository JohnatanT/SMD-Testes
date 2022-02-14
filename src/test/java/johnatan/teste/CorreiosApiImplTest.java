package johnatan.teste;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class CorreiosApiImplTest {

  @InjectMocks
  private CorreiosApiImpl correiosApi;

  @BeforeEach
  public void setup() {
    openMocks(this);
  }

  @Test
  public void getAddressByCepTest() {
    assertNull(correiosApi.getAddressByCep(123456789L));
  }
}
