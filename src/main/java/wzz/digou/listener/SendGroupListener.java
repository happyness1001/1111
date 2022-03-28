package wzz.digou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SendGroupListener implements ServletContextListener {
    private SendGroupThread sendGroupThread;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        if (sendGroupThread == null) {
            sendGroupThread = new SendGroupThread();
            sendGroupThread.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (sendGroupThread != null && sendGroupThread.isInterrupted()) {
            sendGroupThread.interrupt();
        }
    }
}
