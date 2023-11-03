// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Blog;
// import com.example.demo.repository.BlogRepository;

// import lombok.AllArgsConstructor;

// @AllArgsConstructor
// @RestController
// @RequestMapping( "api/Blogs")
// public class BlogController {
//     private BlogRepository BlogRepository;
//     @GetMapping("/all")
//     public java.util.List<Blog> getAllUsers(){
//         return BlogRepository.findAll();
//     }
//     @PostMapping("/newblog")
//     public String createNewBlog(Blog newblog){
//         BlogRepository.save(newblog);
//         return "New User Blog Post!";
//     }

// }