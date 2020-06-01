package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    public UserController(){
        System.out.println("***UserController class***");
    }

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(Model model) {
        //model.addAttribute("user",new User());
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User",user);
        return "users/registration";
    }

    @RequestMapping(value="users/registration",method=RequestMethod.POST)
    public String registerUser(User user) {
        userService.registerUser(user);
        return "users/login";
    }



    @RequestMapping(value = "users/logout",method = RequestMethod.POST)
    public String logoutUser(Model model){
        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts",posts);

        return "index";
    }

    @RequestMapping(value="users/login", method=RequestMethod.POST)
    public String loginUser(User user) {
        User existingUser = userService.login(user);
        if(existingUser!=null) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }

    }
}
