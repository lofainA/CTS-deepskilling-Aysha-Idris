import java.util.Arrays;
import java.util.Comparator;

public class BinaryBookSearch implements BookSearch {
    @Override
    public Book searchByTitle(String title) {
        Arrays.sort(BookCatalogue.books, Comparator.comparing(b -> b.title.toLowerCase()));
        int low = 0;
        int high = Catalogue.size() - 1;

        while(low <= high) {
            int mid = (low + high)/ 2;
            int cmp = BookCatalogue.books[mid].title.compareToIgnoreCase(title);
            if(cmp == 0) {
                return BookCatalogue.books[mid];
            }
            else if(cmp > 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return null;
    }
}
