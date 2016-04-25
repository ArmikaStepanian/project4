package ru.stepanian.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.service.ProjectService;

/**
 * Created by Stepanian on 21.04.2016.
 */

@Controller
public class OneProductController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/showProduct", method = RequestMethod.GET)
    public String showOneProduct (@RequestParam("id") Long id,
                                  ModelMap model) throws NullPointerException {

        Product product = projectService.getProductById(id);
        if (! (product.equals(null)))
            model.addAttribute("product", product);
        return "showProduct";
    }
}
