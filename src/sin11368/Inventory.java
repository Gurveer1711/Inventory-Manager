/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sin11368;

/**
 *Inventory Class with accessor and mutator methods for all data members and
 * Constructors for this class
 * @author Gurveer Singh
 * @version 2.0
 */
public class Inventory {
    /**
     * the default item id is ABC-1234
     * the default item name is New Name
     * the default item qty in hand is 0
     * the default item re-order point is 25
     * the default item sellPrice is 0
     */
    private String id = "ABC-1234";
    private String name= "New Name";
    private int qoh= 0;
    private int rop= 0;
    private double sellPrice= 25;
    
    // Variable to check id standards
    public boolean matches;
    public boolean alphamatch;
    public boolean symatch;
    public boolean nummatch;
    public boolean lenmatch;
    
    /** 
     * A default constructor to access data in other classes
     * @author Gurveer Singh
    */
    public Inventory(){
    }
    
    /**
     * Constructor to set the values of various data members
     * @author Gurveer Singh
     * @param id to set id data member of String type
     * @param name to set name data member of String type
     * @param sellPrice to set sellPrice data member of double type
     */
    public Inventory(String id, String name, double sellPrice){
        this.id = id;
        this.name = name;
        this.sellPrice = sellPrice;
    }
    
    /**
     * constructor to set the values of all the data members and get the output via
     * toString() method
     * @param id to set item id
     * @param name to set name of item
     * @param qoh to set qty in hand
     * @param rop to set re-order point
     * @param sellPrice to set sellPrice of the defined item
     * @author Gurveer Singh 
     */
    public Inventory(String id, String name, int qoh, int rop, double sellPrice){
        this.id = id;
        this.name = name;
        this.qoh = qoh;
        this.rop = rop;
        this.sellPrice = sellPrice;
    }
    
    /**
     * getter method for private data member id
     * @return id as a String
     * @author Gurveer Singh
     */
    public String getId(){
        return id;
    }
    
    /**
     * Setter method to mutate the value of id
     * @param id to set item id
     * @throws IllegalArgumentException if id does not meet the standards 
     * @author Gurveer Singh
     */
    public void setId(String id){
        id = id.trim();
        if (id.length() == 8)
            lenmatch = true;
        else{
            lenmatch = false;
            throw new IllegalArgumentException();
        }
        for(int i=0; i<3; i++){
            if(Character.isLetter(id.charAt(i)))
                alphamatch = true;
            else{
                alphamatch = false;
                throw new IllegalArgumentException();
            }
        }
        
        if(id.charAt(3)=='-')
            symatch = true;
        else{
            symatch = false;
            throw new IllegalArgumentException();
        }
        for(int x=4; x<8; x++){
            if (Character.isDigit(id.charAt(x)))
                nummatch = true;
            else{
                nummatch = false;
                throw new IllegalArgumentException();
            }
        }
        matches = lenmatch && alphamatch && symatch && nummatch;
        
       /* Pattern p = Pattern.compile("^[a-zA-Z]{3}+-[0-9]{4}+$");
        Matcher m = p.matcher(id);
        matches = m.matches();*/
       
        if (matches){
            this.id = id;
        }else{
            throw new IllegalArgumentException();
        }
        
    }
    
    /**
     * getter method to access name data member as string
     * @return name as a String
     * @author Gurveer Singh
     */
    public String getName(){
        return name;
    }
    
    /**
     * setter method to mutate the value of name data member
     * @param name to set item name
     * @throws IllegalArgumentException if name is null
     * @author Gurveer Singh
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * getter method to access value of qoh data member
     * @return qoh as an int
     * @author Gurveer Singh
     */
    public int getQoh(){
        return qoh;
    }
    
    /**
     * Setter method to mutate the value of qoh data member
     * @param qoh to set qty in hand of item
     * @throws IllegalArgumentException if qoh doesn't meet the standards
     * @author Gurveer Singh
     */
    public void setQoh(int qoh){
        if(qoh > this.rop){
           this.qoh = qoh; 
        }else
            throw new IllegalArgumentException();
        
    }
    
    /**
     * Getter method to access rop data member
     * @return rop as an int
     * @author Gurveer Singh
     */
    public int getRop(){
        return rop;
    }
    /**
     * Setter method to mutate the value of rop
     * @param rop to set re-order point of item
     * @throws IllegalArgumentException is Standards for rop are not met
     * @author Gurveer Singh
     */
    public void setRop(int rop){
        this.rop = rop;   
    }
    
    /**
     * getter method to access the value of sellPrice data member
     * @return sellPrice as a double
     * @author Gurveer Singh
     */
    public double getSellPrice(){
        return sellPrice;
    }
    
    /**
     * setter method to mutate the value of sellPrice
     * @param sellPrice to set sellPrice of item
     * @throws IllegalArgumentException if Standards for sellPrice are not met
     */
    public void setSellPrice(double sellPrice){
            this.sellPrice = sellPrice; 
    }
    
    /**
     * using @override to override the toString() method of object class
     * method to return a sentence on the console
     * @return String sequence
     */
    @Override
    public String toString(){
        return String.format("%s (%s) ,QOH: %d Price:$ %.2f", id,name,qoh,sellPrice);
    }

}
