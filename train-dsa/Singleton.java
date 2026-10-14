public class Singleton implements Cloneable {
    private static volatile Singleton singletonInstance = null;

    private Singleton(){
        if (singletonInstance != null) {
		throw new RuntimeException("Singleton already created");
		}
    }

    public static Singleton getInstance() {
        if(singletonInstance == null){
            synchronized (Singleton.class) {
                if(singletonInstance == null){
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this object is not allowed");
    }
}
