import java.util.Scanner;

public class TestDocumentCreator {
    public static void main(String[] args) {
        DocumentCreator dc = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Word\n2. PDF\n3.Excel\n");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                dc = new WordDocumentCreator();
                break;
            case 2:
                dc = new PDFDocumentCreator();
                break;
            case 3:
                dc = new ExcelDocumentCreator();
                break;
        }

        Document doc = dc.createDocument();
        doc.open();
    }
}
