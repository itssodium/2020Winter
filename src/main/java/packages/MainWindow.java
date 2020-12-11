package packages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private LogicManager logicManager;
    private DonorListPanel donorListPanel;

    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private TextArea textArea;

    public MainWindow(LogicManager logicManager) {
        this.logicManager = logicManager;
    }
    @Override
    public void start(Stage stage) {
        donorListPanel = new DonorListPanel(logicManager.getDonorsList());

        userInput = new TextField();
        sendButton = new Button("Send");

        textArea = new TextArea();

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(textArea,
                 userInput,
                 sendButton,
                donorListPanel);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(200);
        stage.setMinWidth(400);

        mainLayout.setPrefSize(400.0, 600.0);

        // You will need to import `javafx.scene.layout.Region` for this.

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        sendButton.setOnMouseClicked((event) -> {
            textArea.setText(output(userInput.getText()));
            userInput.clear();
        });


        userInput.setOnAction((event) -> {
            textArea.setText(output(userInput.getText()));
            userInput.clear();
        });

        //dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

    }

    private String output(String input) {
        try {
            return logicManager.execute(input);
        } catch (ParseException | CommandException exception) {
            return exception.toString();
        }
    }

    public static void main(String[] args) {
        //Application.launch(MainWindow.class, args);
    }
}
