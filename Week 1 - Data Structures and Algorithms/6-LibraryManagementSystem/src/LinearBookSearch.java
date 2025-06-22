public class LinearBookSearch implements BookSearch{
    @Override
    public Book searchByTitle(String title) {
        for(Book book: BookCatalogue.books) {
            if(book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
