package model;
import java.util.Random;

public class MoguraProducer implements Runnable {
	private final static long serialVirsionUID = 1L;

	private Thread myTh;//スレッド管理
	private int maxMogura;//モグラの数
	private long speed;//モグラアニメーションスピード
	private long interval;//モグラ生成間隔係数
	private MoguraBase mb;//MoguraBaseのインスタンス

	public MoguraProducer() {
		this(new MoguraBase(), 30, 300, 2000);
	}

	public MoguraProducer(MoguraBase mb) {
		this(mb, 30, 300, 2000);
	}

	public MoguraProducer(MoguraBase mb, int maxMogura, long speed, long interval) {//モグラ生成最大数とスピードを設定
		this.mb = mb;
		this.setMaxMogura(maxMogura);//モグラの数をセット
		this.speed = speed;
		this.interval = interval;
		myTh = new Thread(this);//スレッド作成
		myTh.start();//実行
	}

	public void run() {
		AnimatedCanvas popMogura;

		Random r = new Random();//乱数を初期化
		for(int i = 0; i < maxMogura; i++) {
			popMogura = new AnimatedCanvas(this);//モグラ生成
			try {
				Thread.sleep((long)(interval*r.nextFloat()));
				//乱数で指定した時間だけ待つ
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int getMaxMogura() {
		return maxMogura;
	}
	public void setMaxMogura(int maxMogura) {
		this.maxMogura = maxMogura;
	}
	public MoguraBase getMb() {
		return this.mb;
	}
	public long getSpeed() {
		return this.speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	public long getInterval() {
		return this.interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}

}
