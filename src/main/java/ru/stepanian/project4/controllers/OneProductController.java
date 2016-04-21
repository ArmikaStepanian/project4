package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Category;
import ru.stepanian.project4.entities.Colors;
import ru.stepanian.project4.entities.Feature;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;
import ru.stepanian.project4.service.ProductService;

import java.util.List;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class OneProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/showProduct", method = RequestMethod.GET)
    public String showOneProduct (@RequestParam("id") Long id,
                                  ModelMap model) throws NullPointerException {

        Product product = productService.getProductById(id);
        if (! (product.equals(null)))
            model.addAttribute("product", product);
        return "showProduct";
    }

    @RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
    public String addProductPage (@ModelAttribute("productModel") ProductModel productModel,
                                  ModelMap model){

        List<Colors> colors = productService.listColors();
        model.addAttribute("colors", colors);
        List<Category> categories = productService.listCategories();
        model.addAttribute("categories", categories);
        List<Feature> features = productService.listFeatures();
        model.addAttribute("features", features);

        return "forAdmin";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct (@ModelAttribute("productModel") ProductModel productModel,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "color") Integer colorId,
                              @RequestParam(value = "category") Integer categoryId,
                              @RequestParam(value = "feature") Byte featureId,
                              ModelMap model){

        List<Colors> colors = productService.listColors();
        model.addAttribute("colors", colors);
        List<Category> categories = productService.listCategories();
        model.addAttribute("categories", categories);
        List<Feature> features = productService.listFeatures();
        model.addAttribute("features", features);

        Product product = new Product();
        product.setName(name);
        product.setColor(new Colors(colorId));
        product.setCategory(new Category(categoryId));
        product.setFeature(new Feature(featureId));

        productService.addProduct(product);

        return "forAdmin";

    }

}
