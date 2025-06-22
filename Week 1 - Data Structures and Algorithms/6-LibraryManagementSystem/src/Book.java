public class Book {
    private static int idCount = 100;
    public int bookID;
    public String title;
    public String author;

    public Book(String title, String author) {
        this.bookID = idCount++;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println(
            "Id: " + bookID +
            "\nTitle: " + title +
            "\nAuthor: " + author +
            "\n-----------------------"
        );
    }
}
