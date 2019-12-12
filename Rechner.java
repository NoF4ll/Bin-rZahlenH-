package Bin�r;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Rechner extends BinaryException {

	static void wandleBinInDez() {

		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte gib eine Dualzahl ein!");

		int binZahl = eingabe.nextInt();

		String s = Integer.toString(binZahl);
		char[] a = new char[s.length()];
		a = s.toCharArray();
		try {
			if (a.length < 8 || a.length > 13) {
				throw new BinaryException(
						"Deine Bin�rzahl soll l�nger als 8 Zeichen lang sein und k�rzer als 13 sein!");
			}
			for (int i = 0; i < a.length; i++) {
				if (a[i] == '0' || a[i] == '1') {
					continue;
				}
				throw new BinaryException("Keine g�ltige Bin�rzahl");
			}

			int anzahlVerschiebung = 0;
			int dezZahl = 0;
			int restWert = 0;
			// In Dezimalzahl umwandeln!
			while (binZahl != 0) {
				restWert = binZahl % 10;
				dezZahl = dezZahl + (int) (restWert * (Math.pow(2, anzahlVerschiebung)));
				binZahl = binZahl / 10;
				anzahlVerschiebung = anzahlVerschiebung + 1;
			}
			System.out.println(dezZahl);
		} catch (BinaryException e) {
			e.printStackTrace();
		} finally {
			eingabe.close();
		}

	}

	public static void main(String[] args) {
		wandleBinInDez();
	}
}