import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Catalog {
    private List<Product> catalog;
    private List<String> filter;
    private File file;

    public Catalog(String path, List<String> filter) {
        catalog = new ArrayList<>();
        file = new File(path);
        this.filter=filter;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            str = reader.readLine();
            while (str != null)
            {
                try {
                    addProduct(str);
                    str = reader.readLine();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveFile() {
        try (FileWriter writer = new FileWriter(file, false)) {
            String text = FileString();
            writer.write(text);
            writer.flush();
        } catch (Exception e) {
            System.out.println("Error save");
        }
    }

    public String FileString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Product p : catalog) {
            stringBuilder.append(p.toString() + "\n");
        }
        return stringBuilder.toString();
    }

    public void setFilter(ArrayList<String> filter) {
        this.filter = filter;
    }

    public boolean addProduct(String str) throws Exception {
        if (checkFilters(str))
            return false;
        String[] a = str.trim().split(" ");

        Product product = new Product(a[0], Double.parseDouble(a[1]));
        catalog.add(product);
        return true;
    }

    public boolean checkFilters(String str) {
        for (String flt : filter) {
            Pattern pattern = Pattern.compile(flt);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) return true;
        }
        return false;
    }

    public boolean deleteProduct(String nameProduct) throws Exception {
        Product product = searchProduct(nameProduct);
        if (!product.getName().equals("None")) {
            catalog.remove(product);
            return true;
        } else
            return false;
    }

    public Product searchProduct(String name) {
        Product product = new Product();
        try {
            product = catalog.stream().filter(p -> p.getName().equals(name.trim())).findFirst().orElse(new Product());
        } catch (Exception e) {
            System.out.println(e);
        }
        return product;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("List of products:");
        for (Product product : catalog) {
            stringBuilder.append(String.format("\n %s rub.", product.toString()));
        }
        return stringBuilder.toString();
    }
}
