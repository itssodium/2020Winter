package packages;

import java.util.function.Predicate;
import javafx.collections.transformation.FilteredList;

public interface Model {
    public static final Predicate<Donor> SHOW_ALL_DONORS = donor -> true;

    void addDonor(Donor donor);

    boolean hasSamePerson(Donor donor);

    FilteredList<Donor> getDonorsList();
}
