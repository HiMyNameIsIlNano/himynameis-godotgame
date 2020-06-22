package gradle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class JavaEnumGenerator extends EnumGenerator {

    @Override
    void generateEnums(EnumGeneratorArgsWrapper args) {
        throwExceptionIfOutputFolderDoesNotExist(args);
        doCreateEnum(args);
    }

    private void throwExceptionIfOutputFolderDoesNotExist(EnumGeneratorArgsWrapper args) {
        String outputFolder =
                getOutputFolder() + fromPackageToDirectoryPath(args.getOutputDomain());
        if (!Files.exists(Path.of(outputFolder))) {
            throw new IllegalStateException("Folder " + outputFolder + "does not exist");
        }
    }

    private String getOutputFolder() {
        return getRootFolder() + File.separator + "java" + File.separator;
    }

    private void doCreateEnum(EnumGeneratorArgsWrapper args) {
        try {
            String outputFolder =
                    getOutputFolder() + fromPackageToDirectoryPath(args.getOutputDomain());
            FileWriter fileWriter =
                    createFileWriter(args.getOutputClassName(), "java", outputFolder);
            writeDataToFile(args, fileWriter);
        } catch (IOException e) {
            String error = String.format("File %s not found", e.getMessage());
            System.out.println();
        }
    }

    @Override
    void writeDataToFile(EnumGeneratorArgsWrapper args, FileWriter fileWriter) throws IOException {
        createPackageStatement(fileWriter, args.getOutputDomain());
        createClassSignature(fileWriter, args.getOutputClassName());
        createEnumBody(fileWriter, getEnumValues(args));
        closeClass(fileWriter);
        fileWriter.flush();
    }

    private void createClassSignature(FileWriter fileWriter, String className) throws IOException {
        String signature = "public enum " + className + " {";
        fileWriter.append(signature);
        fileWriter.append(EnumGeneratorArgsWrapper.NEW_LINE);
    }

    private void createPackageStatement(FileWriter fileWriter, String outputDomain)
            throws IOException {
        String header =
                "package "
                        + outputDomain
                        + EnumGeneratorArgsWrapper.LINE_END
                        + EnumGeneratorArgsWrapper.NEW_LINE;
        fileWriter.append(header);
        fileWriter.append(EnumGeneratorArgsWrapper.NEW_LINE);
    }

    private void createEnumBody(FileWriter fileWriter, List<String> enums) throws IOException {
        String body =
                enums.stream()
                        .map(String::toUpperCase)
                        .map(enumAsString -> EnumGeneratorArgsWrapper.TAB + enumAsString)
                        .collect(Collectors.joining(", " + EnumGeneratorArgsWrapper.NEW_LINE));

        fileWriter.append(body);
    }

    private void closeClass(FileWriter fileWriter) throws IOException {
        fileWriter.append(EnumGeneratorArgsWrapper.NEW_LINE);
        fileWriter.append("}");
    }
}
