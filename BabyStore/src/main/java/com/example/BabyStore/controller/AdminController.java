package com.example.BabyStore.controller;

import com.example.BabyStore.entity.Category;
import com.example.BabyStore.entity.Product;
import com.example.BabyStore.service.CategoryService;
import com.example.BabyStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


//    @RequestMapping("/admin")
//    public String viewHomePage(Model model) {
//        List<Product> listProducts = productService.listAll();
//        model.addAttribute("listProducts", listProducts);
//
//        return "admin";
//    }

    @RequestMapping("/adminDashboard")
    public String adminDashboard(){
        return "adminDashboard";
    }

    @GetMapping("/addCategory")
    public String addCategoryForm() {
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category category = new Category(name,description);
        categoryService.save(category);
        model.addAttribute("msg", "added");
        return "adminDashboard";
    }


    @GetMapping("/addProduct")
    public String showAddProduct(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories",categoryService.getAllCategories());
        return "addProduct";
    }

//    @PostMapping("/addProduct")
//    public String addProduct(HttpServletRequest request, Model model) {
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//        String price = request.getParameter("price");
//        String size = request.getParameter("size");
//        String quantity = request.getParameter("name");
//        String image = request.getParameter("image");
//        Product product = new Product(name,description,price,size,quantity,image);
//        productService.save(product);
//        model.addAttribute("category",categoryService.getAllCategories());
//        model.addAttribute("msg", "added");
//        return "adminDashboard";
//    }

//    @RequestMapping("/update/{id}")
//    public ModelAndView update(@PathVariable(name = "id") Long id) {
//        ModelAndView mav = new ModelAndView("update");
//
//        Product product = productService.get(id);
//        mav.addObject("product", product);
//
//        return mav;
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable(name = "id") Long id) {
//        productService.delete(id);
//
//        return "redirect:/admin";
//    }
}
