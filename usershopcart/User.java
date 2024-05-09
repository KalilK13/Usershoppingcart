package usershopcart;

import java.util.Map;

public class User {
    private String name;
    private final int id; //ivars belong to the objects
    private static int sharedId = 0; // look up why is a variable static belong to the class
    private Cart cart;

    public User() {
        sharedId++;
        id = sharedId;
        this.cart = new Cart();
    }

    public void addToCart(Product product, Integer qty){
        //check if qty < inventory before adding entry
//        if (cart.getProducts().containsKey(product)){
//            cart.getProducts().merge(product,0, (qty));
//        }
//        else if(qty < product.inventory){
//            Map<Product, Integer> productsInCart =  cart.getProducts();        //access the map (cart)
//            productsInCart.put(product, qty);    //add a Map.Entry (product,qty)
//
//        }
        if(qty <= 0){
            System.out.println("You cannot add none or negative items");
        }
        else if(product.inventory == 0){
            System.out.println("This item is sold out.");
        }
        else if(qty <= product.inventory){
            Map<Product, Integer> productsInCart =  cart.getProducts();
            productsInCart.merge(product, qty, (oldValue, newValue) -> oldValue + newValue);
            product.inventory -= qty;
        }
        else if(qty > product.inventory){
            System.out.println("We don't have that many in stock.");
        }



            //else
        //print message and deny action


    }

    public void removeFromCart(Product product, Integer qty){
        Map<Product, Integer> productsToRemove = cart.getProducts();
        if(productsToRemove.containsKey(product) == false){
            System.out.println("This item does not exist in your cart.");
        }
        else if (productsToRemove.containsKey(product)) {
            for(Map.Entry<Product, Integer> p : productsToRemove.entrySet()) {
                if (p.getKey() == product && p.getValue() >= qty) {
                    productsToRemove.merge(product, qty, (oldValue, newValue) -> oldValue - newValue);
                    productsToRemove.remove(product, 0);
                    product.inventory += qty;
                }
                else if (p.getKey() == product && p.getValue() < qty){
                    System.out.println("You do not have that many items in your cart.");
                }
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static int getSharedId() {
        return sharedId;
    }

    public static void setSharedId(int sharedId) {
        User.sharedId = sharedId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cart=" + cart +
                '}';
    }
}
