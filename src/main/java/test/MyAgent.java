package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.instrument.Instrumentation;
/*
 this class implement a public static agentmain and a public static premain
 please refer to the Package java.lang.instrument document
 https://docs.oracle.com/javase/7/docs/api/java/lang/instrument/package-summary.html
 */
public class MyAgent {
    private static Instrumentation instrumentation;
    private static Logger logger = LogManager.getLogger();

    public static void premain(String args, Instrumentation inst) throws Exception {
        logger.info("premain method is running with the args:" + args
                + "instrumentation:" + instrumentation);
        instrumentation = inst;
        instrumentation.addTransformer(new MyClassFileTransformer("P"));

    }

    public static void agentmain(String args, Instrumentation inst) throws Exception {
        logger.info("agentmain method is running with the args:" + args
                + ";instrumentation:" + inst);
        instrumentation = inst;
        instrumentation.addTransformer(new MyClassFileTransformer("D"));

    }


}