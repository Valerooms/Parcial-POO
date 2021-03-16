package entities;

import java.time.LocalDate;
import java.util.Date;

public class Summary {

    private int activeProjects;
    private LocalDate date;

    public int getActiveProjects() {
        return activeProjects;
    }

    public LocalDate getDate() {
        return date;
    }

    public Summary(LocalDate date, int activeProjects){
        this.date = date;
        this.activeProjects = activeProjects;


    }
}
