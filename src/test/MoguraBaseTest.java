package test;
import model.MoguraBase;
import model.MoguraProducer;
public class MoguraBaseTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//MoguraBaseTest.execute1();
		MoguraBaseTest.execute2();
	}

	public static void execute1() {
		MoguraBase mogurabase = new MoguraBase("file:C:\\Users\\y_01v\\Desktop\\usagi.gif");
		MoguraProducer moguraproducer = new MoguraProducer(mogurabase, 3, 100, 2000);

	}
	public static void execute2() {
		MoguraBase mogurabase = new MoguraBase();
		MoguraProducer moguraproducer = new MoguraProducer(mogurabase, 4, 500, 2000);

	}
}
