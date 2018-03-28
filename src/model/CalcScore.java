package model;

import java.awt.TextField;

public class CalcScore {

	public static void Calc(MoguraProducer mp, int score) {
		MoguraBase mb = mp.getMb();
		TextField sc = mb.getSc();
		int currentScore = Integer.parseInt(sc.getText());
		sc.setText(String.valueOf(currentScore + score));
	}

	public static void Calc(MoguraBase mb, int score) {
		TextField sc = mb.getSc();
		int currentScore = Integer.parseInt(sc.getText());
		sc.setText(String.valueOf(currentScore + score));
	}

}
