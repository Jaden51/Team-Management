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
public class Player {

    private String team, name, position, points, rebounds, assists;
    File playerList = new File("playerData.txt");
    private final ArrayList<String> player = new ArrayList<>();

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

    public void setTeam(String t) {
        team = t;
    }

    public void setName(String n) {
        name = n;
    }

    public void setPosition(String p) {
        position = p;
    }

    public void setPoints(String p) {
        points = p;
    }

    public void setRebounds(String r) {
        rebounds = r;
    }

    public void setAssists(String a) {
        assists = a;
    }

    public void createPlayer() {
        player.add(team + ";" + name + ";" + position + ";" + points + ";" + rebounds + ";" + assists);
        System.out.println(player);
        try {
            PrintWriter output = new PrintWriter(playerList); //new PrintWriter to the file
            for (String player1 : player) { //for every element in the array list, print out the data
                output.println(player1);
            }
            output.close();
        } catch (FileNotFoundException ex) {
            System.out.printf("ERROR %s\n", ex);
        }
    }
}
