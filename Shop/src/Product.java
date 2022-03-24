public class Product {
    private String name;
    private double price;

    public Product() {
        this.name = "None";
        this.price = 0.0;
    }

    public Product(String name, double price) throws Exception {
        this.name = name;
        if (price < 0)
            throw new MyException("Negative price indicated");
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, price);
    }
}
