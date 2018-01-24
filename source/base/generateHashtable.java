package base;

import java.util.ArrayList;
import java.util.Hashtable;
import object.*;

public class generateHashtable {


    public Hashtable<String, Team> generateHash(ArrayList<Match> matches) {

        Hashtable<String, Team> teams = new Hashtable<>();


        for (Match ms : matches) {

            ms.updateTable();

            insert(teams,ms.getTeamHome());
            insert(teams,ms.getTeamAway());
        }
        return teams;
    }

    public  void insert(Hashtable<String,Team> teams,Team team) {
        if (teams.containsKey(team.getName())) {
            team.sum(teams.get(team.getName()));
            teams.replace(team.getName(),team);
        } else
        {
            teams.put(team.getName(),team);
        }
    }


}
