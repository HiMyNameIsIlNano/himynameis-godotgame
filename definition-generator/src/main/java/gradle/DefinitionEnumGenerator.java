package gradle;

import java.util.Arrays;

public class DefinitionEnumGenerator {

    private static final int ARGS_AMOUNT = 6;

    public static void main(String[] args) {
        validateArgs(args);

        for (int i = 0; i < args.length; i = getNextIndex(args)) {
            EnumGeneratorArgsWrapper wrapper = buildArgsWrapper(args);

            new JavaEnumGenerator().generateEnums(wrapper);

            if (wrapper.isUpdateDbEnum()) {
                new DbEnumGenerator().generateEnums(wrapper);
            }

            String debugMessage =
                    String.format("***** Generated enum from: %s ****", wrapper.getInputFile());
            System.out.println(debugMessage);
        }
    }

    private static int getNextIndex(String[] args) {
        boolean hasOptionalParameters = hasOptionalParameter(args);
        if (hasOptionalParameters) {
            return 2 * ARGS_AMOUNT + 1;
        }

        return 2 * (ARGS_AMOUNT - 1);
    }

    private static void validateArgs(String[] args) {
        checkArgsLength(args);
        validateNotDuplicatedArgs(args);
    }

    private static void checkArgsLength(String[] args) {
        boolean isGenerateDbEnumActive = hasOptionalParameter(args);
        if (isGenerateDbEnumActive) {
            if (!validParametersWithOptional(args)) {
                throw new IllegalArgumentException("Invalid number of input parameters.");
            }
        } else {
            if (!validParameters(args)) {
                throw new IllegalArgumentException("Invalid number of input parameters.");
            }
        }
    }

    private static boolean hasOptionalParameter(String[] args) {
        return Arrays.stream(args).anyMatch("--updateDbEnum"::equalsIgnoreCase);
    }

    private static boolean validParametersWithOptional(String[] args) {
        return args.length % (2 * ARGS_AMOUNT + 1) == 0;
    }

    private static boolean validParameters(String[] args) {
        return args.length % (2 * ARGS_AMOUNT - 2) == 0;
    }

    private static void validateNotDuplicatedArgs(String[] args) {
        long countWithoutDuplicates = Arrays.stream(args).distinct().count();

        if (countWithoutDuplicates != args.length) {
            throw new IllegalArgumentException("Duplicated input parameters.");
        }
    }

    private static EnumGeneratorArgsWrapper buildArgsWrapper(String[] args) {
        EnumGeneratorArgsWrapper wrapper = new EnumGeneratorArgsWrapper();
        int index = 0;
        while (index < args.length) {
            switch (args[index]) {
                case "--inputFileDirectory":
                    wrapper.setInputFileDirectory(args[index + 1]);
                    index = index + 2;
                    break;
                case "--inputFile":
                    wrapper.setInputFile(args[index + 1]);
                    index = index + 2;
                    break;
                case "--outputClassName":
                    wrapper.setOutputClassName(args[index + 1]);
                    index = index + 2;
                    break;
                case "--outputDomain":
                    wrapper.setOutputDomain(args[index + 1]);
                    index = index + 2;
                    break;
                case "--filterFunction":
                    wrapper.setFilterFunction(args[index + 1]);
                    index = index + 2;
                    break;
                case "--updateDbEnum":
                    wrapper.setUpdateDbEnum(true);
                    index = index + 1;
                    break;
                case "--dbEnumOutputFolder":
                    wrapper.setDbEnumOutputFolder(args[index + 1]);
                    index = index + 2;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + args[index]);
            }
        }

        return wrapper;
    }
}
