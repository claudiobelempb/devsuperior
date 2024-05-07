package br.com.surb.aula.services;

import br.com.surb.aula.entities.Employee;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    private final TaxService taxService;
    private final PensionService pensionService;

    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }


    public double netSalary(Employee employee) {
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) - pensionService.discount(employee.getGrossSalary());
    }
}
