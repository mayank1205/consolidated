public class Singleton implements Cloneable {
    private static volatile Singleton instance = null;

    private Singleton() {
        // private constructor to prevent instantiation from other classes
        if(instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton instance cannot be cloned");
    }

    
}
