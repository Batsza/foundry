public class Cast extends Project {
    private int idCast;
    private String status;
    private int amount;
    private String quality;
    private int idWarehouse;
    private int idProject;

    public Cast(){}

    public Cast(int idCast, String status, int amount, String quality, int idMaterial, int idWarehouse,int idProject){
        this.setIdCast(idCast);
        this.setStatus(status);
        this.setAmount(amount);
        this.setQuality(quality);
        this.setIdMaterial(idMaterial);
        this.setIdWarehouse(idWarehouse);
        this.setIdProject(idProject);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setIdCast(int idCast) {
        this.idCast = idCast;
    }

    public void setIdMaterial(int idMaterial){this.idMaterial = idMaterial;}

    public int getIdMaterial(){return idMaterial;}

    public int getIdCast() {
        return idCast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String castList(){
        return ("ID: " + idCast + " | ilość: " + amount + " | status: " + status + " | ID materiału: "+ idMaterial + " | ID magazynu: " + idWarehouse + " | jakość: " + quality + "\n");
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProj) {
        this.idProject = idProj;
    }
}
