package tfar.cullparticles;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CullParticles.MODID)
public class CullParticles
{
    // Directly reference a log4j logger.

    public static final String MODID = "cullparticles";

    private static final Logger LOGGER = LogManager.getLogger();

    public CullParticles() {

    }
}
