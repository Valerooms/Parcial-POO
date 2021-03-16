package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int countOpenActivities()
    {
        int result=0;
        for (int i = 0; i < iterations.size(); i++) {

            result= this.iterations.get(i).countOpenActivities();
        }
        return result;
    }


    /**
     * Evaluate if a project is active.
     *
     * que tenga actividades abiertas
     * que la fecha de cierre sea mayor a la fecha actual
     *
     * @return false if the project has not open activities or the dateEnd is before than the system date.
     */
    public boolean isActive() {
        boolean isACTIVE = true;

        int poa = 0;
        for(Iteration i : this.iterations){
            poa += i.countOpenActivities();
        }

        if(LocalDate.now().isAfter(dateEnd)){
            isACTIVE = false;
        }else{
            isACTIVE = poa > 0;
        }

        return  isACTIVE;

    }


}
