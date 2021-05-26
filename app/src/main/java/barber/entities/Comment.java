package barber.entities;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorAvatarName(String authorAvatarName) {
        this.authorAvatarName = authorAvatarName;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Long getId() {
        return id;
    }

    @Column(name="body", length = 1000)
    private String commentBody;

    @Column(name="authorName")
    private String authorName;

    @Column(name="authorAvatar")
    private String authorAvatarName;

    public String getAuthorName() {
        return authorName;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthorAvatarName() {
        return authorAvatarName;
    }
}
