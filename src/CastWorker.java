import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CastWorker extends Worker {
    int numberOfProject = 0;
    int numberOfCast = 0;
    int numberOfForm = 0;

    Scanner scan = new Scanner(System.in);

    public void  addNewCasting(){
        Warehouse warehouseT = new Warehouse();
        if(numberOfCast == 0){
        for(int i = numberOfCast; i < cast.length; i++) {
            cast[i] = new Cast();
        }
    }
    Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id odlewu: ");
        Integer a = scan.nextInt();
        cast[numberOfCast].setIdCast(a);
        System.out.print("Podaj ilosc: ");
        Integer b = scan.nextInt();
        cast[numberOfCast].setAmount(b);
        System.out.print("Podaj jakosc: ");
        Boolean c = scan.nextBoolean();
        cast[numberOfCast].setQuality(c);
        System.out.print("Podaj status: ");
        String d = scan.next();
        cast[numberOfCast].setStatus(d);
        System.out.print("Podaj id projektu: ");
        int e = scan.nextInt();
        cast[numberOfCast].setIdProj(e);

        for(int i = 0; i < numberOfProject; i++) {
             if(project[i].getIdProject() == e){
                 cast[numberOfCast].setIdMaterial(project[i].getIdMaterial());
             };
        }
        System.out.print("Podaj id magazynu: ");
        int f = scan.nextInt();
        cast[numberOfCast].setIdWarehouse(f);

        for (int i = 0; i <warehouseXD.length; i++){

            if(warehouseXD[i].getIdWarehouse()== f && warehouseXD[i]!=null ){
                warehouseT = warehouseXD[i];
                break;
            }

        }

        if(!calculateWarehouseCapacity(cast[numberOfCast],warehouseT)) {
            System.out.print("zamala pojemnosc");
        }

        numberOfCast++;
    }

    protected void deleteCast() {
        System.out.print("Podaj id odlewu: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfCast; i++) {
            if(cast[i].getIdCast() == c){
                cast[i] = new Cast();
                System.out.println("Odlew o id: " + c + " został usunięty");
            }
        }

        repairArrayObjectCast();
        showCastList();
    }

    void repairArrayObjectCast(){
        for(int i = 0; i < numberOfCast; i++) {
            if(cast[i].getIdCast() == 0){
                if((i+1) < numberOfCast){
                    for(int j = i; j < numberOfCast; j++){
                        cast[j].setIdCast(cast[j+1].getIdCast());
                        cast[j].setAmount(cast[j+1].getAmount());
                        cast[j].setQuality(cast[j+1].getQuality());
                        cast[j].setStatus(cast[j+1].getStatus());
                        cast[j].setIdProj(cast[j+1].getIdProj());
                        cast[j].setIdWarehouse(cast[j+1].getIdWarehouse());
                    }
                }
            }
        }
    }

    public void showCastList(){
        System.out.println("Lista odlewów: ");
        for(int i = 1; i < numberOfCast+1; i++) {
            if(cast[i-1].getIdCast() > 0) {
                cast[i - 1].castList();
            }
        }
    }

    public void addNewProject(){
        if(numberOfProject == 0){ //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
            for(int i = numberOfProject; i < project.length; i++) {
                project[i] = new Project();
            }
        }
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj id projektu: ");
        Integer a = scan.nextInt();
        project[numberOfProject].setIdProject(a);
        System.out.print("Podaj wage: ");
        Integer b = scan.nextInt();
        project[numberOfProject].setWeight(b);
        System.out.print("Podaj wielkosc: ");
        Integer c = scan.nextInt();
        project[numberOfProject].setSize(c);
        System.out.print("Podaj opis projektu: ");
        scan.nextLine();
        String d = scan.nextLine();
        project[numberOfProject].setProjectDetails(d);
        System.out.print("Podaj opis formy: ");
        String e = scan.nextLine();
        project[numberOfProject].setFormDetails(e);
        System.out.println("Podaj id materiału");
        int f = scan.nextInt();
        project[numberOfProject].setIdMaterial(f);
        numberOfProject++;
    }

    protected void deleteProject() {
        System.out.print("Podaj id projektu: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfProject; i++) {
            if(project[i].getIdProject() == c){
                project[i] = new Project();
                System.out.println("Projekt o id: " + c + " został usunięty");
            }
        }

        repairArrayObjectProject();
        showCastList();
    }

    void repairArrayObjectProject(){
        for(int i = 0; i < numberOfProject; i++) {
            if(project[i].getIdProject() == 0){
                if((i+1) < numberOfCast){
                    for(int j = i; j < numberOfProject; j++){
                        project[j].setIdProject(project[j+1].getIdProject());
                        project[j].setWeight(project[j+1].getWeight());
                        project[j].setSize(project[j+1].getSize());
                        project[j].setProjectDetails(project[j+1].getProjectDetails());
                        project[j].setFormDetails(project[j+1].getFormDetails());
                        project[j].setIdMaterial(project[j+1].getIdMaterial());
                    }
                }
            }
        }
    }

    public void showProjectList(){
        System.out.println("Lista projektów: ");
        for(int i = 1; i < numberOfProject+1; i++) {
            if(project[i-1].getIdProject() > 0) {
                project[i - 1].projectList();
            }
        }
    }

    public void  addNewForm(){
        Warehouse warehouseT = new Warehouse();
        if(numberOfForm == 0){
            for(int i = numberOfForm; i < form.length; i++) {
                form[i] = new Form();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id formy: ");
        Integer a = scan.nextInt();
        form[numberOfForm].setIdForm(a);
        System.out.print("Podaj typ: ");
        String b = scan.next();
        form[numberOfForm].setType(b);
        System.out.print("Podaj możliwość urzyć : ");
        Integer c = scan.nextInt();
        form[numberOfForm].setMultiUse(c);
        System.out.print("Podaj id projektu: ");
        int e = scan.nextInt();
        form[numberOfForm].setIdProj(e);

        numberOfForm++;
    }

    public void showFormList(){
        for(int i = 1; i < numberOfForm+1; i++) {
            System.out.println("Cast ");
            form[i-1].formList();
        }
    }

/*
    public requestMaterials(){

    }

    public changeQuality(){

    }*/
}

