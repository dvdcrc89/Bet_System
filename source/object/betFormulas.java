package object;

import java.util.ArrayList;

public class betFormulas {


    public fattoreUovo calculate(int idMatch, Match match, ArrayList<MatchDay> ms){
        Table table = new Table(idMatch-1,ms);
        Team teamHome = table.takeTeam(match.gethome());
        Team teamAway = table.takeTeam(match.getaway());
        if(teamHome==null) return null ;
        int eggFactor = (teamHome.getWonHome()*3+teamHome.getTieHome()+teamAway.getLostAway()*3)-
                (teamAway.getWonAway()*3+teamAway.getTieAway()+teamHome.getLostHome()*3);

        return new fattoreUovo(eggFactor,match.getResult());


    }

    public ArrayList<Match> pastMatch(Match ms, League league,boolean eitherWay){
        ArrayList<Match> pastMatch = new ArrayList<>();
        for(MatchDay md : league.getMatchDays()){
            for(Match match : md.getMatches()) {
                if (eitherWay) {
                    if ((match.gethome().equals(ms.gethome()) || match.gethome().equals(ms.getaway())) &&
                            (match.getaway().equals(ms.gethome()) || match.getaway().equals(ms.getaway()))) {

                        pastMatch.add(match);
                    }
                } else {
                    if (match.gethome().equals(ms.gethome()) && match.getaway().equals(ms.getaway())){
                        pastMatch.add(match);

                    }

                }
            }
        }
        return pastMatch;
    }


}
