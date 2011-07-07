package de.Keyle.SpeechCraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

public class SpeechCraftAPI extends SpeechCraftHandler
{
	public Map<String,HashMap<String,HashMap<String,String>>> Translations  = new HashMap<String,HashMap<String,HashMap<String,String>>>();
	private Map<String,String> PlayerLanguages  = new HashMap<String,String>();
	private String defaultLanguage = "en";
	
	@Override
	public String getTranslation(String pluginname, Player player, String name)
	{
		if(Translations.keySet().contains(pluginname))
		{
			if(Translations.get(pluginname).containsKey(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage))
			{
				if(Translations.get(pluginname).get(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage).containsKey(name))
				{
					return Translations.get(pluginname).get(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage).get(name);
				}
			}
		}
		return name;
	}

	@Override
	public String getTranslation(String pluginname, Player player, String name, String defaulttxt)
	{
		if(Translations.keySet().contains(pluginname))
		{
			if(Translations.get(pluginname).containsKey(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage))
			{
				if(Translations.get(pluginname).get(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage).containsKey(name))
				{
					return Translations.get(pluginname).get(PlayerLanguages.containsKey(player.getName())?PlayerLanguages.get(player.getName()):defaultLanguage).get(name);
				}
			}
		}
		return defaulttxt;
	}

	@Override
	public List<String> getAvailabelLanguages(String pluginname, String Name)
	{
		List<String> languages = new ArrayList<String>();
		if(Translations.containsKey(pluginname))
		{
			if(Translations.get(pluginname).isEmpty() == false)
			{
				for(String lang : Translations.get(pluginname).keySet())
				{
					if(Translations.get(pluginname).get(lang).isEmpty() == false)
					{
						if(Translations.get(pluginname).get(lang).containsKey(Name))
						{
							languages.add(lang);
						}
					}
				}
			}
		}
		return languages;
	}

	@Override
	public String getPlayerLanguage(Player player)
	{
		if(PlayerLanguages.keySet().contains(player.getName()))
		{
			return PlayerLanguages.get(player.getName());
		}
		return defaultLanguage;
	}

}
