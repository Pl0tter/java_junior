package org.main.seminar04.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {

    private static final String[] titles = new String[]{"Математика", "Русский язык", "Физика", "Литература",
            "Геометрия", "Биология", "География", "Обществознание", "Физкультура", "Труд"};
    private static final Random random = new Random();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)], random.nextInt(30, 90));
    }

    public Course() {

    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public void updateDuration() {
        duration = random.nextInt(30, 90);
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
