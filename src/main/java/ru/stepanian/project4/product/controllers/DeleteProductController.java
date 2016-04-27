package ru.stepanian.project4.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.product.entities.Product;
import ru.stepanian.project4.product.model.ProductModel;
import ru.stepanian.project4.service.ProjectService;
/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class DeleteProductController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProd(@ModelAttribute("productModel") ProductModel productModel,
                             @RequestParam(value = "id") Long id) {

        Product product = projectService.getProductById(id);

        projectService.deleteProduct(product);

        return "redirect:/addProductPage";
    }
}