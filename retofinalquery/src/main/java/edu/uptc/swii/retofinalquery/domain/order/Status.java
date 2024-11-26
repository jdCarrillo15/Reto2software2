package edu.uptc.swii.retofinalquery.domain.order;

public class Status {
    private String status;
    private String description;

    public Status() {
    }

    public Status(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Status [status=" + status + ", description=" + description + "]";
    }
}
