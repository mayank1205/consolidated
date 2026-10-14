public class SynchronousSingleton implements Cloneable{
    public static volatile SynchronousSingleton instance = null;

    private SynchronousSingleton() {
        if(instance != null) {
            throw new IllegalStateException("Instance already exists");
        }
    }

    public static SynchronousSingleton getInstance() {
        if(instance == null) {
            synchronized(SynchronousSingleton.class) {
                if(instance == null) {
                    instance = new SynchronousSingleton();
                }
            }
        }
        return instance;
    }

    @Override 
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}