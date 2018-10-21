package pl.akademiakodu.blogApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.blogApplication.model.entities.Post;
import pl.akademiakodu.blogApplication.model.entities.PostComment;
import pl.akademiakodu.blogApplication.ropository.PostRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/post/{id}")
    public String post(@PathVariable Long id,
                       Model model) {
        Optional<Post> postOptional = postRepository.findById(id);

        postOptional.ifPresent(post -> {
            model.addAttribute("post", post);
        });


        return "post";
    }

    @Transactional
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable Long id) {

        postRepository.deleteById(id);

        return ("Usunięto " + id);
    }


    @PostMapping("/post/addComment")
    public String addComment(@RequestParam String commentBody,
                             @RequestParam Long postId) {
        PostComment postComment = new PostComment();

        postComment.setComment(commentBody);


        Optional<Post> postOptional = postRepository.findById(postId);
        postOptional.ifPresent(post -> {
            post.addComment(postComment);
            postRepository.save(post);
        });

        return "redirect:/post/" + postId;
    }


}
