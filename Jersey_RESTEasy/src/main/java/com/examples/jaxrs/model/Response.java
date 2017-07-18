package main.java.com.examples.jaxrs.model;

/**
 * Created by krishna1bhat on 7/16/17.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

    private boolean status;
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}