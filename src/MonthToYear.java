import java.util.ArrayList;
public class MonthToYear {
    private ArrayList <MonthlyReport> list = new ArrayList<>();
    public void printStatistics() {
        int number = 1;
        for (MonthlyReport m : list) {
            System.out.println();
            System.out.println("Месяц " + number);
            System.out.println("Доходы за: " + number + "-й месяц: ");
            m.printAllIncome();
            System.out.println("Расходы за: " + number + "-й месяц: ");
            m.printAllConsumption();
            System.out.println("Общие доходы за " + number + "-й месяц: " + m.getIncomeResult());
            System.out.println("Общие расходы за: " + number + "-й месяц: " + m.getConsumptionResult());
            number++;
        }
    }
    public void addMonth(MonthlyReport month) {
        list.add(month);
    }

    public int getIncomeByMonth(int i) {
        MonthlyReport month = list.get(i);
        return month.getIncomeValue();
    }
    public int getConsumptionByMonth(int i) {
        MonthlyReport month = list.get(i);
        return month.getConsumptionValue();
    }

    public int getMonthListSize() {
        return list.size();
    }

    public int getIncome(){
        int sum = 0;
        for(MonthlyReport month : list) {
            sum += month.getIncomeResult();
        }
        return sum;
    }
    public int getConsumption(){
        int sum = 0;
        for(MonthlyReport month : list) {
            sum += month.getConsumptionResult();
        }
        return sum;
    }
    public void getMonthMostProfitProduct() {
        int number = 1;
        for (MonthlyReport m : list) {
            System.out.println("Месяц " + number);
            m.getMaxIncome();
            number++;
        }
    }
    public void getMonthMostExpenseProduct() {
        int number = 1;
        for (MonthlyReport m : list) {
            System.out.println("Месяц " + number);
            m.getMaxConsumption();
            number++;
        }
    }
}
