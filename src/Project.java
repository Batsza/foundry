
public class Project {
    private int idProject;
    private String projectDetails;
    private String formDetails;
    public int weight;
    private int size;
    protected int idMaterial;
    public Project(){}

    public Project(int idProj, String descProj, String descForm, int weight, int size, int idMaterial){
        this.setIdProject(idProj);
        this.setProjectDetails(descProj);
        this.setFormDetails(descForm);
        this.setWeight(weight);
        this.setSize(size);
        this.setIdMaterial(idMaterial);
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getFormDetails() {
        return formDetails;
    }

    public void setFormDetails(String formDetails) {
        this.formDetails = formDetails;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String projectList(){
        return("Id: " + idProject + " | Waga: " + weight + " | wielkosc: " + size + " | proj det: " + projectDetails + " | form det: " + formDetails + " | id materiału "+idMaterial + "\n");
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
/*
    public showProjectInformations(){

    }

    public static findProject(){

    }*/
}

