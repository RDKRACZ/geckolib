package software.bernie.geckolib3.compat;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import vazkii.patchouli.client.book.gui.GuiBook;

public class PatchouliCompat {

	@SuppressWarnings("resource")
	public static void patchouliLoaded(MatrixStack matrixStackIn) {
//	    Patchouli doesnt exist on fabric 1.17 snapshots :p
		Class<GuiBook> patchouli = GuiBook.class;
		boolean screen = MinecraftClient.getInstance().inGameHud.equals(patchouli);
		if (screen) {
			matrixStackIn.push();
			VertexConsumerProvider.Immediate irendertypebuffer$impl = MinecraftClient.getInstance().getBufferBuilders()
					.getEntityVertexConsumers();
			DiffuseLighting.disableGuiDepthLighting();
			irendertypebuffer$impl.draw();
			RenderSystem.enableDepthTest();
			DiffuseLighting.enableGuiDepthLighting();
			matrixStackIn.pop();
		}
	}
}