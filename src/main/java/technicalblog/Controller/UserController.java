package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    public UserController(){
        System.out.println("***UserController class***");
    }

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "users/logout",method = RequestMethod.POST)
    public String logoutUser(Model model){
        ArrayList<Post> posts = postService.getAllPosts();

        model.addAttribute("posts",posts);

        return "index";
    }

    @RequestMapping(value="users/login", method=RequestMethod.POST)
    public String loginUser(User user) {
        return "redirect:/posts";
    }
}
