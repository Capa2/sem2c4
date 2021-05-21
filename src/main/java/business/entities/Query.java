package business.entities;

public class Query {
    int id, userId, carportId, wantBuilder;
    String status, message;

    public Query(int userId, int carportId, String status, String message, int wantBuilder) {
        this.userId = userId;
        this.carportId = carportId;
        this.status = status;
        this.message = message;
        this.wantBuilder = wantBuilder;
    }

    public Query(int id, int userId, int carportId, String status, String message, int wantBuilder) {
        this.id = id;
        this.userId = userId;
        this.carportId = carportId;
        this.status = status;
        this.message = message;
        this.wantBuilder = wantBuilder;
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

    public int getWantBuilder() { return wantBuilder; }

    public void setWantBuilder(int wantBuilder) { this.wantBuilder = wantBuilder; }

    @Override
    public String toString() {
        return "Query id: " + id +
                " userId: " + userId +
                ", carportId: " + carportId +
                ", status: " + status +
                ", message: " + message;
    }

}
