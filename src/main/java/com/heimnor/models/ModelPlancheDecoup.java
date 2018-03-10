package com.heimnor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlancheDecoup extends ModelBase
{
    ModelRenderer Block;

    public ModelPlancheDecoup()
    {
        this( 0.0f );
    }

    public ModelPlancheDecoup( float par1 )
    {
        Block = new ModelRenderer( this, 0, 0 );
        Block.setTextureSize( 128, 32 );
        Block.addBox( -16F, -1F, -8F, 32, 2, 16);
        Block.setRotationPoint( 0F, -8F, 0F );
    }

   public void renderAll()
   {
        Block.rotateAngleX = 0F;
        Block.rotateAngleY = 0F;
        Block.rotateAngleZ = 0F;
        Block.renderWithRotation(0.0625F);

    }

}
