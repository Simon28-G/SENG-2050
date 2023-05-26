package pkg;

import java.util.Date;

/**
 * Class describing a comment, either on an issue or on a Knowledge-Base article.
 */
public class CommentBean {

    /**
     * Identification number for the comment
     */
    private int commentId;
    /**
     * Identification number for the user posting the comment.
     */
    private int userId;
    /**
     * Comment's content.
     */
    private String text;
    /**
     * Date of submission.
     */
    private Date date;



    public void create() {

    }
    

    public void reply() {
        
    }






    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

