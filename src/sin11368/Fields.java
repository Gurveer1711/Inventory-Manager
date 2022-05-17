/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sin11368;

/**
 *Enums with the titles of item data members
 * @author Gurveer Singh
 * @version 1.0
 */
public enum Fields {
    ITEM_ID("Inventory ID"),
    ITEM_NAME("Item Name"),
    QOH("Qty. on Hand"),
    ROP("Re-Order Point"),
    PRICE("Unit Price");
    
    private String caption;
    
    /**
     * @param caption of type String
     */
    private Fields(String caption){
        this.caption = caption;
    }
    
    /**
     * @return caption of type String
     */
    public String getCaption(){
        return caption;
    }
}


