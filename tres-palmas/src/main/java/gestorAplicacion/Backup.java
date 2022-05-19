package gestorAplicacion;

public class Backup extends Store{

    private final int maxAmount;

    // CONSTRUCTOR
    public Backup(int id, int maxAmount) {
        super(id);
        this.maxAmount = maxAmount;
    }

    // METHODS IMPLEMENTS
    @Override
    public String getId() {
        return null;
    }

    @Override
    public int getMaxAmount() {
        return this.maxAmount;
    }

}
