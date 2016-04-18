package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                        ModelMap model) {

        List<String> colors = productService.listColors();
        model.addAttribute("colors", colors);

        List<String> categories = productService.listCategories();
        model.addAttribute("categories", categories);

        ProductModel productModel = new ProductModel();
        model.addAttribute("productModel", productModel);

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);

        long count = productService.getCountAll();
        model.addAttribute("count", count);

        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(1);
        pageHelper.setCurrentPage(page);
        List <Product> products = productService.getAllProdWithPagination(pageHelper.getResultsPerPage(), pageHelper.getCurrentPage());
        model.addAttribute("products", products);

        return "products";
    }
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String doFilter(@ModelAttribute("productModel") ProductModel productModel,
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

        List<String> colors = productService.listColors();
        model.addAttribute("colors", colors);

        List<String> categories = productService.listCategories();
        model.addAttribute("categories", categories);

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);

        long count = productService.getCountByParameters(productModel.getName(), productModel.getColor(),
                                                         productModel.getCategory(), productModel.getFeature());
        model.addAttribute("count", count);

        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(1);
        pageHelper.setCurrentPage(page);
        List <Product> products = productService.getProdByParamWithPagination(productModel.getName(), productModel.getColor(),
                                                                              productModel.getCategory(), productModel.getFeature(),
                                                                              pageHelper.getResultsPerPage(), pageHelper.getCurrentPage());

        model.addAttribute("products", products);

        return "products";
    }

    @RequestMapping(value = "/showProduct", method = RequestMethod.GET)
    public String showOneProduct (@RequestParam("id") Long id,
                                  ModelMap model) throws NullPointerException {

            Product product = productService.getProductById(id);
            if (! (product.equals(null)))
                model.addAttribute("product", product);
            return "showProduct";
    }

}
