package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Query {
    int id, userId, carportId;
    String status, message;

    public Query(int userId, int carportId, String status, String message) {
        this.userId = userId;
        this.carportId = carportId;
        this.status = status;
        this.message = message;
    }

    public Query(int id, int userId, int carportId, String status, String message) {
        this.id = id;
        this.userId = userId;
        this.carportId = carportId;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarportId() { return carportId; }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Query id: " + id +
                " userId: " + userId +
                ", carportId: " + carportId +
                ", status: " + status +
                ", message: " + message;
    }

}
