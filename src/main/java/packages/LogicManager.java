package packages;

import javafx.collections.transformation.FilteredList;

public class LogicManager implements Logic {
    //private ModelManager model;
    private MainParser mainParser;
    private Model model;

    public LogicManager(Model model) {
        this.model = model;
        this.mainParser = new MainParser();
    }

    public String execute(String input) throws ParseException, CommandException {
        Command command = mainParser.parser(input);
        return command.execute(model);
    }

    public FilteredList<Donor> getDonorsList() {
        return model.getDonorsList();
    }
}
