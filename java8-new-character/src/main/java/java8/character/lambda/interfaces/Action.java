package java8.character.lambda.interfaces;

/**
 * Created by admin on 2017/7/8.
 */
@FunctionalInterface
public interface Action {
    void run111(String param);
    default void run111(int param){};
    default void run111(String param,int a){};
}
