import javafx.fxml.FXML;


import java.awt.*;
import java.sql.SQLException;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
   int submitclick=0;
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

      if(addworker){ // add worker
         if (submitclick==0) {
               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               outputTextField.setText("podaj sekcje");
               submitclick++;
               inputTextField.clear();
            }
            else{

               String text1 = inputTextField.getText();
               int2 = Integer.parseInt(text1);
               manager.addWorker(int1, int2);
               textArea.setText("Pomyślnie dodano" + int1 + " " + int2);
               submitclick = 0;
             addworker= false;
             inputTextField.clear();
         }

      }
         if (subworker){

               String text1 = inputTextField.getText();
               int1 = Integer.parseInt(text1);
               manager.deleteWorker(int1);
               textArea.setText("Pracownik o id: " + int1 + " został usunięty");
               subworker=false;
               inputTextField.clear();

         }

      if(addmaterial){ // add material
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj nazwe");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==1) {

            text = inputTextField.getText();
            outputTextField.setText("podaj wage");
            submitclick++;
            inputTextField.clear();


         }
         else if(submitclick==2){
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("podaj ilosc");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==3){
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("podaj cene");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==4){
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            outputTextField.setText("podaj id magazynu");
            submitclick++;
            inputTextField.clear();
         }
         else{
            String text1 = inputTextField.getText();
            int5 = Integer.parseInt(text1);
            lworker.addNewMaterial(int1, text, int2, int3, int4, int5);
            textArea.setText("Pomyślnie  dodano" );
            submitclick = 0;
            addmaterial= false;
            inputTextField.clear();
         }


      }
      if (submaterial){

         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lworker.deleteMaterial(int1);
         textArea.setText("Materiał o id: " + int1 + " został usunięty");;
         submaterial=false;
         inputTextField.clear();

      }
      if(addproject){ // add project
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj wage");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==1) {

            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("podaj wielkosc");
            submitclick++;
            inputTextField.clear();


         }
         else if(submitclick==2){
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("podaj szczegoly projektu ");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==3){
            text = inputTextField.getText();
            outputTextField.setText("podaj szczegoly formy");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==4){
             text2 = inputTextField.getText();
            outputTextField.setText("podaj id magazynu");
            submitclick++;
            inputTextField.clear();
         }
         else{
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            cworker.addNewProject(int1, int2, int3, text, text2, int4);
            textArea.setText("Pomyślnie  dodano" );
            submitclick = 0;
            addproject= false;
            inputTextField.clear();
         }


      }
      if (subproject){

         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         cworker.deleteProject(int1);
         textArea.setText("Project o id: " + int1 + " został usunięty");;
         subproject=false;
         inputTextField.clear();

      }
      if(addform){ // add form
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj typ");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==1) {

            text = inputTextField.getText();
            outputTextField.setText("podaj liczbe użyć");
            submitclick++;
            inputTextField.clear();


         }
         else if(submitclick==2) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("podaj id warehouse ");
            submitclick++;
            inputTextField.clear();
         }
         else{
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            cworker.addNewForm(int1, text, int2, int3);
            textArea.setText("Pomyślnie  dodano" );
            submitclick = 0;
            addform= false;
            inputTextField.clear();
         }


      }
      if (subform){

         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         cworker.deleteForm(int1);
         textArea.setText("Forma o id: " + int1 + " został usunięty");;
         subform=false;
         inputTextField.clear();

      }
      if(addcast){ // add cast
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj ilosc");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==1) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("podaj jakosc");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==2) {
            text = inputTextField.getText();
            outputTextField.setText("podaj status ");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==3) {
            text2 = inputTextField.getText();
            outputTextField.setText("podaj id projektu ");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==4) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("podaj id magazynu ");
            submitclick++;
            inputTextField.clear();
         }
         else{
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            cworker.addNewCasting(int1, int2, text, text2, int3, int4);
            textArea.setText("Pomyślnie  dodano" );
            submitclick = 0;
            addcast= false;
            inputTextField.clear();
         }


      }
      if (subcast){

         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         cworker.deleteCast(int1);
         textArea.setText("odlew o id: " + int1 + " został usunięty");;
         subcast=false;
         inputTextField.clear();

      }
      if(addwarehouse){ // add warehouse
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj pojemność");
            submitclick++;
            inputTextField.clear();
         }
         else{

            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            lworker.addNewWarehouse(int1, int2);
            textArea.setText("Pomyślnie dodano" + int1 + " " + int2);
            submitclick = 0;
            addwarehouse= false;
            inputTextField.clear();
         }

      }
      if (subwarehouse){

         String text1 = inputTextField.getText();
         int1 = Integer.parseInt(text1);
         lworker.deleteWarehouse(int1);
         textArea.setText("Pracownik o id: " + int1 + " został usunięty");
         subwarehouse=false;
         inputTextField.clear();

      }
      if(addtransport){ // add cast
         if (submitclick==0) {
            String text1 = inputTextField.getText();
            int1 = Integer.parseInt(text1);
            outputTextField.setText("podaj pojemnosc");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==1) {
            String text1 = inputTextField.getText();
            int2 = Integer.parseInt(text1);
            outputTextField.setText("podaj wage");
            submitclick++;
            inputTextField.clear();
         }
         else if(submitclick==2) {
            String text1 = inputTextField.getText();
            int3 = Integer.parseInt(text1);
            outputTextField.setText("podaj id cast ");
            submitclick++;
            inputTextField.clear();
         }

         else{
            String text1 = inputTextField.getText();
            int4 = Integer.parseInt(text1);
            sworker.orderTransport(int1, int2, int3, int4);
            textArea.setText("Pomyślnie  dodano" );
            submitclick = 0;
            addtransport= false;
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

}
