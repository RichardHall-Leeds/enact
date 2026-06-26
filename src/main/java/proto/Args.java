package proto;

public class Args {
    public static void main(String[] args) {
        String env= System.getProperty("env", "qa");
        System.out.println("Environment variable is " + env);

    }
}
