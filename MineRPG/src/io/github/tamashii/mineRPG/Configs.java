package io.github.tamashii.mineRPG;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public final class Configs {
	private final MineRPG plugin;
	private static final Configs INSTANCE = new Configs();
	
	private static String gameTitle;
	private static String gameWorld;
	private static boolean isUsingMySQL;
	
	private static String sqliteDBName;
	private static String mysqlHost;
	private static String mysqlDBName;
	private static String mysqlUserID;
	private static String mysqlPassword;

	public Configs() {
		plugin = MineRPG.getInstance();
	}
	
	public void load() {
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
		
		final FileConfiguration config = plugin.getConfig();

		gameTitle = config.getString("gameTitle");
		gameWorld = config.getString("gameWorld");
		isUsingMySQL = config.getString("dbtype").equalsIgnoreCase("mysql");
		
		sqliteDBName = config.getString("sqlite_db_name");
		
		mysqlHost = config.getString("mysql_host");		
		mysqlDBName = config.getString("mysql_dbname");
		mysqlUserID = config.getString("mysql_user");
		mysqlPassword = config.getString("mysql_pwd");
	}
}
