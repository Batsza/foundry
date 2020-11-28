
public class Worker {
    private int idWorker;
    private int warehouse;
    private int cast;
    private String section;

    public void workerList(){

    }

    protected addWorker(){

    }

    protected deleteWorker(){
        
    }
}

class CastWorker extends Worker {
    public addNewCasting(){

    }

    public addNewProject(){

    }

    public requestMaterials(){

    }

    public changeQuality(){

    }
}

class LogisticWorker extends Worker {
    public encreseMaterial(){

    }

    public changeStorageLocation(){

    }

    public showRequestMaterials(){

    }

    public requestTransport(){

    }

    public addNewWarehouse(){

    }
}

class ShippingWorker extends Worker {
    public orderTransport(){

    }

    public showRequestTransport(){

    }
}