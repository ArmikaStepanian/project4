package ru.stepanian.project4.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.product.helper.PaginationHelper;
import ru.stepanian.project4.product.model.ProductModel;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class FilterProductController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private PaginationHelper pageHelper;

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String doFilter(@ModelAttribute("productModel") ProductModel productModel,
                           @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                           ModelMap model) {

        model.addAttribute("colors", projectService.listColors());
        model.addAttribute("categories", projectService.listCategories());
        model.addAttribute("features", projectService.listFeatures());

        model.addAttribute("pageHelper", pageHelper);
        long count = projectService.getCountByParameters(productModel.getName(), productModel.getColor(),
                                                         productModel.getCategory(), productModel.getFeature());
        model.addAttribute("count", count);
        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(6);
        pageHelper.setCurrentPage(page);
        List <Product> products = projectService.getProdByParamWithPagination(productModel.getName(), productModel.getColor(),
                                                                              productModel.getCategory(), productModel.getFeature(),
                                                                              pageHelper.getResultsPerPage(), pageHelper.getCurrentPage());

        model.addAttribute("products", products);

        return "products";
    }
}
