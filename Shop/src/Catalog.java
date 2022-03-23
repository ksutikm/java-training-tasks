import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Catalog {
    private List<Product> catalog;
    private List<String> filter;

    public Catalog(String path, List<String> filter) {
        catalog = new ArrayList<>();
        this.filter = filter;

        try {
            Files.readAllLines(Paths.get(path)).forEach(this::addProduct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(String path) {
        try {
            String text = fileString();
            Files.write(Paths.get(path), text.getBytes());
        } catch (Exception e) {
            System.out.println("Error save");
        }
    }

    public String fileString() {
        return catalog.stream().map(Product::toString).collect(Collectors.joining("\n"));
    }

    public boolean addProduct(String str) {
        if (checkFilters(str))
            return false;
        String[] a = str.trim().split(" ");
        try {
            Product product = new Product(a[0], Double.parseDouble(a[1]));
            catalog.add(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean checkFilters(String str) {
        List<Pattern> patterns = filter.stream().map(Pattern::compile).collect(Collectors.toList());
        for (Pattern pattern : patterns) {
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
        return catalog.stream().filter(p -> p.getName().equals(name.trim())).findFirst().orElse(new Product());
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
