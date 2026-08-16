/*
 * HexxitGear
 * Special thanks to Meldexun for helping write the majoprity of the code to fix these models with Mo' Bends!
 */
package sct.hexxitgear.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelSageHood extends ModelBiped {
	
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ModelSageHood(float modelSize) {
        super(modelSize, 0.0F, 64, 64);

        bipedHeadwear.isHidden = true;

        bipedHead = new ModelRendererScaled(this, 0, 0, 0.009F);
        bipedHead.addBox(-4F, -7.5F, -4F, 8, 8, 8);
        bipedHead.mirror = true;

        Shape1 = new ModelRendererScaled(this, 0, 33, -0.007F);
        Shape1.addBox(-5F, -9F, -5F, 10, 9, 10);
        Shape1.mirror = true;

        Shape2 = new ModelRendererScaled(this, 49, 0, -0.007F);
        Shape2.addBox(-3F, -9F, 5F, 6, 5, 1);
        Shape2.mirror = true;

        Shape3 = new ModelRendererScaled(this, 49, 6, -0.007F);
        Shape3.addBox(-2F, -9F, 6F, 4, 3, 1);
        Shape3.mirror = true;

        bipedHead.addChild(Shape1);
        bipedHead.addChild(Shape2);
        bipedHead.addChild(Shape3);
    }

}
