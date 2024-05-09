package usershopcart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

   private Map<Product, Integer> products;
   private final float TAX = .10f;
   private Special special;

    public Cart() {
        this.products = new HashMap<>();
    }

    //methods
    public int cartQty(){
        int numberOfItems = 0;
        for (Map.Entry<Product, Integer> p: products.entrySet()){
            numberOfItems += p.getValue();
        }
        return numberOfItems;
    }
    public double subTotal(){
        double total = 0;
        if(this.special == Special.SUN || this.special == Special.TUE){
            for(Map.Entry<Product, Integer> p : products.entrySet()){
                if (p.getValue() == 1){
                    total += p.getValue() * p.getKey().getPrice();
                }
                else if(p.getValue()%2 == 0) {
                    total += ((float)p.getValue() * p.getKey().getPrice())/2;
                }
                else if(p.getValue()%2 != 0){
                    total += Math.ceil((float)p.getValue()/2) * p.getKey().getPrice();
                }
            }
            return total;
        }
        for(Map.Entry<Product, Integer> p : products.entrySet()){
            total += p.getKey().getPrice() * p.getValue();
        }
        return total;
    }
    public double totalAfterTax(){
        double total = 0;
        total = subTotal() + subTotal()*TAX;
        return total;
    }
    public void checkOut(){
        System.out.printf("You have %d items, and your total is %c%.2f and %c%.2f after tax.\nHave a nice day!\n",cartQty(),'$',subTotal(),'$',totalAfterTax());
        printSpecial();
    }
    public void printSpecial(){
        if (this.special == Special.TUE || this.special == Special.SUN){
            System.out.println("B.O.G.O FREE");
        }
        else {
            System.out.println("There are no specials today.");
        }
    }
    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }
}
