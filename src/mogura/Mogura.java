package mogura;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import model.*;

public class Mogura {
	public static void main(String[] args) {
		MoguraBase mb = new MoguraBase();
		MoguraProducer mp = new MoguraProducer(mb, 10, 80, 1500);

	}
}