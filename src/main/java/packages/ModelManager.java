package packages;

import javafx.collections.transformation.FilteredList;

public class ModelManager implements Model {
    private DonorRecords donorRecords;
    private FilteredList<Donor> donorFilteredList;

    public ModelManager(DonorRecords donorRecords) {
        this.donorRecords = donorRecords;
        donorFilteredList = new FilteredList<>(donorRecords.getDonorList());
    }

    public void addDonor(Donor donor) {
        donorFilteredList.setPredicate(SHOW_ALL_DONORS);
        donorRecords.addDonor(donor);
    }

    public boolean hasSamePerson(Donor donor) {
        return donorRecords.hasSamePerson(donor);
    }

    @Override
    public FilteredList<Donor> getDonorsList() {
        return donorFilteredList;
    }
}
