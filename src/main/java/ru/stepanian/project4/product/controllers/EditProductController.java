package ru.stepanian.project4.product.controllers;

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
import ru.stepanian.project4.product.helper.CollectionHelper;
import ru.stepanian.project4.product.helper.PaginationHelper;
import ru.stepanian.project4.product.model.ProductModel;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class EditProductController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private CollectionHelper collectionHelper;

    @RequestMapping(value = "/editProductPage", method = RequestMethod.GET)
    public String editProductPage(@ModelAttribute("productModel") ProductModel productModel,
                                  @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                  @RequestParam(value = "id") Long id,
                                  ModelMap model) {

        Product existingProduct = projectService.getProductById(id);

        productModel.setName(existingProduct.getName());
        productModel.setColor(existingProduct.getColor().getName());
        productModel.setCategory(existingProduct.getCategory().getName());
        productModel.setFeature(existingProduct.getFeature().getName());

        model.addAttribute("productModel", productModel);

        model.addAttribute("colors", collectionHelper.getColors());
        model.addAttribute("categories", collectionHelper.getCategories());
        model.addAttribute("features", collectionHelper.getFeatures());

        PaginationHelper pageHelper = new PaginationHelper();
        model.addAttribute("pageHelper", pageHelper);
        long count = projectService.getCountAll();
        model.addAttribute("count", count);
        pageHelper.setCount(count);
        pageHelper.setResultsPerPage(20);
        pageHelper.setCurrentPage(page);
        List<Product> products = projectService.getAllProdWithPagination(pageHelper.getResultsPerPage(),
                                                                         pageHelper.getCurrentPage());
        model.addAttribute("products", products);

        return "forAdmin";
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public String editProd(@ModelAttribute("productModel") ProductModel productModel,
                           @RequestParam(value = "id") Long id,
                           @RequestParam(value = "color") Integer colorId,
                           @RequestParam(value = "category") Integer categoryId,
                           @RequestParam(value = "feature") Byte featureId) {

        Product product = new Product();
        product.setId(id);
        product.setName(productModel.getName());
        product.setColor(new Colors(colorId));
        product.setCategory(new Category(categoryId));
        product.setFeature(new Feature(featureId));

        projectService.updateProduct(product);

        return "redirect:/addProductPage";
    }
}
