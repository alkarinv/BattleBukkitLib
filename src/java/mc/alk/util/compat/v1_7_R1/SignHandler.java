package mc.alk.util.compat.v1_7_R1;

import mc.alk.util.handlers.ISignHandler;
import net.minecraft.server.v1_7_R1.PacketPlayOutUpdateSign;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * For craftbukkit 1.7.2-R0.1 through 1.7.4-R0.3
 */
public class SignHandler implements ISignHandler
{

	@Override
	public void sendLines(Player player, Sign sign, String[] lines)
	{
		Location loc = sign.getLocation();
		PacketPlayOutUpdateSign packet = new PacketPlayOutUpdateSign(loc
				.getBlock().getX(), loc.getBlock().getY(), loc.getBlock()
				.getZ(), lines);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

}
