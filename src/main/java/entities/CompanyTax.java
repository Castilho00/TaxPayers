package entities;

public class CompanyTax extends TaxPayer {

    private Integer employees;

    public CompanyTax(String name, Double anualIncome, Integer employees) {
        super(name, anualIncome);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public double TotalTax() {
        double total = 0.0;
        if(getEmployees() < 10){
            total = getAnualIncome() * 0.16;
        } else {
            total = getAnualIncome() * 0.14;
        }
        return total;
    }
}
