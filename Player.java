public class Player {
    private String playerName;
    private String raceProgress;
    private int position;

    public Player(String playerName) {
        this.playerName = playerName;
        position = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rightpad(playerName, 10));
        for (int i = 0; i < 31; i++) {
            if (i == position) {
                sb.append("x");
            }
            else {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    private String leftpad(String text, int length) {
        return String.format("%" + length + "." + length + "s", text);
    }

    private String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRaceProgress() {
        return raceProgress;
    }

    public void setRaceProgress(String raceProgress) {
        this.raceProgress = raceProgress;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position <= 30) {
            this.position = position;
        }
        else {
            System.out.println("Must roll the exact number");
        }
    }
}
