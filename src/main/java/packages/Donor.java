package packages;

public class Donor {
    private Name name;
    private Nric nric;
    private Phone phone;
    private boolean isProcessed;
    private boolean isApproved;


    public Donor(Name name, Nric nric, Phone phone) {
        this.name = name;
        this.nric = nric;
        this.phone = phone;
        this.isProcessed = false;
        this.isApproved = false;
    }

    public boolean isSamePerson(Donor donor) {
        return nric.equals(donor.nric) || phone.equals(donor.phone);
    }

    @Override
    public String toString() {
        return name + " with NRIC of " + nric + " and contact number of " + phone;
    }

    public Name getName() {
        return name;
    }

    public Nric getNric() {
        return nric;
    }

    public Phone getPhone() {
        return phone;
    }
}
