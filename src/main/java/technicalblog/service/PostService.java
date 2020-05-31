package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostService(){
        System.out.println("****PostService class****");
    }

    public List<Post> getAllPosts() {

        return repository.getAllPosts();
    }

    public Post getOnePost() {

        ArrayList<Post> posts = new ArrayList<Post>();
////
////        Post post1 = new Post();
////        post1.setTitle("This is your first post.");
////        post1.setBody("This is your post. has some valid content");
////        post1.setDate(new Date());
////
////        posts.add(post1);
//
//        try {
//            Class.forName("org.postgresql.Driver");
//
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","password");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from posts where id=4");
//            while (rs.next()) {
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        return repository.getLatestPost();

    }

    public void createPost(Post newPost) {
        Date date = new Date();
        newPost.setDate(date);
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);

    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
