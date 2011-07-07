package de.Keyle.SpeechCraft;

import java.util.List;

import org.bukkit.entity.Player;

public abstract class SpeechCraftHandler
{
	public abstract String getTranslation(String pluginname, Player player, String name);
	public abstract String getTranslation(String pluginname, Player player, String name, String defaulttxt);
	
	public abstract List<String> getAvailabelLanguages(String pluginname, String Name);
	public abstract String getPlayerLanguage(Player player);
}