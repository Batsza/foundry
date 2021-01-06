import java.util.Scanner;

public class CastWorker extends Worker {
    int numberOfProject = 1; //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
    int numberOfCast = 1; //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0


    public void  addNewCasting(){
        System.out.println( "warehousee0"+warehouseXD[0]);
        if(numberOfCast == 1){ //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
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
        /*
        for(int i = 0; i < numberOfProject; i++) {
             if(proj[i].getIdProject() == e){
                 cast[numberOfCast].setIdMaterial(proj[i].getIdMaterial());
             };
        }*/
        System.out.print("Podaj id magazynu: ");
        int f = scan.nextInt();
        cast[numberOfCast].setIdWarehouse(f);

                if(!calculateWarehouseCapacity(cast[numberOfCast],warehouseXD[f-1])){
                    System.out.print("zamala pojemnosc");
                }




        numberOfCast++;
    }
    public void showCastList(){
        for(int i = 1; i < numberOfCast+1; i++) {
            System.out.println("Cast ");
            cast[i-1].castList();
        }
    }

    public void showProjectList(){
        for(int i = 1; i < numberOfProject+1; i++) {
            System.out.println("Project ");
            proj[i-1].projectList();
        }
    }

    public void addNewProject(){
        if(numberOfProject == 1){ //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
            for(int i = numberOfProject; i < proj.length; i++) {
                proj[i] = new Project();
            }
        }
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj id projektu: ");
        Integer a = scan.nextInt();
        proj[numberOfProject].setIdProject(a);
        System.out.print("Podaj wage: ");
        Integer b = scan.nextInt();
        proj[numberOfProject].setWeight(b);
        System.out.print("Podaj wielkosc: ");
        Integer c = scan.nextInt();
        proj[numberOfProject].setSize(c);
        System.out.print("Podaj opis projektu: ");
        scan.nextLine();
        String d = scan.nextLine();
        proj[numberOfProject].setProjectDetails(d);
        System.out.print("Podaj opis formy: ");
        String e = scan.nextLine();
        proj[numberOfProject].setFormDetails(e);
        System.out.println("Podaj id materiału");
        int f = scan.nextInt();
        proj[numberOfProject].setIdMaterial(f);
        numberOfProject++;
    }
/*
    public requestMaterials(){

    }

    public changeQuality(){

    }*/
}

