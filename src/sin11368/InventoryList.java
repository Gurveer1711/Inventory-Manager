/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sin11368;

import java.util.ArrayList;

/**
 *Inventory List class which will work with the arrayList
 * of type Inventory
 * @author Gurveer Singh
 * @version 1.0
 * 
 */
public class InventoryList {
    
    private ArrayList<Inventory> invList = new ArrayList<>();
    
    public InventoryList(){}
    
    /**
     * Method to add items to Inventory List
     * @param Inventory
     */
    public void add(Inventory inventory){
        invList.add(inventory);
    }
    
    /**
     * Method to get the Inventory Item of Selected index
     * @param index of type int
     * @return item of type Inventory
     */
    public Inventory get(int index){
        return invList.get(index);
    }
    
    /**
     * Method to get the total number of entries in the ArrayList
     * @return index of type 
     */
    public int length(){
        return invList.size();
    }
}
