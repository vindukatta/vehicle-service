package uk.ide.dvla;

import uk.ide.dvla.jetty.EmbeddedJetty;

/**
 * Created by stevewalton on 19/07/2017.
 */
public class App {

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty(7003).start();
    }
}