package Entities;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(){
    }

    public TaxPayer(double salaryIncome,
                    double servicesIncome,
                    double capitalIncome,
                    double healthSpending,
                    double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){
        double tax;
        if (salaryIncome/12 < 3000){
            tax = 0.0;
        } else if (salaryIncome/12 > 3000 && salaryIncome/12 < 5000) {
            tax = salaryIncome * 0.1;
        }else{
            tax = salaryIncome * 0.2;
        }
        return tax;
    }

    public double serviceTax(){
        double tax;
        if (servicesIncome > 0){
            tax = servicesIncome * 0.15;
        }
        else {
            tax = 0.0;
        }
        return tax;
    }

    public double capitalTax(){
        double tax;
        if(capitalIncome > 0){
            tax = capitalIncome * 0.2;
        }else {
            tax = 0.0;
        }
        return tax;
    }

    public double grossTax(){
        return salaryTax() + serviceTax() + capitalTax();
    }

    public double taxRebate(){
        double rebate = 0.0;
        if (healthSpending + educationSpending < grossTax()*0.3){
            rebate = healthSpending + educationSpending;
        } else if (healthSpending + educationSpending > grossTax()*0.3) {
            rebate =  grossTax()*0.3;
        }
        return rebate;
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }
}
