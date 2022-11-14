public class YearString {
    int month;
    int amount;

    public YearString(int month, int amount) {
        this.month = month;
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public void printYearString() {
        System.out.println(month + " " + amount);
    }

}
