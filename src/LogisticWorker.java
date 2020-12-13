import java.util.Scanner;

public class LogisticWorker extends Worker {
    int numberOfMaterials = 0;
    Material[] material = new Material[100];

    public void  addNewMaterial(){
        if(numberOfMaterials == 0){
            for(int i = numberOfMaterials; i < material.length; i++) {
                material[i] = new Material();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id materiału: ");
        Integer a = scan.nextInt();
        material[numberOfMaterials].setIdMaterial(a);
        System.out.print("Podaj status: ");
        String b = scan.next();
        material[numberOfMaterials].setName(b);
        System.out.print("Podaj wagę: ");
        Integer c = scan.nextInt();
        material[numberOfMaterials].setWeight(c);
        System.out.print("Podaj ilosc: ");
        Integer d = scan.nextInt();
        material[numberOfMaterials].setAmount(d);
        System.out.print("Podaj cenę: ");
        Integer e = scan.nextInt();
        material[numberOfMaterials].setPrice(e);
        numberOfMaterials++;
    }
    public void showMaterialList(){
        System.out.println("Materiały: ");
        for(int i = 1; i < numberOfMaterials+1; i++) {
            material[i-1].materialList();
        }
    }


/*
    public increseMaterial(){

    }

    public changeStorageLocation(){

    }

    public showRequestMaterials(){

    }

    public requestTransport(){

    }

    public addNewWarehouse(){

    }

 */
}

