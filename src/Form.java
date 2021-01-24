public class Form {
    private int idForm;
    private String type;
    private int multiUse;
    private int idProject;

    public Form(){ }

    public Form(int idForm, String type, int multiUse, int idProject) {
        this.setIdForm(idForm);
        this.setType(type);
        this.setMultiUse(multiUse);
        this.setIdProject(idProject);
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

    public String formList(){
        return ("ID: " + idForm + " | typ formy: " + type + " | ilość użyć: " + multiUse + "\n");
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }


}
