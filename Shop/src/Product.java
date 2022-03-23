import java.util.Objects;

public class Product {
    private String name;
    private double prise;

    public Product() {
        this.name = "None";
        this.prise = 0.0;
    }

    public Product(String name, double prise) throws Exception {
        this.name = name;
        if (prise < 0)
            throw new Exception("Prise error");
        this.prise = prise;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, prise);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(prise, product.prise) == 0 && Objects.equals(name, product.name);
    }
}
