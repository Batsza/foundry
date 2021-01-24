import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Controller {
   int int1 = 0;
   int int2 =0 ;
   int int3 = 0;
   int int4 =0 ;
   int int5 = 0;
   String text;
   String text2;
   boolean addworker= false;
   boolean subworker= false;
   boolean addmaterial= false;
   boolean submaterial= false;
   boolean addproject= false;
   boolean subproject= false;
   boolean addform= false;
   boolean subform= false;
   boolean addcast= false;
   boolean subcast= false;
   boolean addwarehouse= false;
   boolean subwarehouse= false;
   boolean addtransport= false;
   boolean changelocation= false;
   int submitclick=0;
   boolean lock;
   Manager manager = new Manager();
   LogisticWorker lworker = new LogisticWorker();
   ShippingWorker sworker = new ShippingWorker();
   CastWorker cworker = new CastWorker();
   @FXML
   private TextField inputTextField;
   @FXML
   private TextArea textArea;
   @FXML
   private TextField outputTextField;
   @FXML
   private  Button loginAdminButton, loginCastWorkerButton, loginLogisticWorkerButton,loginShippingWorkerButton;
   public void loginAdminButtonHandler() throws IOException {

     Parent admin = FXMLLoader.load(getClass().getResource("resources/admin.fxml"));
      Stage window = (Stage) loginAdminButton.getScene().getWindow();
      window.setTitle("admin");
      window.setScene(new Scene(admin, 1280, 720));
      window.show();
   }

   public void loginCastWorkerButtonHandler() throws IOException {
      Parent castWorker = FXMLLoader.load(getClass().getResource("resources/castWorker.fxml"));
      Stage window = (Stage) loginCastWorkerButton.getScene().getWindow();
      window.setTitle("castWorker");
      window.setScene(new Scene(castWorker, 1280, 720));
      window.show();
   }

   public void loginLogisticWorkerButtonHandler() throws IOException {
      Parent logisticWorker = FXMLLoader.load(getClass().getResource("resources/logisticWorker.fxml"));
      Stage window = (Stage) loginLogisticWorkerButton.getScene().getWindow();
      window.setTitle("logisticWorker");
      window.setScene(new Scene(logisticWorker, 1280, 720));
      window.show();
   }

   public void loginShippingWorkerButtonHandler() throws IOException {
      Parent shippingWorker = FXMLLoader.load(getClass().getResource("resources/shippingWorker.fxml"));
      Stage window = (Stage) loginShippingWorkerButton.getScene().getWindow();
      window.setTitle("shippingWorker");
      window.setScene(new Scene(shippingWorker, 1280, 720));
      window.show();
   }

   public void submitButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();

      if (addworker) { //add worker
         lock = false;
         if (submitclick == 0) {
            do {
               outputTextField.setText("Podaj sekcje");
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               lock = manager.addworkerLock(int1);
               if(lock){
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Pracownik o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
         } else {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            manager.addWorker(int1, int2);
            textArea.setText("Pomyślnie dodano pracownika o ID: " + int1 + " i sekcji: " + int2);
            submitclick = 0;
            addworker = false;
            lock = false;
            inputTextField.clear();
         }
      }

      if (subworker) {
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = manager.subworkerLock(int1);

         if(lock){
            manager.deleteWorker(int1);
            textArea.setText("Pracownik o ID: " + int1 + " został usunięty");
         } else {
            textArea.setText("Pracownik o podanym ID nie istnieje!");
         }
         subworker = false;
         inputTextField.clear();
         lock = false;
      }

      if(addmaterial){ //add material
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj nazwę");
               lock = lworker.addmaterialLock(int1);
               if(lock){
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Materiał o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         }
         else if (submitclick==1) {
            text = inputTextField.getText();
            outputTextField.setText("Podaj wagę");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 2) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("Podaj ilość");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 3) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("Podaj cenę");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 4) {
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            outputTextField.setText("Podaj ID magazynu");
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int5 = Integer.parseInt(text1);
            lworker.addNewMaterial(int1, text, int2, int3, int4, int5);
            textArea.setText("Pomyślnie  dodano materiał" );
            submitclick = 0;
            addmaterial = false;
            inputTextField.clear();
         }
      }

      if (submaterial) { //delete material
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = lworker.submaterialLock(int1);

         if (lock) {
            lworker.deleteMaterial(int1);
            textArea.setText("Materiał o id: " + int1 + " został usunięty");
         } else {
            textArea.setText("Materiał o podanym ID nie istnieje!");
         }
         submaterial=false;
         inputTextField.clear();
         lock = false;
      }

      if(addproject){ //add project
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj wagę");
               lock = cworker.addprojectLock(int1);
               if(lock){
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Projekt o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 1) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("Podaj wielkość");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 2) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("Podaj szczegóły projektu");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 3) {
            text = inputTextField.getText();
            outputTextField.setText("Podaj szczegóły formy");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 4) {
            text2 = inputTextField.getText();
            outputTextField.setText("Podaj ID magazynu");
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            cworker.addNewProject(int1, int2, int3, text, text2, int4);
            textArea.setText("Pomyślnie dodano projekt" );
            submitclick = 0;
            addproject = false;
            inputTextField.clear();
         }
      }

      if (subproject) { //delete project
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = cworker.subprojectLock(int1);
         if (lock) {
            cworker.deleteProject(int1);
            textArea.setText("Project o ID: " + int1 + " został usunięty");
         } else {
            textArea.setText("Projekt o podanym ID nie istnieje!");
         }
         subproject = false;
         inputTextField.clear();
         lock = false;
      }

      if (addform) { //add form
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj typ");
               lock = cworker.addformLock(int1);
               if(lock){
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Forma o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 1) {
            text = inputTextField.getText();
            outputTextField.setText("Podaj liczbę użyć");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 2) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("Podaj ID magazynu");
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            cworker.addNewForm(int1, text, int2, int3);
            textArea.setText("Pomyślnie dodano formę");
            submitclick = 0;
            addform = false;
            inputTextField.clear();
         }
      }

      if (subform) { //delete form
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = cworker.subformLock(int1);
         if (lock) {
            cworker.deleteForm(int1);
            textArea.setText("Forma o ID: " + int1 + " została usunięta");
         } else {
            textArea.setText("Forma o podanym ID nie istnieje!");
         }
         subform = false;
         inputTextField.clear();
         lock = false;
      }

      if (addcast) { //add cast
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj ilość");
               lock = cworker.addcastLock(int1);
               if (lock) {
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Odlew o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 1) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("Podaj jakość");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 2) {
            text = inputTextField.getText();
            outputTextField.setText("Podaj status");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 3) {
            text2 = inputTextField.getText();
            outputTextField.setText("Podaj ID projektu");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 4) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("podaj id magazynu ");
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            cworker.addNewCasting(int1, int2, text, text2, int3, int4);
            textArea.setText("Pomyślnie  dodano");
            submitclick = 0;
            addcast = false;
            inputTextField.clear();
         }
      }

      if (subcast) { //delete cast
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = cworker.subcastLock(int1);
         if (lock) {
            cworker.deleteCast(int1);
            textArea.setText("Odlew o ID: " + int1 + " został usunięty");
         } else {
            textArea.setText("Odlew o podanym ID nie istnieje!");
         }
         subcast = false;
         inputTextField.clear();
         lock = false;
      }

      if (addwarehouse) { //add warehouse
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj pojemność");
               lock = sworker.addwarehouseLock(int1);
               if (lock) {
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Magazyn o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            lworker.addNewWarehouse(int1, int2);
            textArea.setText("Pomyślnie dodano" + int1 + " " + int2);
            submitclick = 0;
            addwarehouse = false;
            inputTextField.clear();
         }
      }

      if (subwarehouse) { //delete warehouse
         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lock = sworker.subwarehouseLock(int1);
         if (lock) {
            lworker.deleteWarehouse(int1);
            textArea.setText("Pracownik o id: " + int1 + " został usunięty");
         } else {
            textArea.setText("Odlew o podanym ID nie istnieje!");
         }
         subwarehouse=false;
         inputTextField.clear();
         lock = false;
      }

      if (addtransport) { //add transport
         if (submitclick == 0) {
            do {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("Podaj pojemność");
               lock = sworker.addtransportLock(int1);
               if (lock) {
                  inputTextField.clear();
                  break;
               } else {
                  textArea.setText("Transport o podanym ID istnieje");
                  addworker = false;
                  inputTextField.clear();
               }
               inputTextField.clear();
            } while (true);
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 1) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("Podaj wagę");
            submitclick++;
            inputTextField.clear();
         } else if (submitclick == 2) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("Podaj ID odlewu");
            submitclick++;
            inputTextField.clear();
         } else {
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            sworker.orderTransport(int1, int2, int3, int4);
            textArea.setText("Pomyślnie dodano transport" );
            submitclick = 0;
            addtransport = false;
            inputTextField.clear();
         }
      }

      if(changelocation){ // add worker
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj id magazynu");
            submitclick++;
            inputTextField.clear();
         }
         else{

            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            lworker.changeStorageLocation(int1, int2);
            textArea.setText("Pomyślnie zmieniono");
            submitclick = 0;
            changelocation= false;
            inputTextField.clear();
         }

      }
      textArea.setEditable(false);

   }
   public void addWorkerButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.clear();
      outputTextField.setText("podaj id");
      addworker=true;
   }

   public void deleteWorkerButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      subworker=true;
   }

   public void showWorkerButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      manager.loadWorker();

      textArea.setText(manager.showWorkersList());
      textArea.setEditable(false);
   }
   public void addMaterialButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addmaterial=true;
   }
   public void deleteMaterialButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      submaterial=true;
   }
   public void showMaterialButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      lworker.loadMaterial();
      textArea.setText(lworker.showMaterialList());
      textArea.setEditable(false);
   }
   public void addProjectButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addproject=true;
   }
   public void deleteProjectButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      subproject=true;
   }
   public void showProjectButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      cworker.loadProject();
      textArea.setText(cworker.showProjectList());
      textArea.setEditable(false);
   }
   public void addFormButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addform=true;
   }
   public void deleteFormButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      subform=true;
   }
   public void showFormButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      cworker.loadForm();
      textArea.setText(cworker.showFormList());
      textArea.setEditable(false);
   }
   public void addCastButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addcast=true;
   }
   public void deleteCastButton(){
      textArea.clear();
      outputTextField.setText("podaj id");
      subcast=true;
   }
   public void showCastButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      cworker.loadCast();
      textArea.setText(cworker.showCastList());
      textArea.setEditable(false);
   }
   public void addWarehouseButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addwarehouse=true;
   }
   public void deleteWarehouseButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      subwarehouse=true;
   }
   public void showWarehouseButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      lworker.loadWarehouse();
      textArea.setText(lworker.showWarehouseList());
      textArea.setEditable(false);
   }
   public void addTransportButtonHandler(){
      textArea.clear();
      outputTextField.setText("podaj id");
      addtransport=true;
   }
   public void showTransportButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      sworker.loadTransport();
      textArea.setText(sworker.showTransportList());
      textArea.setEditable(false);
   }
   public  void changeLocationHandler(){
      textArea.clear();
      outputTextField.setText("podaj id cast ");
      changelocation=true;
   }
   public void abortButtonHandler(){
      textArea.setEditable(true);
      textArea.clear();
      inputTextField.clear();
      outputTextField.clear();
      textArea.setEditable(false);
      addworker= false;
      subworker= false;
      addmaterial= false;
      submaterial= false;
      addproject= false;
      subproject= false;
      addform= false;
      subform= false;
      addcast= false;
      subcast= false;
      addwarehouse= false;
      subwarehouse= false;
      addtransport= false;
      changelocation= false;
   }

}
