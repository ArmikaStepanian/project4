package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.*;
import ru.stepanian.project4.model.ProductModel;
import ru.stepanian.project4.service.ProductService;

import java.util.List;

/**
 * Created by Stepanian on 13.04.2016.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                        ModelMap model) {

        List<Colors> colors = productService.listColors();
        model.addAttribute("colors", colors);
        List<Category> categories = productService.listCategories();
        model.addAttribute("categories", categories);
        List<Feature> features = productService.listFeatures();
        model.addAttribute("features", features);

        model.addAttribute("productModel", new ProductModel());

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);

        long count = productService.getCountAll();
        model.addAttribute("count", count);

        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(6);
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

        List<Colors> colors = productService.listColors();
        model.addAttribute("colors", colors);
        List<Category> categories = productService.listCategories();
        model.addAttribute("categories", categories);
        List<Feature> features = productService.listFeatures();
        model.addAttribute("features", features);

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);

        long count = productService.getCountByParameters(productModel.getName(), productModel.getColor(),
                                                         productModel.getCategory(), productModel.getFeature());
        model.addAttribute("count", count);

        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(6);
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
