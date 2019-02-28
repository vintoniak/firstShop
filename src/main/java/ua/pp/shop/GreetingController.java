package ua.pp.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.shop.domain.Message;
import ua.pp.shop.repos.MessageRepo;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String type, @RequestParam String name,
            @RequestParam String productNumber,@RequestParam Integer numberOfGoods,
            @RequestParam Double unitPrice,@RequestParam Double totalPrice,
            Map<String,Object> model
    ) {
        model.put("type", type);
        model.put("name", name);
        model.put("productNumber", productNumber);
        model.put("numberOfGoods", numberOfGoods);
        model.put("unitPrice", unitPrice);
        model.put("totalPrice", totalPrice);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String type, @RequestParam String name,
                      @RequestParam String productNumber,@RequestParam Integer numberOfGoods,
                      @RequestParam Double unitPrice,@RequestParam Double totalPrice, Map<String,Object> model){
        Message message = new Message(type, name, productNumber, numberOfGoods, unitPrice, totalPrice);
        message.setType(type);
        message.setName(name);
        message.setProductNumber(productNumber);
        message.setNumberOfGoods(numberOfGoods);
        message.setUnitPrice(unitPrice);
        message.setTotalPrice(totalPrice);
        messageRepo.save(message);
        model.put("message", message);
        return "main";
    }

}