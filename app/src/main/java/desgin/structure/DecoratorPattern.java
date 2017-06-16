package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/15.
 * 装饰者模式
 * <p>
 * 给一个对象动态增加一些新的功能
 * <p>
 * 装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */

public class DecoratorPattern extends BaseTest {

    @Override
    public void startTest() {
        SourceAble able = new Decorator(new Source());
        able.method();
    }


    private interface SourceAble {
        void method();
    }

    public class Source implements SourceAble {
        @Override
        public void method() {
            print("Source method");
        }
    }

    public class Decorator implements SourceAble {

        private Source source;

        public Decorator(Source source) {
            this.source = source;
        }

        @Override
        public void method() {
            print("Decorator method start");
            source.method();
            print("Decorator method end");

        }
    }
}
