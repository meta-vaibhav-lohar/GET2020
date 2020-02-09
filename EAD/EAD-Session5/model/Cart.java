package model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Integer> product_code = new ArrayList<Integer>();
    private ArrayList<String> type = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<Double> price = new ArrayList<Double>();
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    private static Cart cart = new Cart();
    
    private Cart(){}
    
    public static Cart getInstance(){
        return cart;
    }
    
    public ArrayList<Integer> getProduct_code() {
        return product_code;
    }
    public void setProduct_code(int product_code) {
        this.product_code.add(product_code);
    }
    public ArrayList<String> getType() {
        return type;
    }
    public void setType(String type) {
        this.type.add(type);
    }
    public ArrayList<String> getName() {
        return name;
    }
    public void setName(String name) {
        this.name.add(name);
    }
    public ArrayList<Double> getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price.add(price);
    }

    public void updateQuantity(int index, int quantity) {
        this.quantity.set(index, quantity);
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.add(quantity);
    }
    
    
}
