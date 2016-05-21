package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyClassFileTransformer implements ClassFileTransformer {
    private Logger logger = LogManager.getLogger();
    private String invokedBy;
    public MyClassFileTransformer(String ib) {
        this.invokedBy = ib;
    }


    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        logger.info(invokedBy+"-- class file transformer invoked for className:" + className);
        return classfileBuffer;

    }

}