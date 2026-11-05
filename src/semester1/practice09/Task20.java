package semester1.practice09;

public class Task20 {
    public static void run(){
        Playlist playlist = new Playlist("Мої улюблені", 5);
        AudioTrack track1 = new AudioTrack("Believer", "Imagine Dragons", 204);
        AudioTrack track2 = new AudioTrack("Blinding Lights", "The Weeknd", 200);
        AudioTrack track3 = new AudioTrack("Autograph", "Juice WRLD", 180+48);
        playlist.addTrack(track1);
        playlist.addTrack(track2);
        playlist.addTrack(track3);
        System.out.println(playlist);
    }
}
class AudioTrack{
    private final String title;
    private final String artist;
    private final int durationSeconds;
    AudioTrack(String title, String artist, int durationSeconds){
        this.title=title;
        this.artist=artist;
        this.durationSeconds=durationSeconds;

    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public String getFormattedTime() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
class Playlist{
    private String name;
    private final AudioTrack[] tracks;
    private int trackCount;
    Playlist(String name, int capacity){
        this.name=name;
        tracks=new AudioTrack[capacity];
    }
    public void addTrack(AudioTrack track){
        if (track != null && trackCount < tracks.length) {
            tracks[trackCount] = track;
            trackCount++;
        }
  }
  public int getTotalDurationSeconds(){
        int duration=0;
        for (int i=0; i<trackCount; i++){
            duration+=tracks[i].getDurationSeconds();
        }
        return duration;
  }
    @Override public String toString(){
        String result = "=== ПЛЕЙЛИСТ: " + name + " ===\n";
        for (int i = 0; i < trackCount; i++) {
            result += (i + 1) + ". " +
                    tracks[i].getArtist() + " - " +
                    tracks[i].getTitle() + " [" +
                    tracks[i].getFormattedTime() + "]\n";
        }
        int totalSeconds = (int) getTotalDurationSeconds();
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        result += "Загальна тривалість: " + minutes +
                " хв " + seconds + " сек";
        return result;
    }

}
