package com.main.test;

import java.io.File;


public class VideoCompress {

	public static void main(String[] args) {
		
		String pathProperty = System.getProperty("file.separator");
		String filePath = "test" + pathProperty + "resources" + pathProperty + "videos" + pathProperty + "output.mp4";
		File file = new File(filePath);
		System.out.println(filePath);
		System.out.println(file.exists());
		//FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("test" +);
	}
}