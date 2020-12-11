package packages;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "adddonor";
    public static final String PERSON_ALREADY_EXISTS = "This packages.donor has already donated blood, do not register him/her "
            + "again";

    public static final String SUCCESS_MESSAGE = "%s has successfully been registered to donate blood";

    private Donor donor;

    public AddCommand(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String execute(Model model) throws CommandException {
        if (model.hasSamePerson(donor)) {
            throw new CommandException(PERSON_ALREADY_EXISTS);
        }
        model.addDonor(donor);
        return String.format(SUCCESS_MESSAGE, donor);
    }

}
