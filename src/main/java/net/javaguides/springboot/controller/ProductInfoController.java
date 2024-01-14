package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.service.ProductInfoService;
import java.util.List;

@Controller
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/pie-chart")
    public String showPieChart(Model model) {
        List<ProductInfo> productInfoList = productInfoService.getAllProductInfo();
        // Add productInfoList to the model for Thymeleaf rendering
        model.addAttribute("productInfoList", productInfoList);
        return "pie-chart";
    }
    
}
