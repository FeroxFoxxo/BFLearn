package blazingforest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

public class Launcher {
	public Launcher() {
		try {
			String appLocation = String.valueOf(Paths.get(Launcher.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(3), new String[0]).getParent().toString()) + "\\temp.jar";
			File delFile = new File(appLocation);
			delFile.delete();
			URL website = new URL("https://github.com/FeroxFoxxo/BFLearn/raw/master/BFLearn.jar"); // You will need to rebuild this and point the URL at something different!
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(appLocation);
			fos.getChannel().transferFrom(rbc, 0L, Long.MAX_VALUE);
			fos.close();
			Runtime.getRuntime().exec("java -jar " + appLocation);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {}
}
