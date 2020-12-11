package packages;

import java.util.Objects;


public class Phone {
    public static final String VALIDATION_REGEX = "[\\p{Digit}]+";
    public static final String MESSAGE = "Please enter your Singapore phone number and check it properly";

    private int number;

    public Phone(int number) {
        this.number = number;
    }

    public static boolean isValidPhoneNumber(String args) {
        return args.matches(VALIDATION_REGEX) && args.length() == 8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number == phone.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
