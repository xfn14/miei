import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> timeline;

    public FBFeed(){
        this.timeline = new ArrayList<>();
    }

    public FBFeed(List<FBPost> timeline) {
        setTimeline(timeline);
    }

    public FBFeed(FBFeed fbFeed){
        setTimeline(fbFeed.getTimeline());
    }

    public void addPost(FBPost post){
        this.timeline.add(post.clone());
    }

    public int nrPosts(String user){
        int counter = 0;
        for(FBPost post : this.timeline)
            if(post.getUser().equals(user))
                counter++;
        return counter;
    }

    public List<FBPost> postsOf(String user){
        List<FBPost> posts = new ArrayList<>();
        for(FBPost post : this.timeline)
            if(post.getUser().equals(user))
                posts.add(post.clone());
        return posts;
    }

    public List<FBPost> postsOf(String user, LocalDateTime start, LocalDateTime end){
        List<FBPost> posts = new ArrayList<>(postsOf(user));
        for(FBPost post : posts)
            if(start.isBefore(post.getPostedOn())
            && end.isAfter(post.getPostedOn()))
                posts.add(post.clone());
        return posts;
    }

    public FBPost getPost(int id){
        for(FBPost post : this.timeline)
            if(post.getId() == id)
                return post.clone();
        return null;
    }

    public void comment(FBPost post, String comment){
        int search = searchPost(post);
        post.addComment(comment);
        if(search == -1) this.timeline.add(post.clone());
        else this.timeline.set(search, post.clone());
    }

    public void comment(int postId, String comment){
        comment(getPost(postId), comment);
    }

    public void like(FBPost post){
        int search = searchPost(post);
        post.setLikes(post.getLikes()+1);
        if(search == -1) this.timeline.add(post.clone());
        else this.timeline.set(search, post.clone());
    }

    public void like(int postId){
        like(getPost(postId));
    }

    public List<Integer> top5Comments(){
        List<FBPost> sortedPosts = this.timeline.stream()
                .sorted(Comparator.comparing(FBPost::nrComments))
                .collect(Collectors.toList());
        List<Integer> top5 = new ArrayList<>();
        for(int i = sortedPosts.size()-1; i > sortedPosts.size()-6; i--)
            top5.add(sortedPosts.get(i).getId());
        return top5;
    }

    public int searchPost(FBPost post){
        for(int i = 0; i < this.timeline.size(); i++)
            if(this.timeline.get(i).equals(post))
                return i;
        return -1;
    }

    public List<FBPost> getTimeline() {
        List<FBPost> newArr = new ArrayList<>();
        for(FBPost fbPost : this.timeline)
            newArr.add(fbPost.clone());
        return newArr;
    }

    public void setTimeline(List<FBPost> timeline) {
        List<FBPost> newArr = new ArrayList<>();
        for(FBPost fbPost : this.timeline)
            newArr.add(fbPost.clone());
        this.timeline = newArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FBFeed fbFeed = (FBFeed) o;

        return getTimeline() != null ? getTimeline().equals(fbFeed.getTimeline()) : fbFeed.getTimeline() == null;
    }

    @Override
    public int hashCode() {
        return getTimeline() != null ? getTimeline().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FBFeed{" +
                "timeline=" + timeline +
                '}';
    }

    @Override
    protected FBFeed clone() {
        return new FBFeed(this);
    }
}
