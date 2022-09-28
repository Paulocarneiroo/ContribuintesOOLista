package PlataformaDeEnsino.Application;

import PlataformaDeEnsino.Entities.Lesson;
import PlataformaDeEnsino.Entities.Task;
import PlataformaDeEnsino.Entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PlataformaDeEnsino {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();

        System.out.print("How much course lessons? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "° Lesson Data: ");
            System.out.print("Content or Task (c/t)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Title: ");
            sc.nextLine();
            String title = sc.nextLine();
            if(ch == 'c' || ch == 'C'){
                System.out.print("Video URL: ");
                String url = sc.nextLine();
                System.out.print("Duration (s): ");
                int time = sc.nextInt();
                list.add(new Video(title, url, time));
            } else if (ch == 't' || ch == 'T') {
                System.out.print("Description: ");
                String description = sc.nextLine();
                System.out.print("Number of questions: ");
                int questionCount = sc.nextInt();
                list.add(new Task(title, description, questionCount));
            }else {
                System.out.println("Wrong character, please restart program");
                break;
            }
        }
        System.out.println();
        int duration = 0;
        for (Lesson l : list) {
            duration += l.duration();
        }
        System.out.println("TOTAL COURSE DURATION: " + duration + " seconds");

        sc.close();
    }
}
