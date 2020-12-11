package packages;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class DonorListPanel extends AnchorPane {
    private ObservableList<Donor> donorObservableList;

    private ListView<Donor> listView;

    public DonorListPanel(ObservableList<Donor> donorObservableList) {
        listView = new ListView<>(donorObservableList);
        updateDonorInfo(donorObservableList);
        listView.setItems(donorObservableList);
    }

    private void updateDonorInfo(ObservableList<Donor> donorObservableList) {
        System.out.println(2);
        donorObservableList.addListener(new ListChangeListener<Donor>() {
            @Override
            public void onChanged(Change<? extends Donor> change) {
                while(change.next()) {
                    System.out.println(3);
                    if (change.wasAdded()) {
                        System.out.println(4);
                        int indexToChange = change.getFrom();
                        Donor donorToDisplay = change.getList().get(indexToChange);
                        System.out.println(donorToDisplay);
                        listView.scrollTo(indexToChange);
                        listView.getSelectionModel().select(indexToChange);
                        listView.getFocusModel().focus(indexToChange);
                        //patientDetailsPanel = new PatientDetailsPanel(patientToDisplay);
                    }
                }
            }
        });
    }

    class DonorListViewCell extends ListCell<Donor> {
        @Override
        protected void updateItem(Donor donor, boolean empty) {
            System.out.println(10);
            super.updateItem(donor, empty);

            if (empty || donor == null) {
                setGraphic(null);
                setText(null);
            } else {
                System.out.println(donor);
                setGraphic(new DonorCard(donor));
            }
        }
    }
}
