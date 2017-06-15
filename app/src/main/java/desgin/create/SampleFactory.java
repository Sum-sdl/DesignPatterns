package desgin.create;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/14.
 */

public class SampleFactory extends BaseTest {


    @Override
    public void startTest() {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produce("mail");
        sender.sender();
    }

    public interface Sender {
        void sender();
    }

    public static class MailSender implements Sender {
        @Override
        public void sender() {
            print("MailSender");
        }
    }

    public static class SmsSender implements Sender {
        @Override
        public void sender() {
            print("SmsSender");
        }
    }

    //简单工厂（文本输入容易出错）
    public class SenderFactory {

        public Sender produce(String type) {
            if (type.equals("mail")) {
                return new MailSender();
            } else if (type.equals("sms")) {
                return new SmsSender();
            } else {
                return null;
            }
        }
    }

    //简单工厂改进
    public class SenderFactory2 {

        public Sender produceMail() {
            return new MailSender();
        }

        public Sender producSms() {
            return new SmsSender();
        }
    }

    //静态工厂方法模式
    public static class SenderFactory3 {

        public static Sender produceMail() {
            return new MailSender();
        }

        public static Sender producSms() {
            return new SmsSender();
        }
    }
}
