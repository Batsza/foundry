import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void getIdProject() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);
        assertEquals(1, project1.getIdProject());
    }

    @Test
    void setIdProject() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);
        project1.setIdProject(2);
        assertEquals(2, project1.getIdProject());
    }

    @Test
    void getProjectDetails() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);
        assertEquals("opis projektu", project1.getProjectDetails());
    }

    @Test
    void setProjectDetails() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);
        project1.setProjectDetails("opis2");
        assertEquals("opis2", project1.getProjectDetails());
    }

    @Test
    void getFormDetails() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);

        assertEquals("opis formy", project1.getFormDetails());
    }

    @Test
    void setFormDetails() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,10,1);
        project1.setFormDetails("opis3");
        assertEquals("opis3", project1.getFormDetails());
    }

    @Test
    void getWeight() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);

        assertEquals(10, project1.getWeight());
    }

    @Test
    void setWeight() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);
        project1.setWeight(30);
        assertEquals(30, project1.getWeight());
    }

    @Test
    void getSize() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);
        assertEquals(20, project1.getSize());
    }

    @Test
    void setSize() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);
        project1.setSize(200);
        assertEquals(200, project1.getSize());
    }

    @Test
    void getIdMaterial() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);

        assertEquals(1, project1.getIdMaterial());
    }

    @Test
    void setIdMaterial() {
        Project project1 = new Project(1,"opis projektu","opis formy",10,20,1);
        project1.setIdMaterial(34);
        assertEquals(34, project1.getIdMaterial());
    }
}