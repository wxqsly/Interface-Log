package personal.nicolas.usapp.logutil;

import java.util.UUID;

/**
 * The Object that represents a interpretation of a request or response.
 * Created by xiwang on 7/21/2016.
 */
public class InterfaceLogItem {

    /*
     * Request or Response
     */
    private MessageType messageType;

    /*
     * The status of current request or response
     */
    private Status status;

    /*
     * Unique identifier for indicating each request/response pair, could be reused after period of time
     */
    private String traceUniqueId;

    /*
     * Component which invoke the interface
     */
    private String origin;

    /**
     * Component which response the interface
     */
    private String destination;

    /*
     * Name of the interface
     */
    private String interfaceName;

    /*
     * Duration between the Message sending and receiving
     */
    private long duration;

    /*
     * Generally contains the parameters for the specified request
     */
    private Object request;

    /*
     * Response sent back if the interface support such a field
     */
    private Object response;

    public InterfaceLogItem(String origin, String destination, String interfaceName, Object request) {
        this.origin = origin;
        this.destination = destination;
        this.interfaceName = interfaceName;
        this.request = request;
        this.traceUniqueId = UUID.randomUUID().toString();
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTraceUniqueId() {
        return traceUniqueId;
    }

    public void setTraceUniqueId(String traceUniqueId) {
        this.traceUniqueId = traceUniqueId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        destination = destination;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public long getDuration() {
        return duration;
    }

    /**
     * Generally this duration should be set by the calling method.
     * The calling method is responsible for calculating the time right before the request is sent,
     * and the time right after the response is sent back. And the duration could be calculated.
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
