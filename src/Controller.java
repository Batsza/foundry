import javafx.fxml.FXML;


import java.awt.*;
import java.sql.SQLException;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Controller {
   int int1 = 0;
   int int2 = 0;
   int int3 = 0;
   int int4 = 0;
   int int5 = 0;
   String text;
   String text2;
   boolean addworker = false;
   boolean subworker = false;
   boolean addmaterial = false;
   boolean submaterial = false;
   boolean addproject = false;
   boolean subproject = false;
   boolean addform = false;
   boolean subform = false;
   boolean addcast = false;
   boolean subcast = false;
   boolean addwarehouse = false;
   boolean subwarehouse = false;
   boolean addtransport = false;
   boolean lock;
   int submitclick = 0;
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
         lock = cworker.subprojectLock(int1);
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
      textArea.setEditable(false);
   }

   public void addWorkerButtonHandler() {
      textArea.clear();
      outputTextField.setText("Podaj ID");
      addworker=true;
   }

   public void deleteWorkerButtonHandler() {
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addmaterial=true;
   }

   public void deleteMaterialButtonHandler(){
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addproject=true;
   }

   public void deleteProjectButtonHandler(){
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addform=true;
   }

   public void deleteFormButtonHandler(){
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addcast=true;
   }

   public void deleteCastButton(){
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addwarehouse=true;
   }

   public void deleteWarehouseButtonHandler(){
      textArea.clear();
      outputTextField.setText("Podaj ID");
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
      outputTextField.setText("Podaj ID");
      addtransport=true;
   }

   public void showTransportButtonHandler() throws SQLException, ClassNotFoundException {
      textArea.setEditable(true);
      textArea.clear();
      sworker.loadTransport();
      textArea.setText(sworker.showTransportList());
      textArea.setEditable(false);
   }
}