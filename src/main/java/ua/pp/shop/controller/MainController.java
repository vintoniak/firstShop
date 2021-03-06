package ua.pp.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.pp.shop.domain.Message;
import ua.pp.shop.domain.User;
import ua.pp.shop.repos.MessageRepo;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

     /* @GetMapping("/greeting")
    public String greeting(
            @RequestParam String type, @RequestParam String name,
            @RequestParam String productNumber,@RequestParam String numberOfGoods,
            @RequestParam String unitPrice,@RequestParam String totalPrice,
            Map<String,Object> model
    ) {
        Message messages = new Message(type, name, productNumber, numberOfGoods, unitPrice, totalPrice);
      model.put("type", type);
        model.put("name", name);
        model.put("productNumber", productNumber);
        model.put("numberOfGoods", numberOfGoods);
        model.put("unitPrice", unitPrice);
        model.put("totalPrice", totalPrice);
        id_UNIQUEmodel.put("messages", messages);
        return "greeting";
    } */

    @GetMapping("/")
    public String greeting( Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Message> messages = messageRepo.findAll();
        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByType(filter);
        } else{
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String type,
            @RequestParam String name,
            @RequestParam String productNumber,
            @RequestParam String numberOfGoods,
            @RequestParam String unitPrice,
            @RequestParam String totalPrice,
            Map<String,Object> model){
        Message messages = new Message(type, name, productNumber, numberOfGoods, unitPrice, totalPrice, user);
        messages.setType(type);
        messages.setName(name);
        messages.setProductNumber(productNumber);
        messages.setNumberOfGoods(numberOfGoods);
        messages.setUnitPrice(unitPrice);
        messages.setTotalPrice(totalPrice);
        messages.setAuthor(user);
        messageRepo.save(messages);
        Iterable<Message> message = messageRepo.findAll();
        model.put("messages", message);
        return "main";
    }


}