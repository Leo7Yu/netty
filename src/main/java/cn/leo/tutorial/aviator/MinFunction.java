package cn.leo.tutorial.aviator;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Map;

/**
 * @author leo 2021/3/11 下午4:03
 **/
public class MinFunction extends AbstractFunction {

    @Override
    public String getName() {
        return "min";
    }

    /**
     * @param param 参数集合
     * @param arg1  函数中第一个参数
     * @param arg2  函数中第二个参数
     * @return
     */
    @Override
    public AviatorObject call(Map<String, Object> param, AviatorObject arg1, AviatorObject arg2) {
        Number left = FunctionUtils.getNumberValue(arg1, param);
        Number right = FunctionUtils.getNumberValue(arg2, param);
        return new AviatorBigInt(Math.min(left.doubleValue(), right.doubleValue()));
    }
}
