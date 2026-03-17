import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        
        ListBook bk = new ListBook();
        bk.load();
        


       Scanner input = new Scanner(System.in, "Cp866");

       while (true) {
            System.out.println("1. Вывести список всех книг");
            System.out.println("2. Добавить книгу");
            System.out.println("3. Поиск книги по автору");
            System.out.println("4. Поиск книги по жанру");
            System.out.println("5. Поиск книги по названию");
            System.out.println("6. Сортировка");
            System.out.println("7. Выход");

            String user = input.next();

            if (user.equals("1")) {
                //Вывести список всех книг
                bk.print();
            } else if (user.equals("2")) {
                //Добавить книгу
                input.nextLine();
                LocalDate date = LocalDate.now();
                System.out.print("Введите название: ");
                String title = input.nextLine();
                System.out.print("Введите автора: ");
                String autor = input.nextLine();
                System.out.print("Введите год: ");
                String year = input.nextLine();
                System.out.print("Введите жанр: ");
                String genre = input.nextLine();
                System.out.print("Книга прочитана? 1-Да/0-Нет: ");
                String status = input.nextLine();
                boolean st;
                    if (status.equals("1")) {
                       st = true;
                    } else {
                        st = false;
                    }
                System.out.print("Введите рейтинг: ");
                String rating = input.nextLine();
                System.out.print("Напишите отзыв: ");
                String feedback = input.nextLine();
                bk.add(date, title, autor, Integer.parseInt(year), genre, st, Double.parseDouble(rating), feedback);
                bk.save();
            } else if (user.equals("3")) {
                // Поиск книги по автору
                input.nextLine();
                System.out.println("Введите автора: ");
                String autor = input.nextLine();
                    bk.findByAutor(autor);
                

            } else if (user.equals("4")) {
                // Поиск книги по жанру
                input.nextLine();
                System.out.println("Введите жанр: ");
                String genre = input.nextLine();
                bk.findByGenre(genre);
               
            } else if (user.equals("5")) {
                // Поиск книги по названию
                input.nextLine();
                System.out.println("Введите название: ");
                String title = input.nextLine();
                    bk.findByName(title);

            } else if (user.equals("6")) {
                // Сортировка
                System.out.println("1. Сортировка прочитанных книг по убыванию рейтинга \n2. Сортировка прочитанных книг по возрастанию года \n3. Сортировка прочитанных книг по дате добавления по возрастанию  ");
                String sort = input.next();
             if (sort.equals("1")) {
                input.nextLine();
                bk.printSortRating();
             } else if (sort.equals("2")) {
                input.nextLine();
                bk.printSortYear();
             }   else if (sort.equals("3")) {
                input.nextLine();
                bk.printSortDate();
             }
                

            } else if (user.equals("7")) {
                break;
            }
      
        }

        input.close();
    }
}