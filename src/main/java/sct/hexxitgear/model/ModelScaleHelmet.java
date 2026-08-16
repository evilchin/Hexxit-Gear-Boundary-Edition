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

public class ModelScaleHelmet extends ModelBiped {

	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;

	public ModelScaleHelmet(float modelSize) {
		super(modelSize, 0.0F, 64, 64);

		bipedHeadwear.isHidden = true;

		bipedHead = new ModelRendererScaled(this, 0, 0, 0.009F);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		bipedHead.mirror = true;
		
		Shape1 = new ModelRendererScaled(this, 0, 16, -0.007F);
		Shape1.addBox(-5F, -9F, -5F, 10, 9, 10);
		Shape1.mirror = true;
		
		Shape2 = new ModelRendererScaled(this, 24, 0, -0.007F);
		Shape2.addBox(-6F, -7F, -2F, 1, 5, 3);
		Shape2.mirror = true;
		
		Shape3 = new ModelRendererScaled(this, 4, 20, -0.007F);
		Shape3.addBox(-7F, -8F, 0F, 1, 4, 2);
		Shape3.mirror = true;
		
		Shape4 = new ModelRendererScaled(this, 2, 2, -0.007F);
		Shape4.addBox(-9F, -9F, 2F, 2, 1, 1);
		Shape4.mirror = true;
		
		Shape5 = new ModelRendererScaled(this, 4, 4, -0.007F);
		Shape5.addBox(-8F, -8F, 1F, 1, 3, 1);
		Shape5.mirror = true;
		
		Shape6 = new ModelRendererScaled(this, 2, 2, -0.007F);
		Shape6.addBox(-9F, -7F, 2F, 2, 1, 1);
		Shape6.mirror = true;
		
		Shape7 = new ModelRendererScaled(this, 24, 0, -0.007F);
		Shape7.addBox(5F, -7F, -2F, 1, 5, 3);
		Shape7.mirror = true;
		
		Shape8 = new ModelRendererScaled(this, 4, 20, -0.007F);
		Shape8.addBox(6F, -8F, 0F, 1, 4, 2);
		Shape8.mirror = true;
		
		Shape9 = new ModelRendererScaled(this, 4, 4, -0.007F);
		Shape9.addBox(7F, -9F, 1F, 1, 3, 1);
		Shape9.mirror = true;
		
		Shape10 = new ModelRendererScaled(this, 2, 2, -0.007F);
		Shape10.addBox(7F, -9F, 2F, 2, 1, 1);
		Shape10.mirror = true;
		
		Shape11 = new ModelRendererScaled(this, 2, 2, -0.007F);
		Shape11.addBox(7F, -7F, 2F, 2, 1, 1);
		Shape11.mirror = true;

		bipedHead.addChild(Shape1);
        bipedHead.addChild(Shape2);
        bipedHead.addChild(Shape3);
        bipedHead.addChild(Shape4);
		bipedHead.addChild(Shape5);
        bipedHead.addChild(Shape6);
        bipedHead.addChild(Shape7);
        bipedHead.addChild(Shape8);
		bipedHead.addChild(Shape9);
        bipedHead.addChild(Shape10);
        bipedHead.addChild(Shape11);
	}
	
}
