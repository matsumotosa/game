package model;

import java.awt.event.MouseEvent;

public class Decision {

	public static void decisionClick(MouseEvent e, AnimatedCanvas ac) {
		MoguraBase mb = ac.getMp().getMb();

		if(e.getY() > (int)(mb.getH()*(1-ac.getVisibleArea()))) {
			CalcScore.Calc(ac.getMp(), 1);
		} else {
			CalcScore.Calc(ac.getMp(), -1);

		}
		ac.setIsClicked(true);


	}
}
