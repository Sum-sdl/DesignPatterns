package desgin.structure;

import java.util.Enumeration;
import java.util.Vector;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/22.
 * <p>
 * 观察者模式
 * <p>
 * 类和类之间的关系，不涉及到继承
 */

public class ObserverPattern extends BaseTest {

    @Override
    public void startTest() {

        Subject subject = new MySubject();

        subject.addObserver(new Observer1());
        subject.addObserver(new Observer2());

        subject.notifyDataChange();
    }

    private interface Observer {
        void update();
    }

    private class Observer1 implements Observer {

        @Override
        public void update() {
            print("Observer1 receive update");
        }
    }

    private class Observer2 implements Observer {

        @Override
        public void update() {
            print("Observer2 receive update");
        }
    }

    private interface Subject {
        void addObserver(Observer observer);

        void delObserver(Observer observer);

        void notifyDataChange();
    }


    private class MySubject implements Subject {

        private Vector<Observer> vector = new Vector<>();

        @Override
        public void addObserver(Observer observer) {
            vector.add(observer);
        }

        @Override
        public void delObserver(Observer observer) {
            vector.remove(observer);
        }

        @Override
        public void notifyDataChange() {
            Enumeration<Observer> elements = vector.elements();

            while (elements.hasMoreElements()) {
                Observer observer = elements.nextElement();
                observer.update();
            }
        }
    }

}
