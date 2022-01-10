package videoeditor;

public class VideoEditor<E> {

    public void start() {
        Video video1 = new Video("제목1", "abcd", 12);
        Video video2 = new Video("제목2", "afbc", 1);
        Video video3 = new Video("제목3", "bdfa", 7);
        Video video4 = new Video("제목4", "afaf", 4);
        Video video5 = new Video("제목5", "abab", 9);
        Video video6 = new Video("제목6", "acac", 15);
        Video video7 = new Video("제목7", "bdbd", 2);
        Video video8 = new Video("제목8", "baaa", 3);
        Video video9 = new Video("제목9", "cafe", 14);
        Video video10 = new Video("제목10", "cccef", 10);
        Video video11 = new Video("제목11", "afcd", 12);
        Video video12 = new Video("제목12", "fabc", 4);
        Video video13 = new Video("제목13", "dcba", 1);

        LinkedList<E> videoList = new LinkedList<>();

        System.out.println("---영상클립---");
        videoList.add(video1);
        videoList.add(video2);
        videoList.add(video3);
        videoList.add(video4);
        videoList.add(video5);
        videoList.add(video6);
        videoList.add(video7);
        videoList.add(video8);
        videoList.add(video9);
        videoList.add(video10);
        videoList.add(video11);
        videoList.add(video12);
        videoList.add(video13);
        videoList.removeLast();
        videoList.removeLast();
        videoList.removeFirst();

        System.out.println(videoList);
        System.out.println(videoList.get(9));
    }
}