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

    ModelRenderer Shape4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelSkullHelmet(float modelSize) {
        super(modelSize, 0.0F, 64, 32);

        Shape4 = new ModelRenderer(this, 25, 0);
        Shape4.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape4.setRotationPoint(0F, 0F, 0F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        
        Shape1 = new ModelRenderer(this, 25, 0);
        Shape1.addBox(4F, -7F, 0F, 3, 2, 2);
        Shape1.setRotationPoint(0F, 0F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        
        Shape2 = new ModelRenderer(this, 25, 5);
        Shape2.addBox(6F, -8F, 0F, 1, 1, 1);
        Shape2.setRotationPoint(0F, 0F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        
        Shape3 = new ModelRenderer(this, 25, 5);
        Shape3.addBox(-5F, -7F, 0F, 1, 1, 1);
        Shape3.setRotationPoint(0F, 0F, 0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;

        bipedHead.addChild(Shape4);
        bipedHead.addChild(Shape1);
        bipedHead.addChild(Shape2);
        bipedHead.addChild(Shape3);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale + 0.003F);
    }

}
