package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ninja.lifecycle.Dispose;
import ninja.lifecycle.Start;
import ninja.utils.NinjaProperties;
import org.h2.tools.Server;
import org.slf4j.Logger;

import java.sql.SQLException;

/**
 * @author Max Garmash
 */
@Singleton
public class H2Server {
    private Server tcpServer;
    private Server webServer;
    @Inject
    private Logger logger;
    @Inject
    private NinjaProperties ninjaProperties;


    @Start(order = 0)
    public void startService() {
        try {
            if(ninjaProperties.getBooleanWithDefault("db.server", false)){
                tcpServer = Server.createTcpServer(new String[] {"-tcpAllowOthers"}).start();
            }
            if(ninjaProperties.getBooleanWithDefault("db.console", false)){
                webServer = Server.createWebServer(new String[] {"-webAllowOthers"}).start();
                System.out.println();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
    }

    @Dispose(order = 0)
    public void stopService() {
        if(webServer != null){
            webServer.stop();
        }
        if(tcpServer != null){
            tcpServer.stop();
        }
    }
}
