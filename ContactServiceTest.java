package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ContactService class.
 * These tests verify that the service correctly:
 * - Adds contacts with unique IDs
 * - Rejects duplicate contact IDs
 * - Deletes existing contacts
 * - Handles deletion of non-existent contacts safely
 * - Updates individual fields of a contact
 * - Enforces validation rules during updates
 */
public class ContactServiceTest {

    private ContactService service;

    /**
     * Initializes a fresh ContactService before each test.
     */
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    /**
     * Helper method to create a valid sample contact.
     */
    private Contact createSampleContact() {
        return new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
    }

    /**
     * Tests that a contact can be added successfully.
     */
    @Test
    void testAddContact() {
        Contact contact = createSampleContact();
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    /**
     * Tests that adding a contact with a duplicate ID throws an exception.
     */
    @Test
    void testAddDuplicateContactID() {
        Contact contact1 = createSampleContact();
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Oak Road");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    /**
     * Tests that deleting an existing contact removes it from the service.
     */
    @Test
    void testDeleteContact() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    /**
     * Tests that deleting a non-existent contact does not throw an exception.
     */
    @Test
    void testDeleteNonExistentContact() {
        assertDoesNotThrow(() -> service.deleteContact("99999"));
    }

    /**
     * Tests updating the first name of an existing contact.
     */
    @Test
    void testUpdateFirstName() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        service.updateFirstName("12345", "Mike");

        assertEquals("Mike", service.getContact("12345").getFirstName());
    }

    /**
     * Tests updating the last name of an existing contact.
     */
    @Test
    void testUpdateLastName() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        service.updateLastName("12345", "Smith");

        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    /**
     * Tests updating the phone number of an existing contact.
     */
    @Test
    void testUpdatePhone() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    /**
     * Tests updating the address of an existing contact.
     */
    @Test
    void testUpdateAddress() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        service.updateAddress("12345", "456 Oak Road");

        assertEquals("456 Oak Road", service.getContact("12345").getAddress());
    }

    /**
     * Tests that updating a non-existent contact throws an exception.
     */
    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Mike");
        });
    }

    /**
     * Tests that invalid updates (e.g., too-long first name) are rejected.
     */
    @Test
    void testInvalidUpdateFirstName() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("12345", "ThisNameIsTooLong");
        });
    }

    /**
     * Tests that invalid phone updates are rejected.
     */
    @Test
    void testInvalidUpdatePhone() {
        Contact contact = createSampleContact();
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("12345", "123");
        });
    }
}