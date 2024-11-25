import java.math.BigInteger;

public class Structure {
    private String artist;
    private String album;
    private int songsNumber;  // Keep it as int
    private String date;
    private BigInteger downloads;

    // No-argument constructor
    public Structure() {
    }

    // Constructor with all fields
    public Structure(String artist, String album, int songsNumber, String date, BigInteger downloads) {
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.date = date;
        this.downloads = downloads;
    }

    // Getters
    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getSongsNumber() {  // Return type changed to int
        return songsNumber;
    }

    public String getDate() {
        return date;
    }

    public BigInteger getDownloads() {
        return downloads;
    }

    // Setters
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setSongsNumber(int songsNumber) {  // Parameter type changed to int
        this.songsNumber = songsNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDownloads(BigInteger downloads) {
        this.downloads = downloads;
    }

    // Override toString() for easier printing
    @Override
    public String toString() {
        return artist + "\n" + album + "\n" + songsNumber +
                "\n" + date + "\n" + downloads + "\n";
    }
}
