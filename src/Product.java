public class Product {
    private String item_name;
    private int quantity;
    private int sum_of_one;

    public Product(String item_name, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public String getItem_name() {
        return item_name;
    }

    public void print() {
        System.out.println(item_name + " " + quantity + " " + sum_of_one);
    }
}
