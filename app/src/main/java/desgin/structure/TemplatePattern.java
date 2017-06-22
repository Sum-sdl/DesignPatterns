package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/21.
 * <p>
 * 模板方法模式
 */

public class TemplatePattern extends BaseTest {
    @Override
    public void startTest() {
        AbsCaculator caculator = new Plus();
        int res = caculator.caculator("10+1", "\\+");
        print("plus:" + res);
    }

    private abstract class AbsCaculator {

        public final int caculator(String exp, String opt) {

            int[] spit = spit(exp, opt);
            return caculator(spit[0], spit[1]);
        }

        abstract protected int caculator(int a, int b);

        private int[] spit(String exp, String opt) {
            String[] split = exp.split(opt);
            int[] array = new int[2];
            array[0] = Integer.parseInt(split[0]);
            array[1] = Integer.parseInt(split[1]);
            return array;
        }

    }

    private class Plus extends AbsCaculator {
        @Override
        protected int caculator(int a, int b) {
            return a + b;
        }
    }

    private class Minus extends AbsCaculator {
        @Override
        protected int caculator(int a, int b) {
            return a - b;
        }
    }


}
