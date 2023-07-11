package Model;

public class FilmRequestResponse{
    private int id;
    private String title;
    private int year;
    private String director;
    private String genre;
    private String cast;
    private String synopsis;
    private String image;

    // Constructor (optional)
    public FilmRequestResponse(){};
    
    public FilmRequestResponse(int id, String title, int year, String director, String genre, String cast, String synopsis, String image) {
        
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
        this.cast = cast;
        this.synopsis = synopsis;
        this.image = image;
    }

    // Getter and Setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter methods for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter and Setter methods for director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getter and Setter methods for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and Setter methods for cast
    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    // Getter and Setter methods for synopsis
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    // Getter and Setter methods for image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
