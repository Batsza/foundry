import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastTest {

    @Test
    void getAmount() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertEquals(13, cast1.getAmount());
    }

    @Test
    void setAmount() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setAmount(20);
        assertEquals(20, cast1.getAmount());
    }

    @Test
    void getIdCast() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertEquals(1, cast1.getIdCast());
    }
    @Test
    void setIdCast() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setIdCast(2);
        assertEquals(2, cast1.getIdCast());
    }
    @Test
    void getIdMaterial() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertEquals(1, cast1.getIdMaterial());
    }
    @Test
    void setIdMaterial() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setIdMaterial(2);
        assertEquals(2, cast1.getIdMaterial());
    }


    @Test
    void getStatus() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertEquals("ok", cast1.getStatus());
    }

    @Test
    void setStatus() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setStatus("testowany");
        assertEquals("testowany", cast1.getStatus());
    }

    @Test
    void isQuality() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertTrue(cast1.getQuality());

    }

    @Test
    void setQuality() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setQuality(false);
        assertFalse(cast1.getQuality());
    }

    @Test
    void getIdWarehouse() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);

        assertEquals(1, cast1.getIdWarehouse());
    }

    @Test
    void setIdWarehouse() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setIdWarehouse(2);
        assertEquals(2, cast1.getIdWarehouse());
    }

    @Test
    void getIdProj() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        assertEquals(1, cast1.getIdProj());
    }

    @Test
    void setIdProj() {
        Cast cast1 = new Cast(1,"ok",13,true,1,1,1);
        cast1.setIdProj(2);
        assertEquals(2, cast1.getIdProj());
    }


}