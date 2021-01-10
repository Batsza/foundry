import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void getIdTransport() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        assertEquals(1 , transport.getIdTransport());
    }

    @Test
    void setIdTransport() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        transport.setIdTransport(2);
        assertEquals(2 , transport.getIdTransport());

    }

    @Test
    void getCapacity() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        assertEquals(1000 , transport.getCapacity());
    }

    @Test
    void setCapacity() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        transport.setCapacity(999);
        assertEquals(999 , transport.getCapacity());
    }

    @Test
    void getAvailableweight() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        assertEquals(500 , transport.getAvailableweight());
    }

    @Test
    void setAvailableweight() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        transport.setAvailableweight(666);
        assertEquals(666 , transport.getAvailableweight());
    }

    @Test
    void getIdCast() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        assertEquals(2 , transport.getIdCast());
    }

    @Test
    void setIdCast() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        transport.setIdCast(32);
        assertEquals(32 , transport.getIdCast());
    }

    @Test
    void isStatus() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        assertTrue(transport.isStatus());
    }

    @Test
    void setStatus() {
        Transport transport  = new Transport(1, 1000, 500, 2, true);
        transport.setStatus(false);
        assertFalse(transport.isStatus());
    }
}