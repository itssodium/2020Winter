package packages;

import java.util.Objects;

public class Name {
    public static final String VALIDATION_REGEX = "[[\\p{Alpha}]+[\\p{Space}]]+";
    public static final String MESSAGE = "Name can only contain letters and space!";

    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.toLowerCase().equals(name1.name.toLowerCase());
    }

    public static boolean isValidName(String nameToCheck) {
        return nameToCheck.matches(VALIDATION_REGEX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
