package swu.doom.validatecode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class ValidateCode {
	
	 private int width = 100;  
	 private int height = 30;	
	 private int codeCount = 4;
	 private int fontHeight = 22;
	 private BufferedImage codeImage = null;
	 private String codeString = null;
	 private char[] codeSequence = { 
			 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
	         'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public ValidateCode() {
		this.createCode();
	}
	
	public ValidateCode(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}
	
	public ValidateCode(int width, int height, int codeCount) {
		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.createCode();
	}
		
	private void createCode() {
		Random random = new Random();
		
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);
		
		// 设置字体
		Font font = new Font("Gill Sans", Font.BOLD, fontHeight);
		gd.setFont(font);
		
		// 画边框
		gd.setColor(Color.BLACK);
		gd.drawRect(0, 0, width - 1, height - 1);
		
		//画字符
		StringBuffer randomCode = new StringBuffer();		
		for (int i = 0; i < codeCount; i++) {
			String code = String.valueOf(codeSequence[random.nextInt(this.codeSequence.length)]);
			gd.setColor(this.randomColor());
			gd.drawString(code, (i + 1) * (this.width / (this.codeCount + random.nextInt(5))), fontHeight - random.nextInt(5));
			randomCode.append(code);
		}
		//画干扰线
		for (int i = 0; i < 40; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width / 3);
			int y2 = random.nextInt(width / 3);			
			gd.setColor(this.randomColor());			
			gd.drawLine(x1, y1, x1 + x2, y1 + y2);
		}
		
		this.codeString = randomCode.toString();
		this.codeImage = buffImg;		
	}
	
	private Color randomColor() {
		Random random = new Random();
		int red = 0, green = 0, blue = 0;
		red = random.nextInt(255);
		green = random.nextInt(200);
		blue = random.nextInt(100);
		return new Color(red, green, blue);
	}
	
	public void outputCodeImage(String path) throws IOException {
		FileOutputStream output = new FileOutputStream(path);
		this.outputCodeImage(output);
	}
		
	public void outputCodeImage(OutputStream output) throws IOException {
		ImageIO.write(this.codeImage, "png", output);
	}
	
	public String getCodeString() {
		return this.codeString;
	}	
	
}
