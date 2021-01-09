import java.util.Scanner;

public class ShippingWorker extends Worker {

    int numberOfTransport = 0;
    Transport[] transports = new Transport[5];

    public void orderTransport(){
        Cast castT = new Cast();
        Warehouse warehouseT = new Warehouse();

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
        transports[numberOfTransport].setAvailableweight(c);
        System.out.print("Podaj id odlewu: ");
        Integer e = scan.nextInt();
        transports[numberOfTransport].setIdCast(e);

        for (int i = 0; i <cast.length; i++){

            if(cast[i].getIdCast()== e && cast[i]!=null ){
                castT = cast[i];
                break;
            }

        }

        for(int i = 0;i <warehouseXD.length; i++){
            if(warehouseXD[i].getIdWarehouse() == castT.getIdWarehouse()) {
                int castVolume = getCastSize(castT) * castT.getAmount();
                int castWeight = getCastWeight(castT) * castT.getAmount();
                if (castVolume <= transports[numberOfTransport].getCapacity()&& castWeight <= transports[numberOfTransport].getCapacity()){
                    warehouseXD[i].setCapacity(warehouseXD[i].getCapacity() + castVolume);
                    warehouseXD[i].setCastAmount(warehouseXD[i].getCastAmount() - castT.getAmount());
                    castT.setStatus("Wysłano");
                    for (int j = 0; j < cast.length; j++){
                        if(cast[j].getIdCast()== e ){
                            cast[j] = castT;
                        }

                    }
                    transports[numberOfTransport].setStatus(true);
                }
                else {
                    transports[numberOfTransport].setStatus(false);
                }
                    break;
            }

        }

        numberOfTransport++;
        //if(calculateWarehouseCapacityT(castT,)){}
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

