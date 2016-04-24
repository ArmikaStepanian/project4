package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;
import ru.stepanian.project4.service.ProductService;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class DeleteProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProd(@ModelAttribute("productModel") ProductModel productModel,
                              @RequestParam(value = "id") Long id) {

        Product product = productService.getProductById(id);

        productService.deleteProduct(product);

        return "redirect:/addProductPage";
    }
}