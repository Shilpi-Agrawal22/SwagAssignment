package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.util.logging.Logger;




public class AppiumServer {

    public static final Logger LOGGER = Logger.getLogger(AppiumServer.class.getName());

    public static AppiumDriverLocalService getInstance(){
       /* Code for mac*/
    	AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(4723);

        return AppiumDriverLocalService.buildService(builder);
    	/*Code for Windows
    	AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"))
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .usingPort(4723);

        return AppiumDriverLocalService.buildService(builder);*/
    }

    public static void Start(){
        LOGGER.info("**************  Starting Appium Server  **************");
        if(!getInstance().isRunning()){
            getInstance().start();
        }
    }

    public static void Stop(){
        LOGGER.info("**************  Terminating Appium Server  **************");
        getInstance().stop();
    }
}