package cn.leo.tutorial.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author leo 2021/3/11 上午11:49
 **/
public class EasyRuleMain {

    public static void main(String[] args) {
        Facts facts = new Facts();
        facts.put("rain", 1);

        Rules rules = new Rules();
        rules.register(new WeatherRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules,facts);
    }
}
