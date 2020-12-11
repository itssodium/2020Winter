package packages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class UniqueDonorRecords {
    private ObservableList<Donor> internalList = FXCollections.observableArrayList();

    public void addDonor(Donor donor) {
        internalList.add(donor);
    }

    public boolean hasSamePerson(Donor donor) {
        return internalList.stream().anyMatch(currDonor -> currDonor.isSamePerson(donor));
    }

    public ObservableList<Donor> getInternalList() {
        return internalList;
    }
}
