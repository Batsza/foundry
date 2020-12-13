import java.util.Scanner;

public class CastWorker extends Worker {
    int numberOfProject = 0;
    int numberOfCast = 0;
    Project[] proj = new Project[5];
    Cast[] cast = new Cast[5];
   public void  addNewCasting(){
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
       numberOfCast++;
    }
    public void showCastList(){
        for(int i = 1; i < numberOfCast+1; i++) {
            System.out.println("Project ");
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
        if(numberOfProject == 0){
            for(int i = numberOfProject; i < proj.length; i++) {
                proj[i] = new Project();
            }
        }
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj id projectu: ");
        Integer a = scan.nextInt();
        proj[numberOfProject].setIdProject(a);
        System.out.print("Podaj wage: ");
        Integer b = scan.nextInt();
        proj[numberOfProject].setWeight(b);
        System.out.print("Podaj wielkosc: ");
        Integer c = scan.nextInt();
        proj[numberOfProject].setSize(c);
        System.out.print("Podaj opis projektu: ");
        String d = scan.next();
        proj[numberOfProject].setProjectDetails(d);
        System.out.print("Podaj opis projektu: ");
        String e = scan.next();
        proj[numberOfProject].setFormDetails(e);
        numberOfProject++;
    }
/*
    public requestMaterials(){

    }

    public changeQuality(){

    }*/
}

