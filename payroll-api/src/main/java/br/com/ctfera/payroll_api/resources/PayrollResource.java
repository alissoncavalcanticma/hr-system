package br.com.ctfera.payroll_api.resources;

import br.com.ctfera.payroll_api.domain.Payroll;
import br.com.ctfera.payroll_api.domain.User;
import br.com.ctfera.payroll_api.feignClients.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    //Instancia o bean do Feign
    @Autowired
    private UserFeign userFeign;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){

        //Capturando o retorno da chamada do Feign
        User user = userFeign.findById(workerId).getBody(); //getBody é necessário para garantir a captura da informação do usuário.

        return ResponseEntity.ok().body(
                new Payroll(
                        user.getName(),
                        payment.getDescription(),
                        user.getHourlyPrice(),
                        payment.getWorkedHours(),
                        user.getHourlyPrice() * payment.getWorkedHours())
        );
    }
}
