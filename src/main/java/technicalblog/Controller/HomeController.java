package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    public HomeController(){
        System.out.println("****Home Controller class****");
    }

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    //@ResponseBody
    public String getAllPosts(Model model){

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts",posts);

        return "index";
    }
}
