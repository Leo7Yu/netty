package cn.leo.tutorial.aviator;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leo 2021/3/11 下午3:32
 **/
public class AviatorMain {

    public static void main(String[] args) {
//        Long result = (Long) AviatorEvaluator.execute("1+2+3");

        Long result = AviatorEvaluatorUtil.execute("1+2+3", null, 0L);
        System.out.println(result);

        // 开头空格忽略
        String name = AviatorEvaluatorUtil
            .execute(" 'Hello '+name", ImmutableMap.of("name", "Leo"), "");
        System.out.println(name);

        Map<String, Object> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 1);
        Double i = AviatorEvaluatorUtil.execute("min(a,b)", map, 0.0);
        System.out.println(i);
    }
}
