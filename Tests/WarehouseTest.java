import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void getIdWarehouse() {
        Warehouse warehouse1 = new Warehouse(1,1,1,1000);
        assertEquals(1, warehouse1.getIdWarehouse());
    }

    @Test
    void setIdWarehouse() {
        Warehouse warehouse1 = new Warehouse(1,1,1,1000);
        warehouse1.setIdWarehouse(2);
        assertEquals(2, warehouse1.getIdWarehouse());
    }

    @Test
    void getCastAmount() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        assertEquals(41, warehouse1.getCastAmount());
    }

    @Test
    void setCastAmount() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        warehouse1.setCastAmount(56);
        assertEquals(56, warehouse1.getCastAmount());
    }

    @Test
    void getMaterials() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        assertEquals(71, warehouse1.getMaterials());
    }

    @Test
    void setMaterials() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        warehouse1.setMaterials(65);
        assertEquals(65, warehouse1.getMaterials());
    }

    @Test
    void getCapacity() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        assertEquals(1000, warehouse1.getCapacity());
    }

    @Test
    void setCapacity() {
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        warehouse1.setCapacity(5600);
        assertEquals(5600, warehouse1.getCapacity());
    }
}