package desgin.structure.adapter;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/15.
 * <p>
 * 对象适配器
 * <p>
 * 基本思路和类的适配器模式相同，
 * 只是将Adapter类作修改，这次不继承Source类，
 * 而是持有Source类的实例，以达到解决兼容性的问题
 */

public class ObjectAdapter extends BaseTest {
    @Override
    public void startTest() {
        ClassAdapter.Target target = new Wrapper(new ClassAdapter.Source());
        target.method1();
        target.method2();
    }


    static class Wrapper implements ClassAdapter.Target {

        private ClassAdapter.Source source;

        public Wrapper(ClassAdapter.Source source) {
            this.source = source;
        }

        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            print("Wrapper.method2");
        }
    }

}
