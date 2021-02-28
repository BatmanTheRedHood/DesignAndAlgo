package models;

public abstract class Algorithm {
    protected abstract void init();
    protected abstract void run();

    public void initAndRun() {
        this.init();
        this.run();
    }
}
