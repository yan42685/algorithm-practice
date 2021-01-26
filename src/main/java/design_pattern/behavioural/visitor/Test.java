package design_pattern.behavioural.visitor;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        Printer printer = new Printer();
        Compressor compressor = new Compressor();
        listAllResourceFiles().forEach(file ->
        {
            file.accept(extractor);
            file.accept(printer);
            file.accept(compressor);
            System.out.println();
        });
    }

    private static List<ResourceFile> listAllResourceFiles() {
        ArrayList<ResourceFile> resourceFiles = new ArrayList<>();
        PdfFile pdfFile = new PdfFile("src/aaa.pdf");
        WordFile wordFile = new WordFile("src/bbb.word");
        XmlFile xmlFile = new XmlFile("src/ccc.xml");
        resourceFiles.add(pdfFile);
        resourceFiles.add(wordFile);
        resourceFiles.add(xmlFile);
        return resourceFiles;
    }
}
