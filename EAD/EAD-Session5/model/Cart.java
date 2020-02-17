package model;

import java.util.ArrayList;

/**
 * The Class Cart.
 */
public class Cart {
    
    /** The product code. */
    private ArrayList<Integer> product_code = new ArrayList<Integer>();
    
    /** The type. */
    private ArrayList<String> type = new ArrayList<String>();
    
    /** The name. */
    private ArrayList<String> name = new ArrayList<String>();
    
    /** The price. */
    private ArrayList<Double> price = new ArrayList<Double>();
    
    /** The quantity. */
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    
    /** The cart. */
    private static Cart cart = new Cart();
    
    /**
     * Instantiates a new cart.
     */
    private Cart(){}
    
    /**
     * Gets the single instance of Cart.
     *
     * @return single instance of Cart
     */
    public static Cart getInstance(){
        return cart;
    }
    
    /**
     * Gets the product code.
     *
     * @return the product code
     */
    public ArrayList<Integer> getProduct_code() {
        return product_code;
    }
    
    /**
     * Sets the product code.
     *
     * @param product_code the new product code
     */
    public void setProduct_code(int product_code) {
        this.product_code.add(product_code);
    }
    
    /**
     * Gets the type.
     *
     * @return the type
     */
    public ArrayList<String> getType() {
        return type;
    }
    
    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type.add(type);
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public ArrayList<String> getName() {
        return name;
    }
    
    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name.add(name);
    }
    
    /**
     * Gets the price.
     *
     * @return the price
     */
    public ArrayList<Double> getPrice() {
        return price;
    }
    
    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(Double price) {
        this.price.add(price);
    }

    /**
     * Update quantity.
     *
     * @param index the index
     * @param quantity the quantity
     */
    public void updateQuantity(int index, int quantity) {
        this.quantity.set(index, quantity);
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity.add(quantity);
    }
    
    
}
