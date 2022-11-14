import java.util.ArrayList;

public class YearlyReport {
    private ArrayList <YearString> income = new ArrayList<>();
    private ArrayList <YearString> consumption = new ArrayList<>();

    public void addYearString(YearString year, boolean operation) {
        if(operation) consumption.add(year);
        else income.add(year);
    }

    public void printAllConsumption() {
        for (YearString y : consumption) {
            y.printYearString();
        }
    }
    public void printAllIncome() {
        for (YearString y : income) {
            y.printYearString();
        }
    }

    //Данный метод будет проверять, совпадают ли списки доходов/расходов
    //Вдруг забыли указать строку дохода/расхода какого-либо месяца в отчёте
    public int getYearBalance() {
        if (income.size() == consumption.size()) {
            return income.size();
        } else {
            return 0;
        }
    }

    public int getIncomeSize() {
        return income.size();
    }

    public int getConsumptionSize() {
        return consumption.size();
    }

    public int getMonthIncome(int i) {
        int sumIncome = 0;
        YearString sum = income.get(i);
        sumIncome = sum.getAmount();
        return sumIncome;
    }

    public int getMonthConsumption(int i) {
        int sumCons = 0;
        YearString cons = consumption.get(i);
        sumCons = cons.getAmount();
        return sumCons;
    }

    public int getMonthProfit(int i) {
        int sumProfit = 0;
        int sumConsumption = 0;
        YearString sum = income.get(i);
        YearString cons = consumption.get(i);
        sumProfit += sum.getAmount();
        sumConsumption += cons.getAmount();
        return sumProfit - sumConsumption;
    }

    public double getAverageMonthConsumption() {
        int counter = 0;
        double sum = 0;
        for (YearString y : consumption) {
            sum += y.getAmount();
            counter++;
        }
        if(counter == 0) {
            return 0;
        }
        else {
            return sum/counter;
        }
    }
    public double getAverageMonthIncome() {
        int counter = 0;
        double sum = 0;
        for (YearString y : income) {
            sum += y.getAmount();
            counter++;
        }
        if(counter == 0) {
            return 0;
        }
        else {
            return sum/counter;
        }
    }
}
