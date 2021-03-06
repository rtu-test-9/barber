package barber.services;

import barber.dao.CommentDAO;
import barber.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentDAO commentDAO;

    @Autowired
    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public List<Comment> find3LastComments() {
        return commentDAO.findTop3ByOrderByIdDesc();
    }
}