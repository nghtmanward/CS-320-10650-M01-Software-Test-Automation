package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * The ContactService class manages Contact objects in memory.
 * It provides functionality to:
 * - Add new contacts (must have unique contact IDs)
 * - Delete existing contacts
 * - Update individual fields of a contact
 *
 * Contacts are stored in a HashMap using the contactID as the key.
 * This ensures fast lookup, update, and deletion operations.
 */
public class ContactService {

    // Stores contacts using contactID as the unique key
    private Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     * Throws an exception if:
     * - The contact is null
     * - The contactID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactID = contact.getContactID();

        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactID, contact);
    }

    /**
     * Deletes a contact by ID.
     * If the ID does not exist, nothing happens.
     */
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    /**
     * Updates the first name of an existing contact.
     * Throws an exception if the contact does not exist.
     */
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of an existing contact.
     * Throws an exception if the contact does not exist.
     */
    public void updateLastName(String contactID, String newLastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of an existing contact.
     * Throws an exception if the contact does not exist.
     */
    public void updatePhone(String contactID, String newPhone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setPhone(newPhone);
    }

    /**
     * Updates the address of an existing contact.
     * Throws an exception if the contact does not exist.
     */
    public void updateAddress(String contactID, String newAddress) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setAddress(newAddress);
    }

    /**
     * Optional helper method used for testing.
     * Returns the Contact object associated with the given ID.
     */
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}