import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EcommerceManager {
    public static void main(String[] args) {
        Search search = new LinearSearch();
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Catalogue.products[0].displayDetails();

        System.out.println("Parameter to search by: \t1.Id\t2.Name\t3.Category\t4.display");
        int opt = sc.nextInt();

        try {
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
                    for(Product prod: p3) {
                        prod.displayDetails();
                    }
                    break; 
            }
        } catch(NullPointerException npe) {
            System.out.println("Product not found");
        } catch(IOException io) {
            System.out.println("Input error");
        }
        
    }
}
