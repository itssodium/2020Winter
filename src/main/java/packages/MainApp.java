package packages;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    private DonorRecords donorRecords;
    private Model model;
    private LogicManager logicManager;
    MainWindow mainWindow;
    @Override
    public void init() throws Exception {
        super.init();
        donorRecords = new DonorRecords();
        model = new ModelManager(donorRecords);
        logicManager = new LogicManager(model);
        mainWindow = new MainWindow(logicManager);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainWindow.start(stage);
    }
}
