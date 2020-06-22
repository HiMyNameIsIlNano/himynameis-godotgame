package gradle;

import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;

public abstract class EnumGenerator {

    void generateEnums(EnumGeneratorArgsWrapper args) {}

    void writeDataToFile(EnumGeneratorArgsWrapper args, FileWriter fileWriter) throws IOException {}

    FileWriter createFileWriter(String fileName, String extension, String outputFolder)
            throws IOException {
        String outputFile = fileName + "." + extension;
        File file = new File(outputFolder, outputFile);
        return new FileWriter(file);
    }

    public String getRootFolder() {
        return ".."
                + File.separator
                + "backend"
                + File.separator
                + "src"
                + File.separator
                + "main"
                + File.separator;
    }

    public String fromPackageToDirectoryPath(String outputDomain) {
        return outputDomain.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
    }

    List<String> getEnumValues(EnumGeneratorArgsWrapper args) throws IOException {
        String absolutePath = args.getInputFileDirectory() + File.separator + args.getInputFile();
        String json = new String(Files.readAllBytes(Paths.get(absolutePath)));
        return JsonPath.parse(json).read(args.getFilterFunction());
    }
}
