/*
 * HexxitGear
 * Special thanks to Meldexun for helping write the majoprity of the code to fix these models with Mo' Bends!
 */

package sct.hexxitgear.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelSkullHelmet extends ModelBiped {

    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;

    public ModelSkullHelmet(float modelSize) {
        super(modelSize, 0.0F, 64, 32);

        bipedHeadwear.isHidden = true;

        bipedHead = new ModelRendererScaled(this, 0, 0, 0.009F);
        bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
        bipedHead.mirror = true;
        
        Shape1 = new ModelRendererScaled(this, 25, 0, -0.007F);
        Shape1.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape1.mirror = true;
        
        Shape2 = new ModelRendererScaled(this, 25, 5, -0.007F);
        Shape2.addBox(6F, -8F, 0F, 1, 1, 1);
        Shape2.mirror = true;
        
        Shape3 = new ModelRendererScaled(this, 25, 5, -0.007F);
        Shape3.addBox(-5F, -7F, 0F, 1, 1, 1);
        Shape3.mirror = true;

        Shape4 = new ModelRendererScaled(this, 25, 0, -0.007F);
        Shape4.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape4.mirror = true;

        bipedHead.addChild(Shape1);
        bipedHead.addChild(Shape2);
        bipedHead.addChild(Shape3);
        bipedHead.addChild(Shape4);
    }

}
