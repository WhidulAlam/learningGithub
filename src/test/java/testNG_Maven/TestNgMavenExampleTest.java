package testNG_Maven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER= LogManager.getLogger(TestNgMavenExampleTest.class);
    @Test
    public void run(){
        System.out.println(ReadConfigFiles.getPropertyValues("DbName"));
        System.out.println(ReadConfigFiles.getPropertyValues("DbUser"));
        System.out.println(ReadConfigFiles.getPropertyValues("DbPassword"));
       /*LOGGER.debug("This is info message");
       LOGGER.info("This is info message");
       LOGGER.warn("This is warning message");
       LOGGER.error("This is error message");
       LOGGER.fatal("This is dangerous");*/
    }
}
