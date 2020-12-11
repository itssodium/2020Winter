package packages;

import packages.CommandException;
import packages.Model;

public abstract class Command {
    public abstract String execute(Model model) throws CommandException;
}
