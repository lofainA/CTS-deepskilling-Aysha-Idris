import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch implements Search{

    @Override
    public Product searchById(int id) {
        Arrays.sort(Catalogue.products, Comparator.comparingInt(p -> p.productId));
        int low = 0;
        int high = Catalogue.size() - 1;

        while(low <= high) {
            int mid = (low + high)/ 2;
            if(Catalogue.products[mid].productId == id) {
                return Catalogue.products[mid];
            }
            else if(Catalogue.products[mid].productId > id) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return null;
    }

    @Override
    public Product searchByName(String name) {
        Arrays.sort(Catalogue.products, Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0;
        int high = Catalogue.size() - 1;

        while(low <= high) {
            int mid = (low + high)/ 2;
            int cmp = Catalogue.products[mid].productName.compareToIgnoreCase(name);
            if(cmp == 0) {
                return Catalogue.products[mid];
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

    @Override
    public Product[] searchByCategory(String targetCategory) {
        
        Arrays.sort(Catalogue.products, Comparator.comparing(p -> p.category.toLowerCase()));
        
        int firstIndex = findFirstOccurrence(Catalogue.products, targetCategory);
        if (firstIndex == -1) {
            return new Product[0]; 
        }
        
        int lastIndex = findLastOccurrence(Catalogue.products, targetCategory);
        
        int resultSize = lastIndex - firstIndex + 1;
        Product[] result = new Product[resultSize];
        System.arraycopy(Catalogue.products, firstIndex, result, 0, resultSize);

        return result;
    }

    private static int findFirstOccurrence(Product[] products, String targetCategory) {
        int low = 0, high = products.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].category.compareTo(targetCategory);

            if (comparison == 0) {
                result = mid;
                high = mid - 1; // continue searching in the low half
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(Product[] products, String targetCategory) {
        int low = 0, high = products.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].category.compareTo(targetCategory);

            if (comparison == 0) {
                result = mid;
                low = mid + 1; // continue searching in the high half
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
    
}
