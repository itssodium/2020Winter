package packages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainParser {
    public static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<command>\\p{Alpha}+)(?<arguments>.*)");
    public static final String INVALID_COMMAND_FORMAT = "%s inserted is not in the correct format, " +
            "please check user guide again";
    public static final String ERROR_MESSAGE = "%s is not a keyword";
    public static final int INDEX_POS_OF_KEYWORD = 0;

    public Command parser(String input) throws ParseException {
        final String trimmedInput = input.trim();
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(trimmedInput);

        if (!matcher.matches()) {
            throw new ParseException(String.format(INVALID_COMMAND_FORMAT, input));
        }

        final String keyword = matcher.group("command").toLowerCase();
        final String arguments = matcher.group("arguments");

        switch (keyword) {
            case AddCommand.COMMAND_WORD:
                return new AddCommandParser().parse(arguments);
            default:
                throw new ParseException(String.format(ERROR_MESSAGE, keyword));
        }
    }

}
