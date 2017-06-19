package app;

import desgin.BaseTest;
import desgin.structure.ComposePattern;

/**
 * Created by sdl on 2017/6/12.
 */

public class MainTest {

    public BaseTest design_factory() {

        //简单工厂模式
//       return new SampleFactory();
        //抽象工厂模式
//        return new AbstractFactory();


        //类适配器
//        return new ClassAdapter();
        //对象适配器
//       return new ObjectAdapter();
        //接口适配器
//      return new InterfaceAdapter();
        //装饰者模式
//        return new DecoratorPattern();
//        代理模式
//        return new ProxyPattern();
        //外观模式
//        return new FacadePattern();
        //桥接模式
//        return new BridgePattern();
        //组合模式
        return new ComposePattern();

    }

}
