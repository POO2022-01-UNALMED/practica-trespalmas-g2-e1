package gestorAplicacion.store;

public class Shelf extends Store{

    public static final int maxAmount = 25;

    // CONSTRUCTORS
    public Shelf(int id) {
        super(id);
    }

    // GETTERS AND SETTERS

    @Override
    public int getFreeAmount() {
        return maxAmount - actualAmount;
    }

    // METHODS IMPLEMENTS
    public static int getMaxAmount() {
        return Shelf.maxAmount;
    }
    @Override
    public String getId() {
        return "SF-" + this.id;
    }

}
