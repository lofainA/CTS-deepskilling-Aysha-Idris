public interface Search {
    public Product searchById(int id);
    public Product searchByName(String name);
    public Product[] searchByCategory(String category);
}
