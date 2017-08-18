package java8.character.lambda.interfaces;

/**
 * Created by admin on 2017/7/8.
 */
@FunctionalInterface
public interface ActionTest {
    void run111(String param);
    public String toString();
    default void run111(int param){};
    public static void ruaan111(int param){};
    public static void aaa(){

    }
    default void run111(String param, int a){};
}
