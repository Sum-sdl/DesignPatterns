package app;

import desgin.BaseTest;
import desgin.structure.DecoratorPattern;

/**
 * Created by sdl on 2017/6/12.
 */

public class MainTest {

    public void design_factory() {

        //简单工厂模式
//        BaseTest test = new SampleFactory();
        //抽象工厂模式
//        BaseTest test = new AbstractFactory();
        //类适配器
//        BaseTest test = new ClassAdapter();
        //对象适配器
//        BaseTest test = new ObjectAdapter();
        //接口适配器
//        BaseTest test = new InterfaceAdapter();
        //装饰者模式
        BaseTest test = new DecoratorPattern();


        test.startTest();
    }

}
