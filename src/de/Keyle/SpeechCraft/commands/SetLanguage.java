
package com.dinnerbone.bukkit.scrap.commands;

import com.dinnerbone.bukkit.scrap.ScrapBukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearPluginCommand implements CommandExecutor
{
	private final SpeechCraft plugin;

	public ClearPluginCommand(SpeechCraft plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
        if (args.length == 1)
        {
        	sender.sendMessage("Set your language to " + args[0]));
        }
        else
        {
            return false;
        }
        return true;
    }
}
