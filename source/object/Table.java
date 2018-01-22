package object;

import java.util.ArrayList;
import java.util.Collections;

public class Table {

    private ArrayList<Team> teams;

    public Table(int matchDays,ArrayList<MatchDay> arrayMatchDays) {
        teams = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<MatchDay> md2 = new ArrayList<>();
        /* Create a array m2 with every match till the MatchDay number */

        for(MatchDay m : arrayMatchDays){
            if(m.getNumber() <= matchDays){
                md2.add(m);
            }
        }
        /* Create a Table till matchDays number*/
        for(MatchDay m: md2){
            for(Match ms:m.getMatches()){

                ms.updateTable();

                teams.add(ms.getTeamHome());
                teams.add(ms.getTeamAway());
            }

        }
        /* qui ce' un errore non so perche' se non lo faccio ciclare 3 volte non funziona
            vedi te se lo trovi
         */
        for(int x=0;x<3;x++) {
            for (int i = 0; i < teams.size(); i++) {

                for (int i2 = i+1; i2 < teams.size() ; i2++) {
                    if (teams.get(i).getName().equals(teams.get(i2).getName())) {
                        teams.get(i).sum(teams.get(i2));
                        teams.remove(i2);

                    }
                }
            }
        }
        Collections.sort(teams);

    }
    /* return the Team whit name "name" from the Table */

    public Team takeTeam (String name){
        for(Team t: teams){
            if(t.getName().equals(name)) return t;
        }
        return null;
    }


    public ArrayList<Team> getTeam() {
        return teams;
    }

    public void setTeam(ArrayList<Team> team) {
        this.teams = team;
    }

    @Override
    public String toString() {
        return ""+ teams;
    }
}
