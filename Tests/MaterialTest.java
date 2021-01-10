import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    @Test
    void getIdMaterial() {
    Material material = new Material(1, "gold", 10, 10, 1, 1 );
    assertEquals(1, material.getIdMaterial());
    }

    @Test
    void setIdMaterial() {
        Material material = new Material(1, "gold", 10, 10, 1, 1 );
        material.setIdMaterial(2);
        assertEquals(2, material.getIdMaterial());
    }

    @Test
    void getName() {
        Material material = new Material(1, "gold", 10, 10, 1, 1 );
        assertEquals("gold", material.getName());
    }

    @Test
    void setName() {
        Material material = new Material(1, "gold", 10, 10, 1, 1 );
        material.setName("aluminium");
        assertEquals("aluminium", material.getName());
    }

    @Test
    void getSize() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );
        assertEquals(10, material.getSize());
    }

    @Test
    void setSize() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );
        material.setSize(200);
        assertEquals(200, material.getSize());
    }

    @Test
    void getAmount() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );

        assertEquals(20, material.getAmount());
    }

    @Test
    void setAmount() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );
        material.setAmount(28);
        assertEquals(28, material.getAmount());
    }

    @Test
    void getPrice() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );

        assertEquals(1, material.getPrice());

    }

    @Test
    void setPrice() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );
        material.setPrice(28);
        assertEquals(28, material.getPrice());
    }


    @Test
    void getIdWarehouse() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );

        assertEquals(1, material.getIdWarehouse());
    }

    @Test
    void setIdWarehouse() {
        Material material = new Material(1, "gold", 10, 20, 1, 1 );
        material.setIdWarehouse(28);
        assertEquals(28, material.getIdWarehouse());
    }
}