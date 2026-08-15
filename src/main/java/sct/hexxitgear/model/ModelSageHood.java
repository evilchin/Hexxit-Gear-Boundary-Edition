package sct.hexxitgear.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelSageHood extends ModelBiped {
	
	ModelRenderer head;
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ModelSageHood(float modelSize) {
		super(modelSize, 0.0F, 64, 64);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -7.5F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;

		Shape1 = new ModelRenderer(this, 0, 33);
		Shape1.addBox(-5F, -9F, -5F, 10, 9, 10);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;

		Shape2 = new ModelRenderer(this, 49, 0);
		Shape2.addBox(-3F, -9F, 5F, 6, 5, 1);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;

		Shape3 = new ModelRenderer(this, 49, 6);
		Shape3.addBox(-2F, -9F, 6F, 4, 3, 1);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}
