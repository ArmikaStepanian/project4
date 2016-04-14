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
    public String select(ModelMap model) {

        List<String> colors = productService.listColors();
        model.put("colors", colors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        ProductModel pm = new ProductModel();
        model.put("pm", pm);

        return "products";

    }

    @RequestMapping("/filter")
    public String processForm(@ModelAttribute("pm") ProductModel productModel, ModelMap model) {

        List<String> colors = productService.listColors();
        model.put("colors", colors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        List<Product> productByParameters = productService.getProductByParameters(productModel);
        model.put("productByParameters", productByParameters);

        return "products";
    }

    @RequestMapping("/showProduct")
    public String showOneProduct (@RequestParam("id") Long id, ModelMap model){
        model.put("id",id);

        Product product = productService.getById(id);
        model.put("product", product);


       return "showProduct";
    }



}
