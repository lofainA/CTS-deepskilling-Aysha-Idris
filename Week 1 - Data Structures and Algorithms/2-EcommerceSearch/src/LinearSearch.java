public class LinearSearch implements Search {

    @Override
    public Product searchById(int id) {
        for(int i = 0; i < Catalogue.size(); i++) {
            if(Catalogue.products[i].productId == id) {
                return Catalogue.products[i];
            }
        }
        return null;
    }

    @Override
    public Product searchByName(String name) {
        for (int i = 0; i < Catalogue.size(); i++) {
            if(Catalogue.products[i].productName.equalsIgnoreCase(name)) {
                return Catalogue.products[i];
            }
        }
        return null;
    }

    @Override
    public Product[] searchByCategory(String category) {
        int count = 0;
        for (int i = 0; i < Catalogue.size(); i++) {
            if(Catalogue.products[i].category.equalsIgnoreCase(category)) {
                count++;
            }
        }
        if(count == 0) return null;
        
        Product[] cat = new Product[count];
        count = 0;
        for (int i = 0; i < Catalogue.size(); i++) {
            if(Catalogue.products[i].category.equalsIgnoreCase(category)) {
                cat[count] = Catalogue.products[i];
                count++;
            }
        }
        return cat;
    }
    
}
