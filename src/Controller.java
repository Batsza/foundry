import javafx.fxml.FXML;


import java.awt.*;
import java.sql.SQLException;
import javafx.scene.control.TextArea;

public class Controller {
   Manager manager = new Manager();
   LogisticWorker lworker = new LogisticWorker();
   ShippingWorker sworker = new ShippingWorker();
   CastWorker cworker = new CastWorker();
   public void addWorkerButtonHandler() throws SQLException, ClassNotFoundException {
      manager.addWorker();

   }
   public void deleteWorkerButtonHandler(){

   }
   @FXML

   private TextArea textArea;
   public void showWorkerButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      manager.loadWorker();

      textArea.setText(manager.showWorkersList());
   }
   public void addMaterialButtonHandler(){}
   public void deleteMaterialButtonHandler(){}
   public void showMaterialButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      lworker.loadMaterial();
      textArea.setText(lworker.showMaterialList());
   }
   public void addProjectButtonHandler(){}
   public void deleteProjectButtonHandler(){}
   public void showProjectButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      cworker.loadProject();
      textArea.setText(cworker.showProjectList());
   }
   public void addFormButtonHandler(){}
   public void deleteFormButtonHandler(){}
   public void showFormButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      cworker.loadForm();
      textArea.setText(cworker.showFormList());
   }
   public void addCastButtonHandler(){}
   public void deleteCastButton(){}
   public void showCastButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      cworker.loadCast();
      textArea.setText(cworker.showCastList());
   }
   public void addWarehouseButtonHandler(){}
   public void deleteWarehouseButtonHandler(){}
   public void showWarehouseButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      lworker.loadWarehouse();
      textArea.setText(lworker.showWarehouseList());
   }
   public void addTransportButtonHandler(){}
   public void showTransportButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      sworker.loadTransport();
      textArea.setText(sworker.showTransportList());
   }

}
