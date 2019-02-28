package ua.pp.shop.domain;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private  String type;
    private String name;
    private String productNumber;
    private Integer numberOfGoods;
    private Double unitPrice;
    private Double totalPrice;

    public Message() {
    }

    public Message(String type, String name, String productNumber, Integer numberOfGoods, Double unitPrice, Double totalPrice) {
        this.type = type;
        this.name = name;
        this.productNumber = productNumber;
        this.numberOfGoods = numberOfGoods;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", numberOfGoods=" + numberOfGoods +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Integer getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(Integer numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
