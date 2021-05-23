package barber.services;

import barber.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> find3LastComments();
}
