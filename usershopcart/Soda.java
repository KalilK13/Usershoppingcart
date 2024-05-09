package usershopcart;

public class Soda extends Food implements Perishable {
    public Soda(String name, Size size, double price, int inventory) {
        super(name, size, price, inventory);
    }

    @Override
    public boolean isPerishable() {
        return false;
    }
}
