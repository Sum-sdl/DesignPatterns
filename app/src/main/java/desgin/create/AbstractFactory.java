package desgin.create;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/14.
 */

public class AbstractFactory extends BaseTest {

    @Override
    public void startTest() {
        Provider provider = new SmsFactory();
        provider.produce().sender();
    }

    public interface Provider {
        SampleFactory.Sender produce();
    }


    public static class MailFactory implements Provider {
        @Override
        public SampleFactory.Sender produce() {
            return new SampleFactory.MailSender();
        }
    }

    public static class SmsFactory implements Provider {
        @Override
        public SampleFactory.Sender produce() {
            return new SampleFactory.SmsSender();
        }
    }

}
