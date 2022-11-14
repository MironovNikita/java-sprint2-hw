import java.util.ArrayList;
public class MonthlyReport {
    private ArrayList <Product> income = new ArrayList<>();
    private ArrayList <Product> consumption = new ArrayList<>();

    public void addProduct(Product product, boolean operation) {
        if(operation) consumption.add(product);
        else income.add(product);
    }

    public int getIncomeResult() {
        int sum = 0;
        for (Product pr : income) {
            sum += pr.getQuantity() * pr.getSum_of_one();
        }
        return sum;
    }
    public void getMaxIncome() {
        int maxSum = 0;
        int result = 0;
        String incomeName = "";
        for (Product pr : income) {
            result = pr.getQuantity() * pr.getSum_of_one();
            if (result > maxSum) {
                maxSum = result;
                incomeName = pr.getItem_name();
            }
        }
        System.out.println(incomeName + ", сумма: " + maxSum);
    }
    public void getMaxConsumption() {
        int result = 0;
        String consName = "";
        int maxCons = 0;
        for (Product pr : consumption) {
            result = pr.getQuantity() * pr.getSum_of_one();
            if (result > maxCons) {
                maxCons = result;
                consName = pr.getItem_name();
            }
        }
        System.out.println(consName + ", сумма: " + maxCons);
    }
    public int getConsumptionResult() {
        int sum = 0;
        for (Product pr : consumption) {
            sum += pr.getQuantity() * pr.getSum_of_one();
        }
        return sum;
    }
    public void printAllConsumption() {
        for (Product pr : consumption) {
            pr.print();
        }
    }
    public void printAllIncome() {
        for (Product pr : income) {
            pr.print();
        }
    }

    public int getIncomeValue() {
        int sum = 0;
        for (Product pr : income) {
            sum += pr.getQuantity() * pr.getSum_of_one();
        }
        return sum;
    }
    public int getConsumptionValue() {
        int sum = 0;
        for (Product pr : consumption) {
            sum += pr.getQuantity() * pr.getSum_of_one();
        }
        return sum;
    }
}
