package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/16.
 * <p>
 * 桥接模式
 * <p>
 * 把操作和具体实现分开，各自独立发展
 */

public class BridgePattern extends BaseTest {
    @Override
    public void startTest() {
        Bridge bridge = new Bridge();
        //方案1
        bridge.setSourceable(new Source1());
        bridge.open();
        bridge.close();

        //方案2(修改了方案实现)
        bridge.setSourceable(new Source2());
        bridge.open();
        bridge.close();
    }

    private interface Sourceable {
        void open();

        void close();
    }

    private class Source1 implements Sourceable {
        @Override
        public void open() {
            print("Source1 open");
        }

        @Override
        public void close() {
            print("Source1 close");
        }
    }

    private class Source2 implements Sourceable {
        @Override
        public void open() {
            print("Source2 open");
        }

        @Override
        public void close() {
            print("Source2 close");
        }
    }


    private class Bridge {
        private Sourceable sourceable;

        public Sourceable getSourceable() {
            return sourceable;
        }

        public void setSourceable(Sourceable sourceable) {
            this.sourceable = sourceable;
        }

        public void open() {
            sourceable.open();
        }

        public void close() {
            sourceable.close();
        }
    }


}
