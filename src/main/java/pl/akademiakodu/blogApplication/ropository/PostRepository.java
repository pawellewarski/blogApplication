package pl.akademiakodu.blogApplication.ropository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.blogApplication.model.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
