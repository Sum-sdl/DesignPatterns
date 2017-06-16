package desgin.structure.adapter;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/15.
 * 类适配器
 * <p>
 * 有一个Source类，拥有一个方法，待适配，Target，
 * 通过Adapter类，将Source的功能扩展到Target里
 */

public class ClassAdapter extends BaseTest {

    @Override
    public void startTest() {
        Target target = new Adapter();
        target.method1();
        target.method2();
    }

    public interface Target {

        void method1();

        void method2();
    }

    public static class Source {
        public void method1() {
            print("Source.method1");
        }
    }

    static class Adapter extends Source implements Target {
        @Override
        public void method2() {
            print("Adapter.method2");
        }
    }
}
