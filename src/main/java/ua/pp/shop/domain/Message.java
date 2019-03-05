package ua.pp.shop.domain;
import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String productNumber;
    private String numberOfGoods;
    private String unitPrice;
    private String totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(String numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Message() {
    }

    public Message(String type, String name, String productNumber, String numberOfGoods, String unitPrice, String totalPrice, User user) {
        this.type = type;
        this.name = name;
        this.productNumber = productNumber;
        this.numberOfGoods = numberOfGoods;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.author = user;
    }
    public String getAuthorName(){
        return author !=null ? author.getUsername(): "<none>";
    }
}
