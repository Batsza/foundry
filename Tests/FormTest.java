import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormTest {

    @Test
    void getIdForm() {
        Form form = new Form(1, "sand", 1, 1);
        assertEquals(1, form.getIdForm());
    }

    @Test
    void setIdForm() {
        Form form = new Form(1, "sand", 1, 1);
        form.setIdForm(2);
        assertEquals(2, form.getIdForm());
    }

    @Test
    void getType() {
        Form form = new Form(1, "sand", 1, 1);
        assertEquals("sand", form.getType());
    }

    @Test
    void setType() {
        Form form = new Form(1, "sand", 1, 1);
        form.setType("metal");
        assertEquals("metal", form.getType());
    }

    @Test
    void getMultiUse() {
        Form form = new Form(1, "sand", 1000, 1);
        assertEquals(1000, form.getMultiUse());

    }

    @Test
    void setMultiUse() {
        Form form = new Form(1, "sand", 1, 1);
        form.setMultiUse(200);
        assertEquals(200, form.getMultiUse());
    }


}