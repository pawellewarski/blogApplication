package pl.akademiakodu.blogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.blogApplication.model.entities.Post;
import pl.akademiakodu.blogApplication.ropository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/posts")
    public String postPage(Model model) {


        List<Post> postList = new ArrayList<>();

        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable) {
            postList.add(post);

        }

        model.addAttribute("posts", postList);
        return "posts";
    }


}
