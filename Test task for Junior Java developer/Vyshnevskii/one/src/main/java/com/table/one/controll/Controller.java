package com.table.one.controll;

import com.table.one.mod.Customer;
import com.table.one.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;


@org.springframework.stereotype.Controller
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CustomerService postServ;

    @GetMapping("/customers")
    public String findAll(Model model) {
        Iterable<Customer> posts = postServ.findAll();
        model.addAttribute("posts", posts);

        return "customersAll";

    }
    @GetMapping("/customerOne/{id}")
    	 public String findOne(Model model, @PathVariable("id") Long id) {
    	        Customer post = postServ.findById(id);
    	        model.addAttribute("post", post);
    	        return "customerOne";
    	    
    }
    @PostMapping("/customerOne/{id}")
    public String findOne( @PathVariable("id") Long id) {
        
        return "redirect:/api/customers";
    }
    
    @GetMapping("/customer")
    public String createPost(Model model) {
    	
        Customer newPost = new Customer();
        
        model.addAttribute("post", newPost);
        return "customer";
    }
    
   
   
	@PostMapping("/customer")
    public String crePost(@ModelAttribute("post") @Valid Customer post, BindingResult bR) {
    	
        if (bR.hasErrors())
            return "/customer";
        
        Iterable<Customer> posts = postServ.findAll();
        
        for (Customer post2 : posts) {
			if (post2.getEmail().equals(post.getEmail()))

				return "/customer1";
		}
       
        
       post.setCreated(post.getCreated()+1);
       post.setState(true);
        
        postServ.savePost(post);
       
        return "redirect:/api/customers";

    }
  

	 @GetMapping("/customer/{id}")
	    public String deletePost(@PathVariable("id") Long id) {
		 
		 Customer post = postServ.findById(id);
	    	
	    	post.setState(false);
	    
	    	
	        postServ.savePost(post);
	        
	       
	    	        
	    	            	        
	        return "redirect:/api/customers";
	    }
	   

    @GetMapping("/customers/{id}")
    public String updPost(Model model, @PathVariable("id") Long id) {
        Customer post = postServ.findById(id);
        
        
        model.addAttribute("post", post);
        return "customerUpdate";
    }

    @PostMapping("/customers/{id}")
    public String updatePost(@ModelAttribute("post") @Valid Customer post, BindingResult bindingResult,
                             @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "customerUpdate";

        
        post.setUpdated(post.getUpdated()+1);

        postServ.savePost(post);
        return "redirect:/api/customers";
    }
}
