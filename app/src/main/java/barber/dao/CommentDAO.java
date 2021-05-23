package barber.dao;

import barber.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentDAO extends CrudRepository<Comment, Long> {
    List<Comment> findTop3ByOrderByIdDesc();
}