package entities;

import java.util.ArrayList;
import java.util.List;

public class Iteration {

    private String goal;
    private Project project;
    private List<Activity> activities;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList<>();

        project.addIteration(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public int countOpenActivities(){
        int cantidad =0;
        for (int i=0; i<activities.size();i++)
        {
            activities.get(i).isActive();
             cantidad++;
        }
        return cantidad;

    }
    public int closedActivities(){
        int cantidad =0;
        for (int i=0; i<activities.size();i++)
        {
            activities.get(i).isActive() ;
            cantidad++;
        }
        return activities.size()-cantidad;

    }

}
