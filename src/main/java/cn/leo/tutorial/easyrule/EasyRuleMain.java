package cn.leo.tutorial.easyrule;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
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
        rules.register(new Weather2Rule());
        rules.register(new Weather3Rule());

        // .skipOnFirstAppliedRule(true) // 当一个匹配成功了，则停止匹配之后的
        // .skipOnFirstFailedRule(true) // 当第一个出现异常则停止。不匹配的话，也会继续匹配
        RulesEngineParameters param = new RulesEngineParameters().skipOnFirstFailedRule(true);
        RulesEngine rulesEngine = new DefaultRulesEngine(param);
        rulesEngine.fire(rules,facts);
    }
}
