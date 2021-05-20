package business.entities;

public class Response {
    int id, queryId, userId;
    String message;
    double price;

    public Response(int queryId, int userId, String message) {
        this.queryId = queryId;
        this.userId = userId;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Response " + "id: " + id + ", queryId: " + queryId + ", userId: " + userId + ", message: " + message + ", price: " + price;
    }
}
