import java.util.Scanner;

public class Manager extends Worker {

    int numberOfWorker = 0;
    Worker[] worker = new Worker[5];

    Scanner scan = new Scanner(System.in);

    protected void addWorker() {
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }

        System.out.print("Podaj id pracownika: ");
        Integer a = scan.nextInt();
        worker[numberOfWorker].setIdWorker(a);
        System.out.print("Podaj sekcje pracownika: ");
        Integer b = scan.nextInt();
        worker[numberOfWorker].setSection(b);
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
        System.out.print("Podaj id pracownika: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfWorker; i++) {
            if(worker[i].getIdWorker() == c){
                worker[i] = new Worker();
                System.out.println("Pracownik o id: " + c + " został usunięty");
            }
        }
        repairArrayObject();
        showWorkersList();
    }

    void repairArrayObject(){
        for(int i = 0; i < numberOfWorker; i++) {
            if(worker[i].getIdWorker() == 0){
                if((i+1) < numberOfWorker){
                    for(int j = i; j < numberOfWorker; j++){
                        worker[j].setIdWorker(worker[j+1].getIdWorker());
                        worker[j].setSection(worker[j+1].getSection());
                    }
                }
            }
        }
    }
}
