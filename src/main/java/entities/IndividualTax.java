package entities;

public class IndividualTax extends TaxPayer {

    Double HealthExpenditures;

    public IndividualTax(){}

    public IndividualTax(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        HealthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return HealthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        HealthExpenditures = healthExpenditures;
    }

    @Override
    public double TotalTax() {
        double total = 0.0;
        if (getAnualIncome() < 20000.00){
            total = (getAnualIncome() * 0.15) - (getHealthExpenditures() * 0.5);
        } else {
            total = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.5);
        }
        return total;
    }

}
