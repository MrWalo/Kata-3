package software.ulpgc.kata3.architecture.io;

public class Player {
    private final String player;
    private final String team;
    private final String position;
    private final String element;

    public Player(String player, String team, String position, String element){
        this.player = player;
        this.team = team;
        this.position = position;
        this.element = element;
    }

    public String getPlayer() {
        return player;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public String getElement() {
        return element;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player='" + player + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", element='" + element + '\'' +
                '}';
    }
}
