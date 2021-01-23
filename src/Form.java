public class Form {
    private int idForm;
    private String type;
    private int multiUse;
    private int idProject;
    private int idWarehouse;
    public Form(){ }

    public Form(int idForm, String type, int multiUse) {
        this.setIdForm(idForm);
        this.setType(type);
        this.setMultiUse(multiUse);
    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMultiUse() {
        return multiUse;
    }

    public void setMultiUse(int multiUse) {
        this.multiUse = multiUse;
    }

    public void formList(){
        System.out.println("Id: " + idForm +" | typ: " + type + " | ilość użyć : " + multiUse );
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProj) {
        this.idProject = idProject;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }
}
