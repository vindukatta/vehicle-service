package uk.ide.dvla;

import uk.ide.dvla.jetty.EmbeddedJetty;

/**
 * Created by indukatta on 06/09/2018.
 */
public class App {

	/**
	 * Start Jetty server
	 */
    public static void main(String[] args) throws Exception {
        new EmbeddedJetty(7003).start();
    }
}