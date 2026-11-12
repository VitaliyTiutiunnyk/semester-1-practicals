package semester1.practice10;

public class Task29 {
    public static void run(){
        MediaItem[] mediaItems = {
                new VideoFile("Фільм 4K", 1500, 2160, 7200),
                new VideoFile("Звичайне відео", 700, 1080, 3600),
                new AudioFile("Музика Lossless", 80, 1411),
                new AudioFile("Музика MP3", 10, 320),
                new EBookFile("Книга Java", 5, 350)
        };
        double totalSize = 0;
        System.out.println();
        for (MediaItem item : mediaItems) {
            if (item instanceof VideoFile video && video.is4K()) {
                System.out.println("Знайдено 4K-відео: " + video.getTitle());
                totalSize += video.getSizeMb();
            } else if (item instanceof AudioFile audio && audio.isLossless()) {
                System.out.println("Знайдено Lossless-аудіо: " + audio.getTitle());
                totalSize += audio.getSizeMb();
            }
        }
        System.out.println("Сумарний обсяг: " + totalSize + " МБ");
    }
}
abstract class MediaItem {
    private final String title;
    private final double sizeMb;

    MediaItem(String title, double sizeMb) {
        this.title = title;
        this.sizeMb = sizeMb;
    }

    public String getTitle() {
        return title;
    }

    public double getSizeMb() {
        return sizeMb;
    }
}

class VideoFile extends MediaItem {
    private final int resolutionHeight;
    private final int durationSec;

    VideoFile(String title, double sizeMb, int resolutionHeight, int durationSec) {
        super(title, sizeMb);
        this.resolutionHeight = resolutionHeight;
        this.durationSec = durationSec;
    }

    public boolean is4K() {
        return resolutionHeight >= 2160;
    }
}

class AudioFile extends MediaItem {
    private final int bitrateKbps;

    AudioFile(String title, double sizeMb, int bitrateKbps) {
        super(title, sizeMb);
        this.bitrateKbps = bitrateKbps;
    }

    public boolean isLossless() {
        return bitrateKbps >= 1000;
    }
}

class EBookFile extends MediaItem {
    private final int pageCount;

    EBookFile(String title, double sizeMb, int pageCount) {
        super(title, sizeMb);
        this.pageCount = pageCount;
    }
}
