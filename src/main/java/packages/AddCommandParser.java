package packages;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AddCommandParser {

    public AddCommand parse(String args) throws ParseException {
        System.out.println(args);
        int[] startPositions = startPos(args.trim(), DonorCliSyntax.PREFIX_NAME, DonorCliSyntax.PREFIX_NRIC,
                DonorCliSyntax.PREFIX_PHONE);
        if (startPositions.length < 3) {
            System.out.println(startPositions.length);
            throw new ParseException(Messages.INVALID_SYNTAX);
        }

        int[] endPositions = endPos(args.trim(), DonorCliSyntax.PREFIX_NAME, DonorCliSyntax.PREFIX_NRIC,
                DonorCliSyntax.PREFIX_PHONE);

        Pair[] indexPositions = indexPos(startPositions, endPositions);
        String[] argsSplit = arguments(3, args.trim(), endPositions, startPositions);

        for(String s: argsSplit) {
            System.out.println(s);
        }

        Name name = DonorParser.parseName(argsSplit[0]);
        Nric nric = DonorParser.parseNric(argsSplit[1]);
        Phone phone = DonorParser.parsePhone(argsSplit[2]);

        Donor donor = new Donor(name, nric, phone);
        return new AddCommand(donor);
    }

    private String[] arguments(int length, String args, int[] startPos, int[] endPos) {
        String[] arguments = new String[length];
        for (int i = 0; i < length - 1; i++) {
            arguments[i] = args.substring(startPos[i], endPos[i + 1]);
        }
        arguments[length - 1] = args.substring(startPos[length - 1]);
        return arguments;
    }
    private int[] endPos(String args, String... prefixes) {
        return Stream.of(prefixes).filter(args::contains).
                mapToInt(prefix -> args.indexOf(prefix) + prefix.length()).toArray();
    }

    private int[] startPos(String args, String... prefixes) {
        return Stream.of(prefixes).mapToInt(prefix -> {
            System.out.println(prefix);
            return args.indexOf(prefix);
        }).filter(val -> val != -1).toArray();
    }

    private Pair[] indexPos(int[] startPos, int[] endPos) {
        return IntStream.of(startPos).boxed().
                flatMap(start -> IntStream.of(endPos).boxed().map(end -> new Pair(start, end)).limit(1))
                .toArray(Pair[]::new);
    }

    private void startPos(int... num) {
        int[] y = new int[5];
        Stream<Pair> xs = IntStream.of(num).boxed().
                flatMap(x -> IntStream.of(y).boxed().map(z -> new Pair(x, z)).limit(1));
    }
    public class Pair {
        public int first;
        public int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

}
