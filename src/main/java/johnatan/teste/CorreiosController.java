package johnatan.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "correios")
public class CorreiosController {

  @Autowired
  private CorreiosService correiosService;

  @GetMapping("/cep/{cep}")
  public ResponseEntity<Address> getAddressByCep(@PathVariable("cep") Long cep) {
    return new ResponseEntity<Address>(correiosService.getAddressByCep(cep), HttpStatus.OK);
  }

  @GetMapping("/cep/{cep}/cidade")
  public ResponseEntity<Address> getCityByCep(@PathVariable("cep") Long cep) {
    return new ResponseEntity<Address>(correiosService.getAddressByCep(cep), HttpStatus.OK);
  }

}
