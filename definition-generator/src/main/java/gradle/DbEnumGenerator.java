package gradle;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class DbEnumGenerator extends EnumGenerator {

	@Override
	void generateEnums(EnumGeneratorArgsWrapper args) {
		throwExceptionIfOutputFolderDoesNotExist(args);
		doCreateEnum(args);
	}

	private void throwExceptionIfOutputFolderDoesNotExist(EnumGeneratorArgsWrapper args) {
		String outputFolder = args.getDbEnumOutputFolder();
		if (!Files.exists(Path.of(outputFolder))) {
			throw new IllegalStateException("Folder " + outputFolder + "does not exist");
		}
	}

	private void doCreateEnum(EnumGeneratorArgsWrapper args) {
		try {
			String outputFolder = args.getDbEnumOutputFolder();
			String fileName = getFileName(args);
			FileWriter fileWriter = createFileWriter(fileName, "sql", outputFolder);
			writeDataToFile(args, fileWriter);
		} catch (IOException e) {
			String error = String.format("File %s not found", e.getMessage());
			System.out.println(error);
		}
	}

	private String getFileName(EnumGeneratorArgsWrapper args) {
		String enumName = getEnumName(args.getInputFile());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'" + "V" + "'uu.MM.dd_HH.mm.ss" + "__");
		return formatter.format(LocalDateTime.now()) + enumName;
	}

	private String getEnumName(String inputFile) {
		return inputFile.split("\\.")[0] + "_definition";
	}

	@Override
	void writeDataToFile(EnumGeneratorArgsWrapper args, FileWriter fileWriter) throws IOException {
		createEnumTypeStatement(fileWriter, args);
		fileWriter.flush();
	}

	private void createEnumTypeStatement(FileWriter fileWriter, EnumGeneratorArgsWrapper args) throws IOException {
		String typeName = getEnumName(args.getInputFile());
		String createEnumTypeStatement = getCreateEnumTypeStatement(typeName, args);
		String statement = getStatement(typeName, createEnumTypeStatement);

		fileWriter.append(statement);
		fileWriter.append(EnumGeneratorArgsWrapper.NEW_LINE);
	}

	private String getStatement(String typeName, String createEnumTypeStatement) {
		return String.format("DO $$\n" +
					"\tBEGIN\n" +
					"\tIF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = '%s') THEN\n" +
					"\t\t%s\n" +
					"\tEND IF;\n" +
					" END$$;", typeName, createEnumTypeStatement);
	}

	private String getCreateEnumTypeStatement(String typeName, EnumGeneratorArgsWrapper args) throws IOException {
		String enumValues = getCommaSeparatedEnumValues(args);
		return String.format("CREATE TYPE %s AS ENUM(%s);", typeName, enumValues);
	}

	private String getCommaSeparatedEnumValues(EnumGeneratorArgsWrapper args) throws IOException {
		return getEnumValues(args).stream()
			.map(String::toUpperCase)
			.map(enumAsString -> "'" + enumAsString + "'")
			.collect(Collectors.joining(", "));
	}

}
