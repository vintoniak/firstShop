package ua.pp.shop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.shop.domain.Message;
import ua.pp.shop.repos.MessageRepo;

import java.util.List;
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
        Message messages = new Message(type, name, productNumber, numberOfGoods, unitPrice, totalPrice);
        messages.setType(type);
        messages.setName(name);
        messages.setProductNumber(productNumber);
        messages.setNumberOfGoods(numberOfGoods);
        messages.setUnitPrice(unitPrice);
        messages.setTotalPrice(totalPrice);
        messageRepo.save(messages);
        model.put("message", messages);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String type, Map<String,Object> model){
        Iterable<Message> messages;
        if(type != null && !type.isEmpty()){
             messages = messageRepo.findByType(type);
        } else{
            messages = messageRepo.findAll();
        }


        model.put("message", messages);
        return "main";
    }
}