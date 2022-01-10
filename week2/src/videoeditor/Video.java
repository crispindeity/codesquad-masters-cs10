package videoeditor;

public class Video {
    private final String title;
    private final String id;
    private final int videoPlaybackTime;

    public Video(String title, String id, int videoPlaybackTime) {
        this.title = title;
        this.id = id;
        this.videoPlaybackTime = videoPlaybackTime;
    }

    @Override
    public String toString() {
        return title + "(" + id + ")" + ":" + videoPlaybackTime + '\n';
    }
}
