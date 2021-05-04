/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 335550752
 */
public class Player {

    //Variables
    private String team, name, position, points, rebounds, assists;
    File playerList = new File("playerData.txt");
    private final ArrayList<String> player = new ArrayList<>();

    /**
     * Add all the players in the file
     */
    public Player() {
        try {
            Scanner sc = new Scanner(playerList);
            while (sc.hasNextLine()) {
                player.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Set the team of the new player
     *
     * @param t
     */
    public void setTeam(String t) {
        team = t;
    }

    /**
     * Set the name of the new player
     *
     * @param n
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Set the position of the new player
     *
     * @param p
     */
    public void setPosition(String p) {
        position = p;
    }

    /**
     * Set the points of the new player
     *
     * @param p
     */
    public void setPoints(String p) {
        double temp = Double.parseDouble(p);
        points = String.valueOf(temp);
    }

    /**
     * Set the rebounds of the new player
     *
     * @param r
     */
    public void setRebounds(String r) {
        double temp = Double.parseDouble(r);
        rebounds = String.valueOf(temp);
    }

    /**
     * Set the assists of the new player
     *
     * @param a
     */
    public void setAssists(String a) {
        double temp = Double.parseDouble(a);
        assists = String.valueOf(temp);
    }

    /**
     * Create the player and put him in the file
     */
    public void createPlayer() {
        String playerCheck = (team + ";" + name + ";" + position + ";" + points + ";" + rebounds + ";" + assists);
        boolean proceed = true;
        for (String player1 : player) { //check to see if player already exists
            if (player1.equals(playerCheck)) {
                proceed = false;
            }
        }
        if (proceed == true) { //if new player, create new player
            player.add(playerCheck);
            try {
                PrintWriter output = new PrintWriter(playerList); //new PrintWriter to the file
                for (String player1 : player) { //for every element in the array list, print out the data
                    output.println(player1);
                }
                output.close();
            } catch (FileNotFoundException ex) {
                System.out.printf("ERROR %s\n", ex);
            }
        } else if (proceed == false) { //if player already exists
            JOptionPane.showMessageDialog(null, "Player Already Exists");
        }
    }
}
