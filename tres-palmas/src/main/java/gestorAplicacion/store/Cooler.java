package gestorAplicacion.store;

public class Cooler extends Store{

    public static final int maxAmount = 20;
    private int degrees;

    // CONSTRUCTORS
    public Cooler(int id, int degrees) {
        super(id);
        this.degrees = degrees;
    }

    // GETTERS AND SETTERS
    @Override
    public int getFreeAmount() {
        return maxAmount - actualAmount;
    }
    public int getDegrees() {
        return degrees;
    }
    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    // METHODS IMPLEMENTS
    public static int getMaxAmount() {
        return Cooler.maxAmount;
    }
    @Override
    public String getId() {
        return "CR-" + this.id;
    }

}
