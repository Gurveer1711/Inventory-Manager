/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sin11368;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class InventoryFXMLController implements Initializable {
    
    InventoryList invList = new InventoryList();
    
    public ObservableList<String> orderList;
    @FXML
    private TextField invId, invname, invqty, invrop, invsp;
    @FXML
    public Label test;
    @FXML
    public Button btnadd, btnsave, btnorders, btnexit;
    @FXML
    public ListView<String> lstInv;
    @FXML
    public Fields[] fields = {Fields.ITEM_ID, Fields.ITEM_NAME, Fields.PRICE,
    Fields.QOH, Fields.ROP};
    
    
   
    /**
     * Inner Class to define the behaviour of the buttons
     */
    
    private class Action implements EventHandler<ActionEvent>{
        
        
        
        public void action(ActionEvent e){
            
   // Button to add new Inventory Item
   
            if(e.getSource()== btnadd){
                
                testing(true);
                
                btnadd.setDisable(true);
                btnorders.setDisable(true);
                btnsave.setDisable(false);
                
                
    // Button to Save the Inventory Item in the List View            
            }else if(e.getSource() == btnsave){
                
                String id = invId.getText();
                String name = invname.getText();
                int qty = Integer.parseInt(invqty.getText());
                int rop = Integer.parseInt(invrop.getText());
                double sp = Double.parseDouble(invsp.getText());
                
                boolean test1;
                Inventory inventory = new Inventory();
                try{
                    inventory.setId(id);
                    inventory.setName(name);
                    inventory.setQoh(qty);
                    inventory.setRop(rop);
                    inventory.setSellPrice(sp);
                    
                    test1=true;
                    
                }catch(IllegalArgumentException i){
                    test1=false;
                }
                if(test1){
                    invList.add(inventory);
                    erase();
                   
                    btnadd.setDisable(false);
                    btnorders.setDisable(false);
                    btnsave.setDisable(true);
                    testing(false);
                    
                }else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Data Entry Error");
                    alert.setHeaderText("Invalid Value Entered");
                    alert.setContentText("Item ID must be in the form ABC-1234");
                    alert.showAndWait();
                }
                
                
    // Button to Check the List of Orders 
    
            }else if(e.getSource() == btnorders){
                
                if(invList.length()==0){
                    test.setText("No items in the List. Add Some!");
                    
                }else if(invList.length()>0){
                    orderList.clear();
                    for(int i=0; i<invList.length(); i++){
                        if(invList.get(i).getRop()>0){
                            orderList.add(invList.get(i).toString());
                            lstInv.setItems(orderList);
                            lstInv.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener(){
                                @Override
                                public void invalidated(Observable o){
                                    int index = lstInv.getSelectionModel().getSelectedIndex();
                                    test.setText("Re-order Point: " + invList.get(index).getRop());
                                }
                            });
                        }else{
                            test.setText("No items to re-order");
                        }   
                    }
                    
                }
                   
                
    // Button to exit the Gui interfce            
            }else if(e.getSource() == btnexit){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Program");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you wish to exit?");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK)
                    System.exit(0);
            }
            
        }
        
        @Override
        public void handle(ActionEvent t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            action(t);
        }
        
    }
    
    /**
     * Method to clear the content of the text fields
     */
    public void erase(){
        invId.clear();
        invname.clear();
        invqty.clear();
        invrop.clear();
        invsp.clear();
    }
    
    /**
     * Method to make the text Fields editable 
     * @param b of type boolean
     */
    public void testing(boolean b){
        invId.setEditable(b);
        invname.setEditable(b);
        invqty.setEditable(b);
        invrop.setEditable(b);
        invsp.setEditable(b);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        btnexit.setOnAction(new Action());
        btnadd.setOnAction(new Action());
        btnsave.setOnAction(new Action());
        btnorders.setOnAction(new Action());
        btnorders.setOnAction(new Action());
        orderList = FXCollections.observableArrayList();
        lstInv.setItems(orderList);
        
        
    }    
      
}
