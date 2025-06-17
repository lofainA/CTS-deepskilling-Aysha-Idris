public class WordDocumentCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        System.out.println("Creating word document");
        return new WordDocument();
    }
}
