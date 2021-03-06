package com.lxj.assets;



import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {

	int width =300;
	int height =300;
	String format ="png";
	String content;
	
	public void toQRCode(String name,String content){
		this.content=content;
		Map hints =new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN,2);
		
		//生成二维码
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			Path file =new File("E:/QRCode/"+name+".png").toPath();
			//MatrixToImageWriter.toBufferedImage(bitMatrix);
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "生成二维码成功！");
		
	}
	
	

}
