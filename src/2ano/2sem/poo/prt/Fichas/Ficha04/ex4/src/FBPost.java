import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FBPost {
    private int id;
    private String user;
    private LocalDateTime postedOn;
    private String content;
    private int likes;
    private List<String> comments;

    public FBPost(){
        this.id = -1;
        this.user = null;
        this.postedOn = null;
        this.content = null;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public FBPost(int id, String user, LocalDateTime postedOn,
                  String content, int likes, List<String> comments) {
        this.id = id;
        this.user = user;
        setPostedOn(postedOn);
        this.content = content;
        this.likes = likes;
        setComments(comments);
    }

    public FBPost(FBPost fbPost){
        setId(fbPost.getId());
        setUser(fbPost.getUser());
        setPostedOn(fbPost.getPostedOn());
        setContent(fbPost.getContent());
        setLikes(fbPost.getLikes());
        setComments(fbPost.getComments());
    }

    public void addComment(String comment){
        this.comments.add(comment);
    }

    public int nrComments(){
        return this.comments.size();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getPostedOn() {
        return LocalDateTime.of(
                this.postedOn.getYear(),
                this.postedOn.getMonth(),
                this.postedOn.getDayOfMonth(),
                this.postedOn.getHour(),
                this.postedOn.getMinute(),
                this.postedOn.getSecond(),
                this.postedOn.getNano()
        );
    }

    public void setPostedOn(LocalDateTime postedOn) {
        this.postedOn = LocalDateTime.of(
                postedOn.getYear(),
                postedOn.getMonth(),
                postedOn.getDayOfMonth(),
                postedOn.getHour(),
                postedOn.getMinute(),
                postedOn.getSecond(),
                postedOn.getNano()
        );;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return new ArrayList<>(this.comments);
    }

    public void setComments(List<String> comments) {
        this.comments = new ArrayList<>(comments);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FBPost fbPost = (FBPost) o;

        if (getId() != fbPost.getId()) return false;
        if (getLikes() != fbPost.getLikes()) return false;
        if (getUser() != null ? !getUser().equals(fbPost.getUser()) : fbPost.getUser() != null) return false;
        if (getPostedOn() != null ? !getPostedOn().equals(fbPost.getPostedOn()) : fbPost.getPostedOn() != null) return false;
        if (getContent() != null ? !getContent().equals(fbPost.getContent()) : fbPost.getContent() != null) return false;
        return getComments() != null ? getComments().equals(fbPost.getComments()) : fbPost.getComments() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getPostedOn() != null ? getPostedOn().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + getLikes();
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    protected FBPost clone() {
        return new FBPost(this);
    }

    @Override
    public String toString() {
        return "FBPost{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", postedOn=" + postedOn +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
