package CricketMatchDashboard;

import CricketMatchDashboard.enums.Gender;
import CricketMatchDashboard.models.Match;
import CricketMatchDashboard.models.Player;
import CricketMatchDashboard.models.Team;

import java.util.List;

public class CricketDashboardApplication {
    public static void main(String[] args) {
        Team india = new Team("India");
        Team australia = new Team("Australia");
        Match match = new Match("Test Match", india, australia, 5, 2);
        match.addPlayersToTeam(india, List.of(
                new Player("P1", Gender.MALE, 31),
                new Player("P2", Gender.MALE, 30),
                new Player("P3", Gender.MALE, 29),
                new Player("P4", Gender.MALE, 30),
                new Player("P5", Gender.MALE, 29)));
        match.addPlayersToTeam(australia, List.of(
                new Player("P1", Gender.MALE, 31),
                new Player("P2", Gender.MALE, 30),
                new Player("P3", Gender.MALE, 29),
                new Player("P4", Gender.MALE, 30),
                new Player("P5", Gender.MALE, 29)));
        match.startMatch(india);
    }
}
