package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {

    private List<Group> groups;
    private List<Summary> summaries;


    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList<>();



    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    /**
     * Create a summary entry in the current date.
     * - Calculate the count of active projects.
     *
     * @return The new Summary entry.
     */
    public Summary createSummaryEntry() {

        int cantidadProyectosabiertos =0;
        for (int i=0; i<groups.size();i++)
        {
            cantidadProyectosabiertos+=groups.get(i).countActiveProjects();
        }

        Summary s = new Summary(LocalDate.now(),cantidadProyectosabiertos);
        summaries.add(s);
        return s;

    }


}