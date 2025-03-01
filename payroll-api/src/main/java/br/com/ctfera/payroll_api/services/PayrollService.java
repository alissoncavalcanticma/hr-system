package br.com.ctfera.payroll_api.services;

import br.com.ctfera.payroll_api.domain.Payroll;
import br.com.ctfera.payroll_api.feignClients.UserFeign;
import br.com.ctfera.payroll_api.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Slf4j //Annotation usada para logs
@Service
public class PayrollService {

    private final Environment env; // Para buscar dados do ambiente (PORTA DO SERVIÇO)

    //Instancia do Feign
    private UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");

        try{

            //Capturando o retorno da chamada do Feign
            var user = feign.findById(workerId).getBody(); //getBody é necessário para garantir a captura da informação do usuário.

            if(Objects.nonNull(user)){
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        (user.getHourlyPrice() * payroll.getWorkedHours())
                );
            }
        }catch(FeignException.NotFound ex){
            throw new ObjectNotFoundException("Object not found");
        }catch(Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }

}
