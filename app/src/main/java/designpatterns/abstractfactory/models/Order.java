package designpatterns.abstractfactory.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.UUID;
import designpatterns.abstractfactory.models.products.Product;

public class Order {
    private final UUID id;
    private final List<Product> products = new ArrayList<Product>();
    private LocalDateTime createdAt = LocalDateTime.now();

    public Order() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean getIsReadyForDelivery() {
        return this.products.stream().allMatch(x -> createdAt.plusDays(x.getShippingDayCount()).compareTo(LocalDateTime.now()) < 0);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void updateCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int totalWeight() {
        return this.products.stream().mapToInt(x -> x.getWeight()).sum();
    }

    @Override
    public String toString() {
        return String
            .format("\t[Id] : %s \n"
                   + "\t\tProducts : \n %s \n"
                   + "[Is Ready For Delivery] : %s [Created At] : %s \n",
                   this.id.toString(),
                   String.join(" ", this.products.stream().map(x -> x.toString()).toList()),
                   getIsReadyForDelivery(),
                   this.createdAt.format(DateTimeFormatter.ofPattern("dd/M/yyyy hh:mm")).toString()
                   );
    }
}
