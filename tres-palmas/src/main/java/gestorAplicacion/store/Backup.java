package gestorAplicacion.store;

import java.io.Serializable;

public class Backup extends Store implements Serializable {

    public static final int maxAmount = 50;

    // CONSTRUCTOR
    public Backup(int id) {
        super(id);
    }

    // GETTERS AND SETTERS

    @Override
    public int getFreeAmount() {
        return maxAmount - actualAmount;
    }

    // METHODS IMPLEMENTS
    public static int getMaxAmount() {
        return Backup.maxAmount;
    }
    @Override
    public String getId() {
        return "BP-" + this.id;
    }

}
