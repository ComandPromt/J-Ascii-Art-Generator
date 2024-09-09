package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Ascii {

	private String blanco = "#";

	private String negro = " ";

	private final Font font = new Font("Arial", Font.BOLD, 24);

	public StringBuilder crear(String text) {

		StringBuilder stringBuilder = new StringBuilder();

		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = image.createGraphics();

		TextLayout layout = new TextLayout(text, font, g2.getFontRenderContext());

		layout.draw(g2, 0, 0);

		Rectangle2D bounds = layout.getBounds();

		int ancho = (int) bounds.getWidth() + 4;

		int alto = (int) bounds.getHeight() + 2;

		image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

		g2 = image.createGraphics();

		g2.setColor(new Color(255, 255, 255));

		g2.fill(new Rectangle2D.Double(0, 0, ancho, alto));

		g2.setColor(new Color(0, 0, 0));

		g2.setFont(font);

		g2.drawString(text, 2, alto - 1);

		for (int y = 0; y < alto; y++) {

			for (int x = 0; x < ancho; x++) {

				stringBuilder.append(image.getRGB(x, y) == new Color(255, 255, 255).getRGB() ? blanco : negro);

			}

			stringBuilder.append("\n");

		}

		return stringBuilder;

	}

	public String getBlanco() {

		return blanco;

	}

	public void setBlanco(String blanco) {

		this.blanco = blanco;

	}

	public String getNegro() {

		return negro;

	}

	public void setNegro(String negro) {

		this.negro = negro;

	}

}
