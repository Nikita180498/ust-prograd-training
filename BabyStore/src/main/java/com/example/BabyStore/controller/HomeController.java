package com.example.BabyStore.controller;

import com.example.BabyStore.entity.User;
import com.example.BabyStore.service.CategoryService;
import com.example.BabyStore.service.ProductService;
import com.example.BabyStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    //HOME
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //REGISTRATION
    @GetMapping("/register")
    public String registrationForm(){
        return "register";
    }
    @PostMapping("/register")
    public String registration(HttpServletRequest request){
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        User user;
        if(username.equals("admin")){
            user = new User(username, password, name, email, address, contact, "ROLE_ADMIN");
        }
        else {
            user = new User(username, password,name,email, address, contact, "ROLE_USER");
        }
        userService.createUser(user);
        return "login";
    }

    //LOGIN
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

//        @PostMapping("/login")
//        public String login(HttpServletRequest request, Model model){
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            User user;
//            if (userService.existsById(username)){
//                user = userService.getByUsername(username);
//                if (password.equals(user.getPassword())){
//                    model.addAttribute("username",username);
//                    return "admin";
//                } else {
//                    model.addAttribute("message", "Wrong Password");
//                    return "login";
//                }
//            } else {
//                model.addAttribute("message", "Please enter valid User Name");
//                return "login";
//            }
//        }
    @RequestMapping("/success")
    public String login(Principal principal){
        String username = principal.getName();
        if (username.equals("admin")){
            return "redirect:/adminDashboard";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDresses(){
        return "dashboard";
    }


    @GetMapping("/categories")
    public String categories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("products", productService.getAllProduct());
        return "categories";
    }
































//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("/register")
//    public String registerForm() {
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        String contact = request.getParameter("contact");
//        User user;
//        if (username.equals("admin")) {
//            user = new User(username, password, name, email, address, contact, "ROLE_ADMIN");
//        } else {
//            user = new User(username, password, name, email, address, contact, "ROLE_USER");
//        }
//        userService.createUser(user);
//        return "redirect:/dashboard";
//    }
//
//    @GetMapping("/login")
//    public String loginForm() {
//        return "/login";
//    }
//
//    @PostMapping("/success")
//     public String login(Principal principal){
//        String username = principal.getName();
//        if(username.equals("admin")) {
//            return "redirect:/admin";
//        }
//        return"redirect:/dashboard";
//    }
//
////    @PostMapping("/login")
////    public String login(Model model, HttpServletRequest request){
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
////        User user;
////        if (userService.existsById(username) == true) {
////            user = userService.findById(username);
////            if (password.equals(user.getPassword())) {
////                model.addAttribute("name", user.getName());
////                model.addAttribute("username", user.getUsername());
////                model.addAttribute("email", user.getEmail());
////                model.addAttribute("address", user.getAddress());
////                model.addAttribute("contact", user.getContact());
////                return "dashboard";
////
////            } else {
////                model.addAttribute("errorMessage", "Incorrect Password.");
////                return "login";
////            }
////        } else {
////            model.addAttribute("errorMessage", "Please enter valid Username");
////            return "login";
////        }
////    }
//
//    @GetMapping("/dashboard")
//    public String dashboard(){
//        return "dashboard";
//    }
}
