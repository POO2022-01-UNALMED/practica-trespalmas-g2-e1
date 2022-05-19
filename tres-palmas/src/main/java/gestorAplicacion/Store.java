package gestorAplicacion;

public abstract class Store {

    protected int id;

    public Store(int id) {
        this.id = id;
    }

    public abstract String getId();
    public abstract int getMaxAmount();

}
