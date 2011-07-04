
package de.Keyle.SpeechCraft;

import de.Keyle.SpeechCraft.commands.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Language API
 * 
 * @author Keyle & xXLupoXx
 */

public class SpeechCraft extends JavaPlugin
{

	public void onDisable()
	{
	}

	public void onEnable()
	{       
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( "["pdfFile.getName() + "] version " + pdfFile.getVersion() + " is enabled!" );

        getCommand("lang").setExecutor(new SetLanguage(this));
    }
}
