public class PDFDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        System.out.println("Creating new PDF Document...");
        return new PDFDocument();
    }
}
