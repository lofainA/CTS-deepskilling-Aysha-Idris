public class ExcelDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        System.out.println("Creating new Excel document...");
        return new ExcelDocument();
    }
}
