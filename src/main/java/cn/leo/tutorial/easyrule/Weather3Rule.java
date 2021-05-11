package cn.leo.tutorial.easyrule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author leo 2021/3/11 上午11:48
 **/
@Rule(priority = 20, name = "weather rule", description = "if it rains then take an umbrella")
public class Weather3Rule {

    @Condition
    public boolean itRains(@Fact("rain") int rain) {
        System.out.println(rain);
        return rain<0;
    }

    @Action
    public void takeAnUmbrella(@Fact("rain") int rain){
        System.out.println(rain);
        System.out.println("take an umbrella");
    }
}
