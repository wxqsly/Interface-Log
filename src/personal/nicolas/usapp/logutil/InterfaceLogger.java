package personal.nicolas.usapp.logutil;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * Custom Logger interface with convenience methods for
 * the Request and Response recording.
 */
public final class InterfaceLogger implements Serializable {
    private Logger log = LogManager.getLogger(InterfaceLogger.class);

    /*
     * Thread ID |Class Name | Method Name | Line Number | Type|Status|TraceUniqueId|Request component|Response component|Interface Name|Duration|Response Code|Response Message|Request Parameters or Response Results
     */
    private final static String LOG_REQUEST_FORMAT = "Thread-{}|{}|{}|Line Number: {}|{}|{}|{}|{}|{}|{}|{}|{}|{}|\n{}";

    /*
     * Thread ID | Type|Status|TraceUniqueId|Request component|Response component|Interface Name|Duration|Response Code|Response Message|Request Parameters or Response Results
     */
    private final static String LOG_RESPONSE_FORMAT = "Thread-{}|{}|{}|{}|{}|{}|{}|{}|{}|{}|\n{}";

    private final static short INDEX_OF_PARENT_OBJECT = 2;

    public InterfaceLogger() {
        super();
    }

    public InterfaceLogger(Class clz) {
        this.log = LogManager.getLogger(clz);
    }

    /**
     * Printing out the request related to a interface.
     *
     * @param logItem The instance of a @InterfaceLogItem
     */
    public void printRequest(InterfaceLogItem logItem) {
        // Get the Class Name, Method Name which invoke current method
        // The index INDEX_OF_PARENT_OBJECT represent the position of current method's invoker
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        String invokerClassName = "";
        String invokerMethodName = "";
        int invokerMethodLine = -1;

        if (stackTraces != null && stackTraces[INDEX_OF_PARENT_OBJECT] != null) {
            StackTraceElement parentObject = stackTraces[2];
            invokerClassName = parentObject.getClassName();
            invokerMethodName = parentObject.getMethodName();
            invokerMethodLine = parentObject.getLineNumber();
        }

        if (log.isDebugEnabled()) {
            log.log(Level.DEBUG, LOG_REQUEST_FORMAT, Thread.currentThread().getId(), invokerClassName, invokerMethodName, invokerMethodLine, logItem.getTraceUniqueId(), MessageType.REQUEST, "", logItem.getOrigin()
                    , logItem.getDestination(), logItem.getInterfaceName(), "", "", "", logItem.getRequest());
        } else {
            log.log(Level.INFO, LOG_REQUEST_FORMAT, Thread.currentThread().getId(), invokerClassName, invokerMethodName, invokerMethodLine, logItem.getTraceUniqueId(), MessageType.REQUEST, "", logItem.getOrigin()
                    , logItem.getDestination(), logItem.getInterfaceName(), "", "", "", "");
        }
    }

    /**
     * Printing out the response related to a interface.
     * @param logItem
     */
    public void printResponse(InterfaceLogItem logItem) {
        if (log.isDebugEnabled()) {
            log.log(Level.DEBUG, LOG_RESPONSE_FORMAT, Thread.currentThread().getId(), logItem.getTraceUniqueId(), MessageType.RESPONSE, logItem.getStatus(), logItem.getDestination()
                    , logItem.getOrigin(), logItem.getInterfaceName(), logItem.getDuration(), "", "", logItem.getResponse());
        } else {
            log.log(Level.INFO, LOG_RESPONSE_FORMAT, Thread.currentThread().getId(), logItem.getTraceUniqueId(), MessageType.RESPONSE, logItem.getStatus(), logItem.getDestination()
                    , logItem.getOrigin(), logItem.getInterfaceName(), logItem.getDuration(), "", "", "");

        }
    }
}