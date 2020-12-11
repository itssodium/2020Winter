package packages;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DonorCard extends HBox {
    private Donor donor;

    private Label name;
    private Label nric;
    private Label phone;

    public DonorCard(Donor donor) {
        this.donor = donor;
        setDetails();
    }

    private void setDetails() {
        name = new Label();
        nric = new Label();
        phone = new Label();
        name.setText(donor.getName().toString());
        nric.setText(donor.getNric().toString());
        phone.setText(donor.getPhone().toString());
    }
}
