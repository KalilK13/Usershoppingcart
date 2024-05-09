package usershopcart;
//Is-A relation = Inheritance
public class CanSpan extends Food implements Perishable{

    public CanSpan(String name, Size size, double price, int inventory) {
        super(name, size, price, inventory);
    }

    @Override
    public boolean isPerishable() {
        return false;
    }
}
