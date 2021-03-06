package mc.alk.util.compat.v1_2_5;

import mc.alk.util.handlers.ISignHandler;
import net.minecraft.server.Packet130UpdateSign;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SignHandler implements ISignHandler
{

	@Override
	public void sendLines(Player player, Sign sign, String[] lines)
	{
		Location loc = sign.getLocation();
		Packet130UpdateSign packet = new Packet130UpdateSign(loc.getBlock()
				.getX(), loc.getBlock().getY(), loc.getBlock().getZ(), lines);
		((CraftPlayer) player).getHandle().netServerHandler.sendPacket(packet);
	}
}
