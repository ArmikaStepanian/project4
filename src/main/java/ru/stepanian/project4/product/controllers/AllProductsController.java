package ru.stepanian.project4.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.product.helper.PaginationHelper;
import ru.stepanian.project4.product.model.ProductModel;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 13.04.2016.
 */

@Controller
public class AllProductsController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                        ModelMap model) {

        model.addAttribute("colors", projectService.listColors());
        model.addAttribute("categories", projectService.listCategories());
        model.addAttribute("features", projectService.listFeatures());

        model.addAttribute("productModel", new ProductModel());

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);
        long count = projectService.getCountAll();
        model.addAttribute("count", count);
        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(6);
        pageHelper.setCurrentPage(page);
        List <Product> products = projectService.getAllProdWithPagination(pageHelper.getResultsPerPage(),
                                                                          pageHelper.getCurrentPage());
        model.addAttribute("products", products);

        return "products";
    }
}
