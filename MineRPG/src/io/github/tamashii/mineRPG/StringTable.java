package io.github.tamashii.mineRPG;

import com.google.common.io.Closeables;
import com.google.common.io.Resources;

import java.io.*;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringTable {
	private static final StringTable INSTANCE = new StringTable();
	
	public static String get(String key, Object... args) {
		return INSTANCE.getFormatted(key, args);
	}
	
	public static String get(String key) {
		return INSTANCE.getFormatted(key);
	}
		
	public static void copyDefault() {
		final File file = new File(MineRPG.getInstance().getDataFolder(), "strings.properties");
		final URL url = MineRPG.getInstance().getClassLoaderBypass().getResource("strings.properties");
		if (file.exists()) {
			return;
		}
		
		FileOutputStream out = null;
		try {
			file.createNewFile();
			out = new FileOutputStream(file);
			Resources.copy(url, out);
		}
		catch(Exception ex) {
			Logger.getLogger(StringTable.class.getName()).log(Level.SEVERE, null, ex);
		}
		finally {
			Closeables.closeQuietly(out);
		}
	}
	
	private final ResourceBundle defaultStrings = ResourceBundle.getBundle("strings", Locale.getDefault(), ReloadFixLoader.getNewInstance());
	
	private String getFormatted(String key, Object... args) {
		if(defaultStrings.containsKey(key)) {
			String result = defaultStrings.getString(key);
			if(args.length != 0) {
				result = MessageFormat.format(result, args);
			}
			return result;
		}
		return "";
	}
}
