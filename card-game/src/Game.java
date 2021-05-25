/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vinicius Jimenez
 */
public class Game {
    private final Player player;
    private final Player computer;
    private final long startedAt;
    private long finishedAt = 0;
    
    Game(Player player, Player computer){
        this.player = player;
        this.computer = computer;
        this.startedAt = System.currentTimeMillis();
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the computer
     */
    public Player getComputer() {
        return computer;
    }

    /**
     * @return the startedAt
     */
    public long getStartedAt() {
        return startedAt;
    }

    /**
     * @return the finishedAt
     */
    public long getFinishedAt() {
        return finishedAt;
    }

    /**
     * @param finishedAt the finishedAt to set
     */
    public void setFinishedAt(long finishedAt) {
        this.finishedAt = finishedAt;
    }
}
