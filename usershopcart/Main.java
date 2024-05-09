package usershopcart;

public class Main {
    public static void main(String[] args) {

   Hat product1 = new Hat("Baseball hat", Size.L, 20.00, 10);
   Product product2 = new Hat("Hammer Pants", Size.M, 50.00, 5);
    //   System.out.println(product1.getId());//   System.out.println(product2.getId());

   User user1 = new User();
   Cart cart = new Cart();
   user1.setCart(cart);

   user1.addToCart(product1, 5);
   user1.addToCart(product1, 5);
   System.out.println(product1.getInventory());
   System.out.println(product1.isWearable());
   user1.removeFromCart(product1, 11);
   user1.removeFromCart(product1, 9);
   user1.addToCart(product2, 6);
   user1.addToCart(product2, 5);
   System.out.println(cart.getProducts() + "\n");
   cart.checkOut();
   cart.setSpecial(Special.SUN);
   System.out.println("\n");
   cart.checkOut();



    }
}
