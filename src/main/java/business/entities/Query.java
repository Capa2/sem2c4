package business.entities;

public class Query {
    User customer;
    Carport carport;
    String status, mesage;

    public Query(User customer, Carport carport, String status, String mesage) {
        this.customer = customer;
        this.carport = carport;
        this.status = status;
        this.mesage = mesage;
    }

    public Query(User customer, Carport carport, String status) {
        this.customer = customer;
        this.carport = carport;
        this.status = status;
    }
}
