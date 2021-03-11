package cn.leo.tutorial.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import java.util.Map;

/**
 * @author leo 2021/3/11 下午3:36
 **/
public class AviatorEvaluatorUtil {

    static {
        AviatorEvaluator.addFunction(new MinFunction());
    }

    @SuppressWarnings("unchecked")
    public static <T> T execute(String expression, Map<String, Object> param, T defaultValue) {
        try {
            return ((T) AviatorEvaluator.execute(expression, param, true));
        } catch (Exception e) {
            System.out.println(e.toString());
            return defaultValue;
        }
    }

}
