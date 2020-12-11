package packages;

import javafx.collections.ObservableList;

public class DonorRecords {
    private final UniqueDonorRecords donors;

    {
        donors = new UniqueDonorRecords();
    }

    public void addDonor(Donor donor) {
        donors.addDonor(donor);
    }

    public boolean hasSamePerson(Donor donor) {
        return donors.hasSamePerson(donor);
    }

    public ObservableList<Donor> getDonorList() {
        return donors.getInternalList();
    }
}
