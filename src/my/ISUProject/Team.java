/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.ISUProject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.EOFException;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 *
 * @author 335550752
 */
public class Team {

    private String team;
    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<String> teamPlayers = new ArrayList<>();
    private ArrayList<String> teamStats = new ArrayList<>();
    private ArrayList<String> points = new ArrayList<>();
    private ArrayList<String> rebounds = new ArrayList<>();
    private ArrayList<String> assists = new ArrayList<>();
    File playerList = new File("playerData.txt");

    public Team() {

    }

    public void setTeam(String t) {
        team = t;
    }

    public String getTeam() {
        return team;
    }

    public void setPlayersOnly() {
        players.clear();
        try {
            Scanner sc = new Scanner(playerList);
            while (sc.hasNextLine()) {
                players.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ISUProjectUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String player : players) {
            if (player.contains(team)) {
                String[] split = player.split(";");
                teamPlayers.add(split[1]);
            }
        }
    }

    public ArrayList<String> getPlayersOnly() {
        return teamPlayers;
    }

    public void setPlayers() {
        try {
            Scanner sc = new Scanner(playerList);
            while (sc.hasNextLine()) {
                players.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ISUProjectUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String player : players) {
            if (player.contains(team)) {
                teamStats.add(player);
            }
        }
    }

    public ArrayList<String> getPlayers() {
        return teamStats;
    }

    public void setStats() {
        for (String player : players) {
            if (player.contains(team)) {
                String[] split = player.split(";");
                points.add(split[3]);
                rebounds.add(split[4]);
                assists.add(split[5]);
            }
        }
    }
    
    public ArrayList<String> getPoints() {
        return points;
    }

    public void clearPlayers() {
        players.clear();
        teamPlayers.clear();
        teamStats.clear();
    }
}
