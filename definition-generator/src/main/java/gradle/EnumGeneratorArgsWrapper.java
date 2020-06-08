package gradle;

import lombok.Getter;
import lombok.Setter;

public class EnumGeneratorArgsWrapper {

	static final String LINE_END = ";";
	static final String NEW_LINE = "\n";
	static final String TAB = "\t";

	@Getter
	@Setter
	private String inputFileDirectory;

	@Getter
	@Setter
	private String inputFile;

	@Getter
	@Setter
	private String outputClassName;

	@Getter
	@Setter
	private String outputDomain;

	@Getter
	@Setter
	private String filterFunction;

	@Getter
	@Setter
	private boolean updateDbEnum;

	@Getter
	@Setter
	private String dbEnumOutputFolder;
}
