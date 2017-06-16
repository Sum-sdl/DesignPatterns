package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/16.
 * <p>
 * 代理模式
 * <p>
 * 多一个代理类出来，替原对象进行一些操作
 * <p>
 * 代理模式的应用场景：
 * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
 * 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
 * 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
 */

public class ProxyPattern extends BaseTest {

    @Override
    public void startTest() {
        Sourceable sourceable = new ProxySouce();
        sourceable.method();
    }

    private interface Sourceable {
        void method();
    }

    private class Source implements Sourceable {
        @Override
        public void method() {
            print("Source.method");
        }
    }


    private class ProxySouce implements Sourceable {

        private Source source;

        public ProxySouce() {
            source = new Source();
        }

        @Override
        public void method() {
            print("ProxySouce before");
            source.method();
            print("ProxySouce after");
        }
    }


}
