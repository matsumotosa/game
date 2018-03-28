package test;
import model.AnimatedCanvas;
import model.MoguraBase;
import model.MoguraProducer;
public class AnimatedCanvasTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		AnimatedCanvasTest.execute1();

	}


	public static void execute1() {
		MoguraBase mb = new MoguraBase("file:C:\\Users\\y_01v\\Desktop\\usagi.gif");
		MoguraProducer mp = new MoguraProducer(mb);
		new AnimatedCanvas(mp);
	}
}
