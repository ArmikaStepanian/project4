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
                        ModelMap model) {

        List products;
        Pagination pagination = new Pagination();
        long count = productService.getCount();
        pagination.setCount(count);
        pagination.setResultsPerPage(1);
        pagination.setCurrentPage(page);

        products = productService.pagination(pagination.getResultsPerPage(), pagination.getCurrentPage());
        model.addAttribute("count",count);
        model.addAttribute("pagination",pagination);
        model.addAttribute("products", products);

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);

        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel", productModel);

        return "products";
    }

    @RequestMapping("/filter")
    public String processForm(@ModelAttribute("productModel") ProductModel productModel,
                              ModelMap model) {

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);




        return "products";
    }
    @RequestMapping("/pages")
    public String showOneProduct (@RequestParam("selectedPageNumber") int selectedPageNumber,
                                  @ModelAttribute("productModel") ProductModel productModel,
                                  ModelMap model) {

        List<String> listColors = productService.getListColors();
        model.put("listColors", listColors);

        List<String> categories = productService.listCategories();
        model.put("categories", categories);
        /*List<Product> productByParameters = productService.getProductByParameters(productModel);
        model.put("productByParameters", productByParameters);*/

        return "products";
    }

    @RequestMapping("/showProduct")
    public String showOneProduct (@RequestParam("id") Long id, ModelMap model){

        Product product = productService.getById(id);
        model.put("product", product);

        return "showProduct";
    }



}
