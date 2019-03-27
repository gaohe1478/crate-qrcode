package com.Zxing_erweima;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

//���ɶ�ά��
public class Zxing_qrcode {

	public static void main(String[] args) throws IOException {
		//�ߴ��ʽ����
		int width = 300;
		int height = 300;
		String format = "png";
		String content = "https://github.com/gaohe1478";
		//����
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);//����ȼ�
		hints.put(EncodeHintType.MARGIN,2);//�߿�հ�
		
		try {
			
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			BufferedImage bi = MatrixToImageWriter.toBufferedImage(bitMatrix);//��bitmatrixתΪbufferedimage
			File f = new File("D:/Java/git_img.png");
			ImageIO.write(bi, format, f);//д��
			
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	
		
		
		
	}

}
