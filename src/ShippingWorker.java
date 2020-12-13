import java.util.Scanner;

public class ShippingWorker extends Worker {

    int numberOfTransport = 0;
    Transport[] transports = new Transport[5];

    public void orderTransport(){
        if(numberOfTransport == 0){
            for(int i = numberOfTransport; i < transports.length; i++) {
                transports[i] = new Transport();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id transportu: ");
        Integer a = scan.nextInt();
        transports[numberOfTransport].setIdTransport(a);
        System.out.print("Podaj pojemnosc: ");
        Integer b = scan.nextInt();
        transports[numberOfTransport].setCapacity(b);
        System.out.print("Podaj wage: ");
        Integer c = scan.nextInt();
        transports[numberOfTransport].setWeight(c);
        numberOfTransport++;

    }

    public void showTransportList(){
        System.out.println("Transport:");
        for(int i = 1; i < numberOfTransport+1; i++) {
            transports[i-1].transportList();
        }
    }
/*
    public showRequestTransport(){

    }*/
}

