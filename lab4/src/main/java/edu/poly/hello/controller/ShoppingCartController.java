package edu.poly.hello.controller;

import edu.poly.hello.model.CartItem;
import edu.poly.hello.model.Product;
import edu.poly.hello.service.ProductService;
import edu.poly.hello.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("list")
    public String list(Model model){
        Collection<CartItem> cartItems = shoppingCartService.getCartItems();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total",shoppingCartService.getAmount());
        model.addAttribute("NoOfItems", shoppingCartService.getCount());
        String s = "shoppingCarts/list";
        return s;
    }

    @GetMapping("add/{productId}")
    public String add(@PathVariable("productId") Integer productId){
        Product product = productService.findByid(productId);

        System.out.println("product findByid: "+ product);

        if(product != null){ //ví dụ kết quả là (5, t-shirt)
            CartItem item = new CartItem();
            BeanUtils.copyProperties(product, item); //dùng beanutils để copy thuộc tính product sang item. Tránh dùng getter, setter nhiều lần  dsf
            System.out.println("item's value: "+ item);
            item.setQuantity(1);  //Lần đầu tiên thì sẽ là có 1 product trong cart
            System.out.println("item quantity: " + item.getQuantity());
            shoppingCartService.add(item);
        }

        return "redirect:/shoppingCart/list";
    }

    @GetMapping("remove/{productId}")
    public String remove(@PathVariable("productId") Integer productId){
        shoppingCartService.remove(productId);

        return "redirect:/shoppingCart/list";
    }

    @PostMapping("update/{productId}")
    public String update(@PathVariable("productId") Integer productId,
        @RequestParam("quantity") Integer quantity){
        shoppingCartService.update(productId, quantity);

        System.out.println("(productId, quantity) value: "+ productId + quantity);
        return "redirect:/shoppingCart/list";
    }

    @GetMapping("clear")
    public String clear(){
        return "redirect:/shoppingCart/list";
    }
}

