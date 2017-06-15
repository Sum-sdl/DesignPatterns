package desgin.adapter;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/15.
 * <p>
 * 接口适配器
 * <p>
 * 当不希望实现一个接口中所有的方法时，
 * 可以创建一个抽象类Wrapper，实现所有方法，
 * 我们写别的类的时候，继承抽象类即可
 */

public class InterfaceAdapter extends BaseTest {
    @Override
    public void startTest() {
        Sourceable sourceable = new Wrapper1();
        sourceable.method1();
        sourceable.method2();

        Sourceable sourceable2 = new Wrapper2();
        sourceable2.method1();
        sourceable2.method2();

    }

    public interface Sourceable {
        void method1();

        void method2();
    }

    public abstract class Wrapper implements Sourceable {
        @Override
        public void method1() {

        }

        @Override
        public void method2() {

        }
    }

    public class Wrapper1 extends Wrapper {
        @Override
        public void method1() {
            super.method1();
            print("Wrapper1.method1");
        }
    }

    public class Wrapper2 extends Wrapper {
        @Override
        public void method2() {
            print("Wrapper2.method2");
        }
    }

}
