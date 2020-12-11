package packages;

public class DonorParser {
    public static Name parseName(String args) throws ParseException {
        String trimmedName = args.trim();

        if(!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE);
        }
        return new Name(trimmedName);
    }

    public static Nric parseNric(String args) throws ParseException{
        String trimmedNric = args.trim();

        if(!Nric.isValidNric(trimmedNric)) {
            throw new ParseException(Name.MESSAGE);
        }
        return new Nric(trimmedNric);
    }
    public static Phone parsePhone(String args) throws ParseException{
        String trimmedPhoneNumber = args.trim();

        if(!Phone.isValidPhoneNumber(trimmedPhoneNumber)) {
            throw new ParseException(Phone.MESSAGE);
        }

        int phoneNumber = Integer.parseInt(trimmedPhoneNumber);
        return new Phone(phoneNumber);
    }

}
