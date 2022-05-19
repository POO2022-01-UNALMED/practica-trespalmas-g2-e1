package gestorAplicacion;

public class Shelf extends Store{

    private final int maxAmount;


    // CONSTRUCTORS
    public Shelf(int id,int maxAmount) {
        super(id);
        this.maxAmount = maxAmount;
    }

    // METHODS IMPLEMENTS
    @Override
    public String getId() {
        return "S" + this.id;
    }

    @Override
    public int getMaxAmount() {
        return this.maxAmount;
    }
}
