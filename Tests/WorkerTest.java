import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void getIdWorker() {
        Worker worker =  new Worker(1,2 );
        assertEquals(1, worker.getIdWorker());
    }

    @Test
    void setIdWorker() {
        Worker worker =  new Worker(1,2 );
        worker.setIdWorker(3);
        assertEquals(3, worker.getIdWorker());
    }

    @Test
    void getSection() {
        Worker worker =  new Worker(1,2 );
        assertEquals(2, worker.getSection());
    }

    @Test
    void setSection() {
        Worker worker =  new Worker(1,2 );
        worker.setSection(4);
        assertEquals(4, worker.getSection());
    }

    @Test
    void getCastSize() {
        Cast cast1 = new Cast(1, "ok", 13, true, 1, 1, 1);
        Project project1 = new Project(1, "opis projektu", "opis formy", 10, 20, 1);
        Worker.cast[0]= cast1;
        Worker.project[0] = project1;
        assertEquals(20, Worker.getCastSize(cast1));
    }

    @Test
    void calculateWarehouseCapacityM() {
        Material material = new Material(1, "gold", 10, 10, 1, 1 );
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        assertTrue(Worker.calculateWarehouseCapacityM(material,warehouse1));

    }

    @Test
    void calculateWarehouseCapacity() {
        Cast cast1 = new Cast(1, "ok", 13, true, 1, 1, 1);
        Project project1 = new Project(1, "opis projektu", "opis formy", 10, 20, 1);
        Worker.cast[0]= cast1;
        Worker.project[0] = project1;
        Warehouse warehouse1 = new Warehouse(1,41,71,1000);
        assertTrue(Worker.calculateWarehouseCapacity(cast1,warehouse1));
    }

    @Test
    void getCastWeight() {
        Cast cast1 = new Cast(1, "ok", 13, true, 1, 1, 1);
        Project project1 = new Project(1, "opis projektu", "opis formy", 10, 20, 1);
        Worker.cast[0]= cast1;
        Worker.project[0] = project1;
        assertEquals(10, Worker.getCastWeight(cast1));
    }
}

