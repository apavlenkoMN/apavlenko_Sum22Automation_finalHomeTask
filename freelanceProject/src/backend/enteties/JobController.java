package backend.enteties;

import java.util.HashMap;
import java.util.Map;

public class JobController {

    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private String user;
    private Integer noOfComments;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobController withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JobController withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobController withDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public JobController withPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JobController withUser(String user) {
        this.user = user;
        return this;
    }

    public Integer getNoOfComments() {
        return noOfComments;
    }

    public void setNoOfComments(Integer noOfComments) {
        this.noOfComments = noOfComments;
    }

    public JobController withNoOfComments(Integer noOfComments) {
        this.noOfComments = noOfComments;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public JobController withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}