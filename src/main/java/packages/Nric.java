package packages;


import java.util.Objects;

public class Nric {
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Digit}]+[\\p{Alnum}]";
    public static final String MESSAGE = "Please enter your NRIC properly";

    public static final int NRIC_LENGTH = 9;

    String nric;

    public Nric(String nric) {
        this.nric = nric;
    }

    public static boolean isValidNric(String nric) {
        return nric.length() == NRIC_LENGTH && nric.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nric nric1 = (Nric) o;
        return Objects.equals(nric, nric1.nric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nric);
    }

    @Override
    public String toString() {
        return nric;
    }
}
