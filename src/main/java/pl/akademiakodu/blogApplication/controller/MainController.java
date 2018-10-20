package pl.akademiakodu.blogApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.blogApplication.model.entities.Post;
import pl.akademiakodu.blogApplication.model.entities.PostComment;
import pl.akademiakodu.blogApplication.ropository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String home(){

        return "home";
    }

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

    @GetMapping("/addPost")
    public String addPost(){

        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam(value = "title") String titleParam,
                          @RequestParam(value = "content") String content) {
        Post post = new Post(titleParam, content);
        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);

        post.addComment(postComment);
        postRepository.save(post);



        return "index";
    }


}
