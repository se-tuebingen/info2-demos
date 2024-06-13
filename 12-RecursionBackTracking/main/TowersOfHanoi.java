package main;

import java.util.Scanner;

public class TowersOfHanoi {
	/**
	 * Das Programm berechnet die notwendigen Bewegungen der Scheiben, um einen Turm
	 * von Scheiben (mit unterschiedlichen Durchmessern) von einer Ausgangs- Saeule
	 * auf eine Ziel-Saeule zu transportieren (von Saeule 1 nach Saeule 3) und dabei
	 * nie eine groessere Scheibe ueber einer kleineren zu positionieren. Es steht
	 * eine dritte Hilfs-Saeule (Saeule 2) zur Verfuegung. Die Aufgabe wird als
	 * "Tuerme von Hanoi" Problem bezeichnet, deren Loesung rekursiv berechnet
	 * werden kann. Autor: hn, Dec.2010, mvb Jan, 2014, hl 2019
	 */
	public static void main(String[] args) {
		int heightOfTower; // Hoehe des Turms = Anzahl der Scheiben des Ausgangsturms
		final int POLE_START = 1;
		final int POLE_GOAL = 3;
		Scanner scan = new Scanner(System.in);
		System.out.print("Hoehe des Turms = Anzahl der Scheiben (positive Zahl): ");
		heightOfTower = scan.nextInt();
		while (heightOfTower < 0) {
			System.out.print("Der Parameter muss positiv oder 0 sein. " + "Bitte noch einmal ... ");
			heightOfTower = scan.nextInt();
		} // Wert fuer heightOfTower >= 0 ...

		moveTower(heightOfTower, POLE_START, POLE_GOAL);
	} // end main

	/*
	 * -- bewegt einen Turm der Hoehe "height" -- von Saeule "startPole" nach Saeule
	 * "goalPole" ...
	 */
	static void moveTower(int height, int startPole, int goalPole) {
		if (height > 0) {
			int otherPole = 6 - startPole - goalPole; 

			// Move N-1 discs from start to other pole
			moveTower( height - 1, startPole, otherPole);
			// The action of moving the base disk to the goal pole
			printTransportDisk(startPole, goalPole);
			// Move N-1 discs from support pole to goal pole
			moveTower( height - 1, otherPole, goalPole); 		
			
		}
	} // end moveTower

	static void printTransportDisk(int startPole, int goalPole) {
		System.out.print("Scheibe von ");
		printPoleId(startPole);
		System.out.print(" nach ");
		printPoleId(goalPole);
		System.out.println();
	} // end printMovement

	static void printPoleId(int pole) {
		switch (pole) {
		case 1:
			System.out.print("links (1)");
			break;
		case 2:
			System.out.print("mitte (2)");
			break;
		case 3:
			System.out.print("rechts (3)");
			break;
		}
	} // end printPoleId
} // end class TowersOfHanoi