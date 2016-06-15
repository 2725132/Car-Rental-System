package com.mainsystem.window.helper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mainsystem.window.exception.NullImageException;
import lombok.Data;

@Data
public class ImageBuilder {
	private static byte[] byteImage;

	public static byte[] getByteImage(File newImage) {
		try {
			byteImage = new byte[(int) newImage.length()];
			FileInputStream fs = new FileInputStream(newImage);
			fs.read(byteImage);
			fs.close();
			if(byteImage == null) throw new NullImageException();
			else System.out.println("NAO NULO");
		} catch (NullImageException e) {
			e.printError();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteImage;
	}

	public static BufferedImage getBufferedImage(byte[] bytes){  
        BufferedImage bufferedImage=null;
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bufferedImage;
}

	public void loadImage(){
		
	}
}
