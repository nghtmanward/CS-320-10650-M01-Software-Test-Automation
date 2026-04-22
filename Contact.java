package contact;

/**
 * The Contact class represents a single contact record.
 * This class enforces all required constraints for each field:
 * - contactID: cannot be null, max length 10, not updatable
 * - firstName: cannot be null, max length 10
 * - lastName: cannot be null, max length 10
 * - phone: cannot be null, must be exactly 10 digits
 * - address: cannot be null, max length 30
 *
 * Validation occurs in the constructor and setter methods to ensure
 * data integrity throughout the lifecycle of the Contact object.
 */
public class Contact {

    // Unique identifier for the contact (immutable after creation)
    private final String contactID;

    // Updatable contact fields with validation rules
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor initializes a new Contact object.
     * All fields are validated according to project requirements.
     */
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {

        // Validate contactID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone (must be exactly 10 digits)
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods for accessing contact fields
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Setter methods update individual fields.
     * Each setter re-validates input to maintain data integrity.
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}