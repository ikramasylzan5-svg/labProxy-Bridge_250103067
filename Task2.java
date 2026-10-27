public class Task2 {

    interface Video {
        void play();
    }

    static class RealVideo implements Video {
        private final String fileName;

        RealVideo(String fileName) {
            this.fileName = fileName;
            System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + fileName);
        }

        @Override
        public void play() {
            System.out.println("Playing video: " + fileName);
        }
    }

    static class ProxyVideo implements Video {
        private final String fileName;
        private RealVideo realVideo;
        private int viewCount = 0;

        ProxyVideo(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void play() {
            viewCount++;
            System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");
            if (realVideo == null) {
                realVideo = new RealVideo(fileName); 
            }
            realVideo.play();
        }
    }

    public static void main(String[] args) {
        Video video = new ProxyVideo("Cat_Memes.mp4");
        video.play();
        video.play();
        video.play();
    }
}