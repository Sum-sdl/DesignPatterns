package desgin.structure;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/16.
 * <p>
 * 外观模式
 * <p>
 * 外观模式是为了解决类与类之家的依赖关系的,
 * 将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口
 */

public class FacadePattern extends BaseTest {
    @Override
    public void startTest() {
        Computer computer = new Computer();
        computer.startup();
        computer.stop();

    }

    private class Computer {
        private Disk disk;
        private Cpu cpu;
        private Memory memory;

        public Computer() {
            disk = new Disk();
            cpu = new Cpu();
            memory = new Memory();
        }

        public void startup() {
            disk.startup();
            memory.startup();
            cpu.startup();
        }

        public void stop() {
            cpu.stop();
            memory.stop();
            disk.stop();
        }
    }

    private class Disk {
        public void startup() {
            print("Disk startup");
        }

        public void stop() {
            print("Disk stop");
        }
    }

    private class Cpu {
        public void startup() {
            print("Cpu startup");
        }

        public void stop() {
            print("Cpu stop");
        }
    }

    private class Memory {
        public void startup() {
            print("Memory startup");
        }

        public void stop() {
            print("Memory stop");
        }
    }

}
