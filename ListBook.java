import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListBook {
   List<Book> books;


   String filename = "Books.csv";
   
   public ListBook() {
        books = new ArrayList<Book>(); 
   }


   public void print() {
        for (Book b : books) {
            b.show();
        }
   }

   public void add(Book book) {
        books.add(book);
   }

   public void add(LocalDate date, String title, String autor, int year, String genre, boolean status, double rating, String feedback) {
        books.add(new Book(date, title, autor, year, genre, status, rating, feedback));
   }

   public void save() {
        try (BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (Book b : books) {
                String dateStr = b.Date.format(formatter);
                wr.write(dateStr + ";" + b.Title + ";" + b.Autor + ";" + b.Year + ";" + b.Genre + ";" + b.Status + ";" + b.Rating + ";" + b.Feedback + "\n");
            }
        } catch (Exception ex) {
            System.out.println("ERROR SAVE BOOK");
            ex.printStackTrace();
        }
   }

   public void load() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line = "";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
            while ((line = br.readLine()) != null) {
                String[] items = line.split(";");
                LocalDate date = LocalDate.parse(items[0], formatter);
                this.add(date, items[1], items[2], Integer.parseInt(items[3]), items[4], Boolean.parseBoolean(items[5]), Double.parseDouble(items[6]), items[7]);
            }
        } catch (Exception ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
   }

   public boolean findByName(String name) {
        boolean found = false; 
        for (Book b : books) {
            if (b.Title.equalsIgnoreCase(name)) {
            b.show();      
            found = true; 
            }
            } if (!found) {
            System.out.println("Данные не найдены");
            }
            return found;
    }
    
    public boolean findByAutor(String autor) {
        boolean found = false;
        for (Book b : books) {
            if (b.Autor.equalsIgnoreCase(autor)) {
                b.show();
                found = true;
            }
            } if (!found) {
            System.out.println("Данные не найдены");
            }
            return found;
    }

    public boolean findByGenre(String genre) {
        boolean found = false;
        for (Book b : books) {
            if (b.Genre.equalsIgnoreCase(genre)) {
                b.show();
                found = true;
            }
            } if (!found) {
            System.out.println("Данные не найдены");
            }
            return found;
        

    }

    public void printSortRating() {
        books.stream()
        .filter((Book b) -> b.Status) 
        .sorted(Comparator.comparingDouble((Book b) -> b.Rating).reversed()) 
        .forEach(Book::show);
    }
    public void printSortYear() {
        books.stream()
        .filter((Book b) -> b.Status)
        .sorted(Comparator.comparingInt((Book b) -> b.Year))  
        .forEach(Book::show);
}

    public void printSortDate() {
        books.stream()
        .filter((Book b) -> b.Status)
        .sorted(Comparator.comparing((Book b) -> b.Date))  
        .forEach(Book::show);
}


    

}
