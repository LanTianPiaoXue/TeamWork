package java8.character.lambda.implementss;

import java8.character.lambda.interfaces.Action;

/**
 * Created by admin on 2017/7/8.
 */
public class MyAction implements Action{
    @Override
    public void run111(String param) {

    }

    public void run(String param) {
        System.out.println("param:"+param);
    }
}
