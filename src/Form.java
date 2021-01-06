public class Form {
    private int idForm;
    private String type;
    private int multiUse;


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

    public void foprmList(){
        System.out.println("Id: " + idForm);
        System.out.println("typ: " + type);
        System.out.println("ilość  użyć : " + multiUse);

    }
}
