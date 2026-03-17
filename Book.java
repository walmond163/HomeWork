import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    public String Title;
    public String Autor;
    public int Year;
    public String Genre;
    public boolean Status;
    public double Rating;
    public String Feedback;
    public LocalDate Date;
    

    public Book() {
        Date = null;
        Title = "";
        Autor = "";
        Year = 0;
        Genre = "";
        Status = false;
        Rating = 0;
        Feedback = "";
    }

    public Book(LocalDate date, String title, String autor, int year, String genre, boolean status, double rating, String feedback) {
        this.Date = date;
        this.Title = title;
        this.Autor = autor;
        this.Year = year;
        this.Genre = genre;
        this.Status = status;
        this.Rating = rating;
        this.Feedback = feedback;

    }



    public void show() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = this.Date.format(formatter);
        String statusText = Status ? "Прочитано" : "Не прочитано";
        System.out.println("DATE: " + dateStr + "; NAME: " + Title + "; AUTOR: " + Autor + "; YEAR: " + Year + "; GENRE: " + Genre + "; STATUS: " + statusText + "; RATING: " + Rating + "; FEEDBACK: " + Feedback);
    }

    

}
