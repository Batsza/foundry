import java.util.Scanner;

public class Manager extends Worker {



    protected static void addWorker() {
        Worker[] worker = new Worker[1];
        for(int i=0; i<worker.length; i++)
            worker[i] = new Worker();
        //Worker worker = new Worker();
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id pracownika: ");
        Integer a = scan.nextInt();
        System.out.print("Podaj sekcje pracownika: ");
        Integer b = scan.nextInt();
        System.out.println(a + " " + b);
        worker[0].setData(a, b);
        worker[0].wyswietlzawartosctablicy();
    }

    protected void deleteWorker(){

    }


}
