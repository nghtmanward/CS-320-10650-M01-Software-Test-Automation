package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Contact class.
 * These tests verify that:
 * - Valid Contact objects are created successfully
 * - All validation rules are enforced (null checks, length limits, digit-only phone)
 * - Setter methods correctly update fields and enforce validation
 */
public class ContactTest {

    /**
     * Tests that a valid Contact object is created with all fields set correctly.
     */
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    /**
     * Tests that a null contact ID triggers validation failure.
     */
    @Test
    void testNullContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a contact ID longer than 10 characters is rejected.
     */
    @Test
    void testLongContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a null first name is rejected.
     */
    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a first name longer than 10 characters is rejected.
     */
    @Test
    void testLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnathanLong", "Doe", "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a null last name is rejected.
     */
    @Test
    void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a last name longer than 10 characters is rejected.
     */
    @Test
    void testLongLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeTheThirdLong", "1234567890", "123 Main Street");
        });
    }

    /**
     * Tests that a null phone number is rejected.
     */
    @Test
    void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main Street");
        });
    }

    /**
     * Tests that a phone number with incorrect length is rejected.
     */
    @Test
    void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main Street");
        });
    }

    /**
     * Tests that a phone number containing non-digit characters is rejected.
     */
    @Test
    void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345abcde", "123 Main Street");
        });
    }

    /**
     * Tests that a null address is rejected.
     */
    @Test
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    /**
     * Tests that an address longer than 30 characters is rejected.
     */
    @Test
    void testLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890",
                    "1234567890123456789012345678901"); // 31 chars
        });
    }

    /**
     * Tests that the first name setter updates the value correctly.
     */
    @Test
    void testSetFirstName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        contact.setFirstName("Mike");
        assertEquals("Mike", contact.getFirstName());
    }

    /**
     * Tests that the first name setter enforces validation rules.
     */
    @Test
    void testSetInvalidFirstName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThisNameIsTooLong");
        });
    }

    /**
     * Tests that the phone setter updates the value correctly.
     */
    @Test
    void testSetPhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    /**
     * Tests that the phone setter enforces validation rules.
     */
    @Test
    void testSetInvalidPhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("abc123");
        });
    }
}