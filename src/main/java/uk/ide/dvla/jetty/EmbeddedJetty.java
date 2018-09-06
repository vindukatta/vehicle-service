package uk.ide.dvla.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by indukatta on 06/09/2018.
 */
public class EmbeddedJetty {

    private Server jettyServer;

    public EmbeddedJetty(int portNumber) {
        jettyServer = new Server(portNumber);
    }

    public void start() throws Exception {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("uk.ide.dvla.rest");


        ServletHolder restServlet = new ServletHolder(new ServletContainer(resourceConfig));

        ServletContextHandler restContext = new ServletContextHandler(jettyServer, "/*");
        restContext.addServlet(restServlet, "/*");

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.stop();
        }
    }
}
