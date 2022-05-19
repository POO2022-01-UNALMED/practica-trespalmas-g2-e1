package gestorAplicacion;

public class Cooler extends Store{
    private final int maxAmount;

    // CONSTRUCTORS
    public Cooler(int id, int maxAmount) {
        super(id);
        this.maxAmount = maxAmount;
    }

    // METHODS IMPLEMENTS
    @Override
    public String getId() {
        return "C" + this.id;
    }

    @Override
    public int getMaxAmount() {
        return this.maxAmount;
    }
}
