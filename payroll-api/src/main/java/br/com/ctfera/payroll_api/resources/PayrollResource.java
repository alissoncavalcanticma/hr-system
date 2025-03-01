package br.com.ctfera.payroll_api.resources;

import br.com.ctfera.payroll_api.domain.Payroll;
import br.com.ctfera.payroll_api.domain.User;
import br.com.ctfera.payroll_api.feignClients.UserFeign;
import br.com.ctfera.payroll_api.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
public class PayrollResource {

    @Autowired
    private PayrollService payrollService;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){

        return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
    }
}
