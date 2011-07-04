
package de.Keyle.SpeechCraft.commands;

import de.Keyle.SpeechCraft.SpeechCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetLanguage implements CommandExecutor
{
	private final SpeechCraft plugin;

	public SetLanguage(SpeechCraft plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
        if (args.length == 1)
        {
        	sender.sendMessage("Set your language to " + args[0]);
        }
        else
        {
            return false;
        }
        return true;
    }
}
