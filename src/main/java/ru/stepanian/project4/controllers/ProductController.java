package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /*@RequestMapping("/products")*//*
    @RequestMapping("/")
    public String select(ModelMap model) {

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        ProductModel pm = new ProductModel();
        model.addAttribute("pm", pm);

        return "products";

    }*/


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                        @RequestParam(value = "name", defaultValue = "", required = false) String name,
                        @RequestParam(value = "color", defaultValue = "", required = false) String color,
                        @RequestParam(value = "category", defaultValue = "", required = false) String category,
                        @RequestParam(value = "feature", defaultValue = "", required = false) String feature,
                        ModelMap model) {

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel", productModel);
        productModel.setName(name);
        productModel.setColor(color);
        productModel.setCategory(category);
        productModel.setFeature(feature);

        Pagination pagination = new Pagination();
        model.addAttribute("pagination",pagination);
        long count = productService.getCount();
        model.addAttribute("count",count);
        pagination.setCount(count);
        pagination.setResultsPerPage(1);
        pagination.setCurrentPage(page);
        List products;
        products = productService.pagination(pagination.getResultsPerPage(), pagination.getCurrentPage());
        model.addAttribute("products", products);

        return "products";
    }
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String processForm(@ModelAttribute("productModel") ProductModel productModel,
                              @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                              @RequestParam(value = "name", defaultValue = "", required = false) String name,
                              @RequestParam(value = "color", defaultValue = "", required = false) String color,
                              @RequestParam(value = "category", defaultValue = "", required = false) String category,
                              @RequestParam(value = "feature", defaultValue = "", required = false) String feature,
                              ModelMap model) {
        productModel.setName(name);
        productModel.setColor(color);
        productModel.setCategory(category);
        productModel.setFeature(feature);

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);
        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        Pagination pagination = new Pagination();
        model.addAttribute("pagination",pagination);
        long count = productService.getCount2(productModel.getName(),productModel.getColor(),
                productModel.getCategory(),productModel.getFeature());
        model.addAttribute("count",count);
        pagination.setCount(count);
        pagination.setResultsPerPage(1);
        pagination.setCurrentPage(page);
        List products;
        products = productService.getProductByParameters(productModel.getName(),productModel.getColor(),
                                                         productModel.getCategory(),productModel.getFeature(),
                                                         pagination.getResultsPerPage(), pagination.getCurrentPage());

        model.addAttribute("products", products);

        return "products";
    }

    @RequestMapping("/showProduct")
    public String showOneProduct (@RequestParam("id") Long id, ModelMap model){

        Product product = productService.getById(id);
        model.put("product", product);

        return "showProduct";
    }



}
