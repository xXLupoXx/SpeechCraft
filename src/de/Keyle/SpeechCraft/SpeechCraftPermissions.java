/*
* Copyright (C) 2011 Keyle & xXLupoXx
*
* This file is part of SpeechCraft.
*
* SpeechCraft is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* SpeechCraft is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with SpeechCraft. If not, see <http://www.gnu.org/licenses/>.
*/

package de.Keyle.SpeechCraft;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import org.anjocaido.groupmanager.GroupManager;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

import de.Keyle.SpeechCraft.SpeechCraft;

public class SpeechCraftPermissions
{
	private Object Permissions;
	private SpeechCraft Plugin;
	private PermissionsType PermissionsMode = PermissionsType.NONE;

	public SpeechCraftPermissions(SpeechCraft Plugin)
	{
		this.Plugin = Plugin;
	}
	
	public static enum PermissionsType
	{
		NONE, GroupManager, Permissions;
	}

	public boolean has(Player player, String node)
	{
		if (PermissionsMode == PermissionsType.NONE || Permissions == null || player == null)
		{
			return true;
		}
		else if (PermissionsMode == PermissionsType.Permissions && Permissions instanceof PermissionHandler)
		{
			return ((PermissionHandler) Permissions).has(player, node);
		}
		else if (PermissionsMode == PermissionsType.GroupManager && Permissions instanceof GroupManager)
		{
			return ((GroupManager) Permissions).getWorldsHolder().getWorldPermissions(player).has(player, node);
		}
		return false;
	}

	public boolean setup()
	{
		Plugin p;
		p = Plugin.getServer().getPluginManager().getPlugin("GroupManager");
		if (p != null && PermissionsMode == PermissionsType.NONE)
		{
			PermissionsMode = PermissionsType.GroupManager;
			Permissions = (GroupManager) p;
			return true;
		}

		p = Plugin.getServer().getPluginManager().getPlugin("Permissions");
		if (p != null && PermissionsMode == PermissionsType.NONE)
		{
			PermissionsMode = PermissionsType.Permissions;
			Permissions = ((Permissions) p).getHandler();
			return true;
		}
		return false;
	}
}
