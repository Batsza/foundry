import java.util.Scanner;

public class Manager extends Worker {

    int numberOfWorker = 0;
    Worker[] worker = new Worker[5];



    protected void addWorker() {
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id pracownika: ");
        Integer a = scan.nextInt();
        System.out.print("Podaj sekcje pracownika: ");
        Integer b = scan.nextInt();
        worker[numberOfWorker].setData(a, b);
        numberOfWorker++;
        //worker[numberOfWorker-1].workerList();
    }

    public void showWorkersList(){
        for(int i = 1; i < numberOfWorker+1; i++) {
            System.out.println("Pracownik nr: " + i);
            worker[i-1].workerList();
        }
    }

    protected void deleteWorker(){

    }
}
