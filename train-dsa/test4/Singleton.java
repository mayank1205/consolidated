public class Singleton implements Cloneable {
    
    
    private static volatile Singleton instance = null;

    private Singleton() {
        if(instance != null) {
            throw new RuntimeException("Singleton instance already created");
        }
    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
