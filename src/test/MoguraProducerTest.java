package test;

import model.MoguraBase;
import model.MoguraProducer;
public class MoguraProducerTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
			//MoguraProducerTest.execute1();
			MoguraProducerTest.execute2();
		//MoguraProducerTest.execute3();
	}

	public static void execute1() {
		MoguraBase mogurabase = new MoguraBase();
		MoguraProducer moguraproducer = new MoguraProducer(mogurabase);
	}
	public static void execute2() {
		MoguraBase mogurabase = new MoguraBase();
		MoguraProducer moguraproducer = new MoguraProducer(mogurabase, 10, 200, 2000);
	}
	public static void execute3() {
		MoguraProducer moguraproducer = new MoguraProducer();

	}
}
