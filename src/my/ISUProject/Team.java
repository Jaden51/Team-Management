/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ISUProject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author 335550752
 */
public class Team {
    //Variables
    private String team;
    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<String> teamPlayers = new ArrayList<>();
    private ArrayList<String> teamStats = new ArrayList<>();
    private ArrayList<String> points = new ArrayList<>();
    private ArrayList<String> rebounds = new ArrayList<>();
    private ArrayList<String> assists = new ArrayList<>();
    File playerList = new File("playerData.txt");

    /**
     * Set the team
     *
     * @param t
     */
    public void setTeam(String t) {
        team = t;
    }

    /**
     * @return the team selected
     */
    public String getTeam() {
        return team;
    }

    /**
     * Method to set the players of your team without any statistics.
     */
    public void setPlayersOnly() {
        players.clear(); //clear players
        try {
            Scanner sc = new Scanner(playerList);
            while (sc.hasNextLine()) {
                players.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String player : players) {
            if (player.contains(team)) {
                String[] split = player.split(";"); //split them based on name
                teamPlayers.add(split[1]); //add them
            }
        }
    }

    /**
     * @return the players on your team without statistics.
     */
    public ArrayList<String> getPlayersOnly() {
        return teamPlayers;
    }

    /**
     * Set the players of your team, including all their data
     */
    public void setPlayers() {
        try {
            Scanner sc = new Scanner(playerList);
            while (sc.hasNextLine()) {
                players.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String player : players) {
            if (player.contains(team)) {
                teamStats.add(player);
            }
        }
    }

    /**
     * @return the information of every player on your team
     */
    public ArrayList<String> getPlayers() {
        return teamStats;
    }

    /**
     * Set the statistics of your team
     */
    public void setStats() {
        for (String player : players) {
            if (player.contains(team)) {
                String[] split = player.split(";");
                points.add(split[1] + ": " + split[3]);
                rebounds.add(split[1] + ": " + split[4]);
                assists.add(split[1] + ": " + split[5]);
            }
        }
    }

    /**
     * @return points of your team
     */
    public ArrayList<String> getPoints() {
        return points;
    }

    /**
     * @return rebounds of your team
     */
    public ArrayList<String> getRebounds() {
        return rebounds;
    }

    /**
     * @return assists of your team
     */
    public ArrayList<String> getAssists() {
        return assists;
    }

    /**
     * clear all player information
     */
    public void clearPlayers() {
        players.clear();
        teamPlayers.clear();
        teamStats.clear();
    }

    /**
     * clear all player statistics
     */
    public void clearStats() {
        points.clear();
        rebounds.clear();
        assists.clear();
    }
}
