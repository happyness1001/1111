package wzz.digou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SendNormalListener implements ServletContextListener {
    private SendNormalThread sendNormalThread;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        if (sendNormalThread == null) {
            sendNormalThread = new SendNormalThread();
            sendNormalThread.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (sendNormalThread != null && sendNormalThread.isInterrupted()) {
            sendNormalThread.interrupt();
        }
    }
}
