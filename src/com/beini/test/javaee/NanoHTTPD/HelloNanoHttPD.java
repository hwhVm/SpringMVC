package com.beini.test.javaee.NanoHTTPD;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.util.ServerRunner;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by beini on 2017/12/20.
 */
public class HelloNanoHttPD extends NanoHTTPD {

    public HelloNanoHttPD() {
        super(8080);
    }

    private static final Logger LOG = Logger.getLogger(HelloNanoHttPD.class.getName());

    public static void main(String[] args) {
        ServerRunner.run(HelloNanoHttPD.class);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        String uri = session.getUri();
        HelloNanoHttPD.LOG.info(method + " '" + uri + "' ");



        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n" + "  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }

        msg += "</body></html>\n";
        return NanoHTTPD.newFixedLengthResponse(msg);
    }
}
