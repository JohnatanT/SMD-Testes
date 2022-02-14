package johnatan.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorreiosService {

  @Autowired
  private CorreiosApi correiosApi;

  public Address getAddressByCep(Long cep) {
    return correiosApi.getAddressByCep(cep);
  }

  public String getCityByCep(Long cep) {
    Address address = correiosApi.getAddressByCep(cep);
    if (address != null) {
      return address.getCidade();
    }

    return null;
  }

}
