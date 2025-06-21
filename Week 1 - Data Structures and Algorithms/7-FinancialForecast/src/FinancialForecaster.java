public class FinancialForecaster {
    public static void main(String[] args) {
        double currentValue = 10000;
        int years = 5;
        double growthRate = 0.08;

        double futureValue = predictValue(currentValue, years, growthRate);
        System.out.printf("Predicted Future Value after %d years: ₹%.2f\n", years, futureValue);
    }

    public static double predictValue(double currentValue, int year, double growthRate) {
        if(year == 0) {
            return  currentValue;
        }
        else {
            return predictValue(currentValue, year -1, growthRate) * (1 + growthRate);
        }
    }
}
