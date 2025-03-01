package br.com.ctfera.payroll_api.domain;

import lombok.*;

@Getter @Setter
@AllArgsConstructor

public class Payroll {
    private String workerName;
    private String description;
    private Double hourlyPrice;
    private Double workedHours;
    private Double totalPayment;
}
