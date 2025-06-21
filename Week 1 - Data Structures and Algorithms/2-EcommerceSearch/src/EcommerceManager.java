import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EcommerceManager {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        System.out.print("1. Linear Search\t 2.Binary Search\t-\t");
        int strat = sc.nextInt();
        Search search = strat == 1 ? new LinearSearch() : new BinarySearch();

        try {
            do {
                System.out.print("Parameter to search by: \t1.Id\t2.Name\t3.Category\t-\t");
                int opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        int id = sc.nextInt();
                        System.out.println("-----------------------");
                        Product p1 = search.searchById(id);
                        p1.displayDetails();
                        break;

                    case 2:
                        String name = br.readLine();
                        System.out.println("-----------------------");
                        Product p2 = search.searchByName(name);
                        p2.displayDetails();
                        break;

                    case 3:
                        String category = br.readLine();
                        System.out.println("-----------------------");
                        Product[] p3 = search.searchByCategory(category);
                        for (Product prod : p3) {
                            prod.displayDetails();
                        }
                        break;
                    default:
                        return;
                }
            } while(true);
        } catch(NullPointerException npe) {
            System.out.println("Product not found");
        } catch(IOException io) {
            System.out.println("Input error");
        }
        
    }
}
