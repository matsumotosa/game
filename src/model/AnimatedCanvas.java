package model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class AnimatedCanvas extends Canvas implements Runnable,MouseListener {

	private final static long serialVersionUID = 1L;

	private Thread myTh;
	private Color backColor;
	private float visibleArea;
	private boolean isClicked;
	private MoguraProducer mp;



	public AnimatedCanvas(MoguraProducer mp) {
		this.mp = mp;
		this.setSize(mp.getMb().getW(), mp.getMb().getH());//コンポーネントをイメージサイズに設定
		Random r = new Random();
		int dispX = (int)(r.nextFloat() * (((mp.getMb().getFieldW()) - (mp.getMb().getW()))));//横座標を乱数で設定
		int dispY = (int)(r.nextFloat() * (((mp.getMb().getFieldH()) - (mp.getMb().getH()))));//縦座標を乱数で設定
		this.setLocation(dispX, dispY);//乱数で指定した位置に配置

		setBackColor(Color.pink);
		mp.getMb().getContentPane().add(this);//コンポーネントをウインドウに追加
		this.addMouseListener(this);//マウスイベントに対応させる

		myTh = new Thread(this);//このコンポーネントを管理するスレッド
		myTh.start();//スレッドを開始

	}

	public void run() {
		Graphics g = getGraphics();//コンポーネントのGraphics取得
		if(g != null) {
			for(visibleArea = 0; visibleArea < 1.0; visibleArea += 0.1) {
				g.setColor(backColor);//背景色を設定
				g.fillRect(0, 0, mp.getMb().getW(), mp.getMb().getH());//背景色を塗りつぶしてクリアにする
				g.drawImage(mp.getMb().getMoguraImage(), 0, (int)(mp.getMb().getH()*(1-visibleArea)),this);
				//もぐらの画像をvisibleAreaに応じて一部分だけ描く
				if(isClicked) {
					break;
				}
				try {
					Thread.sleep(mp.getSpeed());

				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("g is null.");
		}
		mp.getMb().remove(this);//このコンポーネントをウインドウから削除

	}

	public void mouseClicked(MouseEvent e) {
		Decision.decisionClick(e, this);
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}


	public Color getBackColor() {
		return this.backColor;
	}
	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public boolean getIsClicked() {
		return this.isClicked;
	}
	public void setIsClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public float getVisibleArea() {
		return this.visibleArea;
	}
	public void setVisibleArea(float visibleArea) {
		this.visibleArea = visibleArea;
	}

	public MoguraProducer getMp() {
		return this.mp;
	}
	public void setMp(MoguraProducer mp) {
		this.mp = mp;
	}

}
