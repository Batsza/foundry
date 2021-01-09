
public class Cast extends Project {
    private int idCast;
    private String status;
    private int amount;
    private boolean quality;
    private int idWarehouse;
    private int idProj;

    public Cast(){ }
    public Cast(int idCast,String status,int amount,boolean quality, int idMaterial, int idWarehouse,int idProj){
        this.setIdCast(idCast);
        this.setStatus(status);
        this.setAmount(amount);
        this.setQuality(quality);
        this.setIdMaterial(idMaterial);
        this.setIdWarehouse(idWarehouse);
        this.setIdProj(idProj);
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

    public boolean isQuality() {
        return quality;
    }

    public void setQuality(boolean quality) {
        this.quality = quality;
    }

    public void castList(){
        System.out.println("Id: " + idCast);
        System.out.println("ilosc: " + amount);
        System.out.println("status: " + status);
        System.out.println("Id materiału: "+ idMaterial);
        System.out.println("Id magazynu" + idWarehouse);
        if(quality==true)
            System.out.println("jakosc odpowiednia " );
        else
            System.out.println("jakosc nieodpowiednia " );

    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getIdProj() {
        return idProj;
    }

    public void setIdProj(int idProj) {
        this.idProj = idProj;
    }


    /*
    public void setData(int a, int b, int c){
        this.idCast = a;
        this.amount = b;
        this.size =c;

    }
    public void projectList(){
        System.out.println("Id: " + idCast);
        System.out.println("Waga: " + amount);
        System.out.println("wielkosc: " + size);
    }
    public showCastInformations(){

    }

    public static findCast(){

    }*/
}
