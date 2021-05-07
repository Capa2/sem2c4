package business.entities;

public class Response {
    User employee;
    Query query;
    String message;
    float price;

    public Response(User employee, Query query, String message, float price) {
        this.employee = employee;
        this.query = query;
        this.message = message;
        this.price = price;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
