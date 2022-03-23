import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog(LoadConfig.getPathDataCatalog(args[0]), LoadConfig.getFilters(args[0]));
        int command =-1;
        String  answer;
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String menu = new StringBuilder()
                .append("List of commands:\n")
                .append("0 - menu:\n")
                .append("1 - add product\n")
                .append("2 - delete product\n")
                .append("3 - catalog of products\n")
                .append("4 - search product\n")
                .append("5 - save data of catalog\n")
                .append("other - exit\n").toString();
        System.out.println(menu);
        System.out.print("Enter number of command: ");
        if(sc.hasNextInt()) {
            command = sc.nextInt();
        }
        while (true){
            switch (command){
                case (0):
                    System.out.println(menu);
                    break;
                case (1):
                    try {
                        System.out.println("Enter the name and price:");
                        answer = in.nextLine();
                        if(catalog.addProduct(answer))
                            System.out.println("Product added");
                        else
                            System.out.println("Prohibited product!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case (2):
                    try {
                        System.out.println("Enter the name:");
                        answer = in.nextLine();
                        if(catalog.deleteProduct(answer))
                            System.out.println("Product removed");
                        else
                            System.out.println("Product not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case(3):
                    System.out.println(catalog);
                    break;
                case(4):
                    System.out.println("Input name:");
                    answer = in.nextLine();
                    Product product = catalog.searchProduct(answer);
                    if(product.getName().equals("None"))
                        System.out.println("Product not found");
                    else
                        System.out.println(product);
                    break;
                case (5):
                    catalog.SaveFile();
                    break;
                default:
                    System.out.println("End");
                    System.exit(0);
            }
            try {
                System.out.print("Enter number of command: ");
                command = sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("End");
                System.exit(0);
            }
        }
    }
}
