package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/19.
 * <p>
 * 策略模式
 */

public class StrategyPattern extends BaseTest {

    @Override
    public void startTest() {

        ICaculator caculator = new Plus();
        int res = caculator.caculator("5+1");
        print("caculator add:" + res);
        caculator = new Minus();
        res = caculator.caculator("5-1");
        print("caculator minus:" + res);
    }

    private interface ICaculator {
        int caculator(String exp);
    }

    private class AbsCaculator {
        protected int[] spit(String exp, String opt) {
            String[] split = exp.split(opt);
            int[] array = new int[2];
            array[0] = Integer.parseInt(split[0]);
            array[1] = Integer.parseInt(split[1]);
            return array;
        }
    }

    private class Plus extends AbsCaculator implements ICaculator {

        @Override
        public int caculator(String exp) {
            int[] spit = spit(exp, "\\+");
            return spit[0] + spit[1];
        }
    }

    private class Minus extends AbsCaculator implements ICaculator {
        @Override
        public int caculator(String exp) {
            int[] spit = spit(exp, "-");
            return spit[0] - spit[1];
        }
    }

}
