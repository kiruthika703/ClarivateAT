package managers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.IOException;

public class Logfile {
    private static final Logger logger = LogManager.getLogger(Logfile.class);

    /**
     * This method is used to add information to the log file
     *
     * @param msg Message to be displayed
     * @throws IOException
     */
    public static void info(final String msg) throws IOException {
        DOMConfigurator.configure("log4j.xml");
        logger.info(msg);
    }

}