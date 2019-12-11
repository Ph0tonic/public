package ex5;

public class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        if (INSTANCE != null)
            throw new IllegalStateException("Already instantiated");
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    protected void print() {
        System.out.println("Logged");
    }
}
