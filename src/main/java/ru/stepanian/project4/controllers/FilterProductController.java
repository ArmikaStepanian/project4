package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.helper.PaginationHelper;
import ru.stepanian.project4.model.ProductModel;
import ru.stepanian.project4.service.ProductService;

import java.util.List;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class FilterProductController {

    @Autowired
    private ProductService productService;

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

        model.addAttribute("colors", productService.listColors());
        model.addAttribute("categories", productService.listCategories());
        model.addAttribute("features", productService.listFeatures());

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

}
