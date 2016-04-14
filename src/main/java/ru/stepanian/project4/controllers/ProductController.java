package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;
import ru.stepanian.project4.service.ProductService;

import java.util.List;

/**
 * Created by 1 on 13.04.2016.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String select(ModelMap map) {

        List<String> colors = productService.listColors();
        map.put("colors", colors);

        ProductModel pm = new ProductModel();
        map.put("pm", pm);

        return "products";

    }

    @RequestMapping("/filter")
    public String processForm(@ModelAttribute("pm") ProductModel productModel, ModelMap map) {

        List<String> colors = productService.listColors();
        map.put("colors", colors);

        List<Product> productByParameters = productService.getProductByParameters(productModel);
        map.put("productByParameters", productByParameters);

         return "products";
    }

    @RequestMapping("/showProduct")
    public String showOneProduct (@RequestParam("id") Long id, ModelMap model){
       model.put("id",id);

        return "showProduct";
    }



}
