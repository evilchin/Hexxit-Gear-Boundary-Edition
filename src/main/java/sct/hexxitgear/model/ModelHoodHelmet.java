/*
 * HexxitGear
 * Copyright (C) 2013  Ryan Cohen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sct.hexxitgear.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelHoodHelmet extends ModelBiped {

	ModelRenderer head;
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;

	public ModelHoodHelmet(float modelSize) {
		super(modelSize, 0.0F, 64, 64);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -7.5F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		
		Shape1 = new ModelRenderer(this, 48, 0);
		Shape1.addBox(-3.5F, -8.8F, 5F, 7, 5, 1);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		
		Shape2 = new ModelRenderer(this, 48, 6);
		Shape2.addBox(-3F, -8.6F, 6F, 6, 3, 1);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		
		Shape3 = new ModelRenderer(this, 48, 11);
		Shape3.addBox(-1.333333F, -8.5F, 7F, 3, 1, 1);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		
		Shape4 = new ModelRenderer(this, 0, 33);
		Shape4.addBox(-5F, -9F, -5F, 10, 9, 10);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale + 0.02F);
	}
}
