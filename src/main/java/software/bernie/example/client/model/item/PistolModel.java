package software.bernie.example.client.model.item;

import net.minecraft.util.Identifier;
import software.bernie.example.item.PistolItem;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PistolModel extends AnimatedGeoModel<PistolItem> {
	@Override
	public Identifier getModelLocation(PistolItem object) {
		return new Identifier(GeckoLib.ModID, "geo/pistol.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PistolItem object) {
		return new Identifier(GeckoLib.ModID, "textures/item/pistol.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PistolItem animatable) {
		return new Identifier(GeckoLib.ModID, "animations/pistol.animation.json");
	}
}
