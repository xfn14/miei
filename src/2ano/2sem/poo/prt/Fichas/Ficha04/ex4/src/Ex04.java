import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ex04 {
    public static void main(String[] args) {
        FBFeed fbFeed = new FBFeed();
        for(int i = 0; i < 10; i++){
            int finalI = i;
            FBPost fbPost = new FBPost(
                    i,
                    "andreubita",
                    LocalDateTime.now(),
                    "test",
                    1,
                    new ArrayList<>(){
                        {
                            for(int j = 0; j < finalI; j++){
                                add("hey");
                            }
                        }
                    }
            );
            fbFeed.addPost(fbPost);
        }

        System.out.println(fbFeed.toString());
        System.out.println(fbFeed.top5Comments());
    }
}
