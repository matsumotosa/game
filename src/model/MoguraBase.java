package model;

import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MoguraBase extends JFrame implements MouseListener {
	private final static long serialVarsionUID = 1L;

	private BufferedImage moguraImage;//モグラのバッファイメージ
	private int w, h;//モグラの画像の高さと幅
	private TextField sc = new TextField("0");//得点のテキストフィールド
	private int fieldW, fieldH;//ウインドウの幅の高さ

	public MoguraBase() {

		this("http://msyk.net/keio/JavaBook/eclipse-indigo/mogura.gif");//初期設定のモグライメージ
	}

	public MoguraBase(String url) {
		setMoguraImage(url);//カスタマイズ画像を設定
		w = moguraImage.getWidth(this);//画像サイズをメンバ変数へ記録
		h = moguraImage.getHeight(this);

		this.setFieldW(500);
		this.setFieldH(400);

		this.addMouseListener(this);//マウス操作を受け付ける
		this.getContentPane().setLayout(null);//レイアウト機能はなし
		sc.setBounds(0, 0, 50, 24);//スコア用のテキストフィールドの場所
		this.getContentPane().add(sc);//テキストフィールドをウインドウに追加
		this.setBounds(0, 0, getFieldW(), getFieldH());
		this.setVisible(true);//ウインドウを表示


	}

	public BufferedImage getMoguraImage() {
		return this.moguraImage;
	}

	public void setMoguraImage(String userUrl) {
		try {
				URL url = new URL(userUrl);
				moguraImage = ImageIO.read(url);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public TextField getSc() {
		return this.sc;
	}

	public void setSc(TextField sc) {
		this.sc = sc;
	}

	public int getFieldW() {
		return fieldW;
	}

	public void setFieldW(int fieldW) {
		this.fieldW = fieldW;

	}

	public int getFieldH() {
		return fieldH;
	}

	public void setFieldH(int fieldH) {
		this.fieldH = fieldH;
	}


	public void mouseClicked(MouseEvent e) {
		CalcScore.Calc(this, -1);
	}//ウインドウをクリックした場合の処理

	/*以下は定義のみ*/
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
