package java8.character.lambda;

import java8.character.lambda.interfaces.Action;
import java8.character.lambda.interfaces.ActionSay;

/**
 * Created by admin on 2017/7/8.
 */
public class LambdaDemo {
    public  void excuteresult(Action action){
        action.run111("Hello World!");
    }

    public  void say(ActionSay actionSay){
        actionSay.say("222",11);
    }
}
