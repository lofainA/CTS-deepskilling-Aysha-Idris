import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BookManager {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Search strategy: 1.Linear\t2.Binary");
//        int opt = Integer.parseInt(br.readLine());
        System.out.print("Title: " );
        String title = br.readLine();
        System.out.println("-----------------------");

        System.out.println("\033[0;1mSearching by linear search..\033[0;0m");
        BookSearch strat = new LinearBookSearch();
        long linear = test(strat, title);

        System.out.println("\033[0;1mSearching by binary search..\033[0;0m");
        strat = new BinaryBookSearch();
        long binary = test(strat, title);

        System.out.println("\033[0;1mTime saved by binary search: " + (linear - binary) + " ms\033[0;0m");

    }

    public static long test(BookSearch strat, String title){
        long startTime = System.currentTimeMillis();
        Book book = strat.searchByTitle(title);
        if(book != null) {
            book.display();
        } else {
            System.out.println("Book not found :(");
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Ellapsed Time: " + elapsedTime + " ms\n");
        return elapsedTime;
    }
}
