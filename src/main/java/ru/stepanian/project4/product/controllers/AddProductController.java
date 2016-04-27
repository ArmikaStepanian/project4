package ru.stepanian.project4.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.product.entities.Category;
import ru.stepanian.project4.product.entities.Colors;
import ru.stepanian.project4.product.entities.Feature;
import ru.stepanian.project4.product.entities.Product;
import ru.stepanian.project4.product.helper.PaginationHelper;
import ru.stepanian.project4.product.model.ProductModel;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class AddProductController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/addProductPage", method = RequestMethod.GET)
    public String addProductPage (@ModelAttribute("productModel") ProductModel productModel,
                                  @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                  ModelMap model){

        model.addAttribute("colors", projectService.listColors());
        model.addAttribute("categories", projectService.listCategories());
        model.addAttribute("features", projectService.listFeatures());

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);
        long count = projectService.getCountAll();
        model.addAttribute("count", count);
        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(20);
        pageHelper.setCurrentPage(page);
        List <Product> products = projectService.getAllProdWithPagination(pageHelper.getResultsPerPage(),
                                                                          pageHelper.getCurrentPage());
        model.addAttribute("products", products);

        return "forAdmin";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProd (@ModelAttribute("productModel") ProductModel productModel,
                           @RequestParam(value = "color") Integer colorId,
                           @RequestParam(value = "category") Integer categoryId,
                           @RequestParam(value = "feature") Byte featureId) {

        Product product = new Product();

        product.setName(productModel.getName());
        product.setColor(new Colors(colorId));
        product.setCategory(new Category(categoryId));
        product.setFeature(new Feature(featureId));

        projectService.addProduct(product);

        return "redirect:/addProductPage";
    }
}
