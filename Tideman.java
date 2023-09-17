package Tideman;

import java.util.Scanner;

public class Tideman {
    public static class Candidate {
        String name1;
        String name2;
        int edge;

        public Candidate(String name1, String name2, int edge) {
            this.name1 = name1;
            this.name2 = name2;
            this.edge = edge;
        }

        public void edgeGained() {
            edge++;
        }

        public void edgeClear() {
            edge = 0;
        }

        public int getEdge() {
            return edge;
        }

        public String getName1() {
            return name1;
        }

        public String getName2() {
            return name2;
        }
    }

    public static int numOfCanPrompt(Scanner myScanner) {
        System.out.println("How many canidates are there?");
        int numOfCan = myScanner.nextInt();
        myScanner.nextLine();

        return numOfCan;
    }

    public static String[] listofCanPrompt(int numOfCan, Scanner myScanner) {

        String[] canidate = new String[numOfCan];
        for (int i = 0; i < numOfCan; i++) {
            System.out.println("What is canidate number " + (i + 1) + "'s name?");
            canidate[i] = myScanner.nextLine();
        }
        
        return canidate;
    }

    public static int ballotNum(Scanner myScanner) {

        System.out.println("How many ballots would you like to throw in?");
        int ballotNum = myScanner.nextInt();
        myScanner.nextLine();
        return ballotNum;
    }

    public static String[] ballotPrompt(int numofCan, Scanner myScanner) {

        String[] ballot = new String[numofCan];

        for (int i = 0; i < numofCan; i++) {
            System.out.println("Ballot Vote #" + (i + 1) + ": ");
            ballot[i] = myScanner.nextLine();
        }
        
        return ballot;
    }

    public static void instantiateEdgeArray(Candidate[][] edgeArray, String[] canidateNames, int numOfCan) {
        for (int i = 0; i < numOfCan; i++) {
            for (int j = 0; j < numOfCan; j++) {
                edgeArray[i][j] = new Candidate(canidateNames[i], canidateNames[j], 0);
            }
            
        }
    }

    public static void loggingVotes(Candidate[][] edgeArray, String[][] allBallots, int numofCan, int ballotNum) {
        for (int i = 0; i < ballotNum; i++) {
            String winnerOfBallot = allBallots[i][0];
            for (int j = 0; j < numofCan; j++) {
                for (int k = 0; k < numofCan; k++) {
                    if (winnerOfBallot == edgeArray[j][k].getName1()) {
                        edgeArray[j][k].edgeGained();
                    }
                }
            }
        }

        
    }

    public static void clearDiagonalEdges(Candidate[][] edgeArray, int numofCan) {
        for (int i = 0; i < numofCan; i++) {
            for (int j = 0; j < numofCan; j++) {
                if (i == j) {
                    edgeArray[i][j].edgeClear();
                }
            }
        }
    }

    public static Candidate findEdgeWinner(Candidate[][] edgeArray, int numofCan) {

        int biggestEdge = 0;
        Candidate winner = null;

        for (int i = 0; i < numofCan; i++) {
            for (int j = 0; j < numofCan; j++) {
                if (edgeArray[i][j].getEdge() > biggestEdge) {
                    biggestEdge = edgeArray[i][j].getEdge();
                    winner = edgeArray[i][j];
                }
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int numofCan = numOfCanPrompt(myScanner);
        String[] canidateNames = listofCanPrompt(numofCan, myScanner);

        int ballotNum = ballotNum(myScanner);

        String[][] allBallots = new String[ballotNum][numofCan];

        for (int i = 0; i < ballotNum; i++) {
            String[] ballot = ballotPrompt(numofCan, myScanner);
            for (int j = 0; j < numofCan; j++) {
                allBallots[i][j] = ballot[j];
            }
            System.out.println("Ballots #" + (i + 1) + " ended.");
        }
        System.out.println("Voting complete");
        myScanner.close();

        Candidate[][] edgeArray = new Candidate[numofCan][numofCan];

        instantiateEdgeArray(edgeArray, canidateNames, numofCan);

        loggingVotes(edgeArray, allBallots, numofCan, ballotNum);
        clearDiagonalEdges(edgeArray, numofCan);
        for (int i = 0; i < numofCan; i++) {
            for (int j = 0; j < numofCan; j++) {
                if (edgeArray[i][j] == null) {
                    System.out.print("NULL");
                }
                System.out.print(edgeArray[i][j].getName1() + "|" + edgeArray[i][j].getName2() + edgeArray[i][j].getEdge() + " ");
            }
            System.out.println();
        }
        Candidate winner = findEdgeWinner(edgeArray, numofCan);

        System.out.println("The winner is " + winner + "!");
    }
}