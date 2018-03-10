package com.heimnor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCasserole extends ModelBase
{
    ModelRenderer Liquide;
    ModelRenderer cote4;
    ModelRenderer cote1;
    ModelRenderer cote2;
    ModelRenderer cote3;
    ModelRenderer Manche;

    public ModelCasserole()
    {
        this( 0.0f );
    }

    public ModelCasserole( float par1 )
    {
        Liquide = new ModelRenderer( this, -13, 0 );
        Liquide.setTextureSize( 64, 32 );
        Liquide.addBox( -6.5F, 0F, -6.5F, 13, 0, 13);
        Liquide.setRotationPoint( -1.976435E-07F, -27.99999F, 0.2504384F );
        cote4 = new ModelRenderer( this, 26, 0 );
        cote4.setTextureSize( 64, 32 );
        cote4.addBox( 0F, -3.5F, -6.5F, 0, 7, 13);
        cote4.setRotationPoint( 4.264384F, -26.99999F, 5.156051F );
        cote1 = new ModelRenderer( this, 0, 0 );
        cote1.setTextureSize( 64, 32 );
        cote1.addBox( 0F, -3.5F, -6.5F, 0, 7, 13);
        cote1.setRotationPoint( 4.905612F, -26.99999F, -4.013946F );
        cote2 = new ModelRenderer( this, 0, 0 );
        cote2.setTextureSize( 64, 32 );
        cote2.addBox( 0F, -3.5F, -6.5F, 0, 7, 13);
        cote2.setRotationPoint( -4.264384F, -26.99999F, -4.655174F );
        cote3 = new ModelRenderer( this, 13, 0 );
        cote3.setTextureSize( 64, 32 );
        cote3.addBox( 0F, -3.5F, -6.5F, 0, 7, 13);
        cote3.setRotationPoint( -4.905612F, -26.99999F, 4.514822F );
        Manche = new ModelRenderer( this, 39, 0 );
        Manche.setTextureSize( 64, 32 );
        Manche.addBox( -1F, -1F, -5F, 2, 2, 10);
        Manche.setRotationPoint( -7.574868F, -27.99999F, -8.40248F );
    }

   public void renderAll()
   {
        Liquide.rotateAngleX = 0F;
        Liquide.rotateAngleY = 0.7155851F;
        Liquide.rotateAngleZ = 0F;
        Liquide.renderWithRotation(0.0625F);

        cote4.rotateAngleX = 0F;
        cote4.rotateAngleY = -0.8552114F;
        cote4.rotateAngleZ = 0F;
        cote4.renderWithRotation(0.0625F);

        cote1.rotateAngleX = 0F;
        cote1.rotateAngleY = 0.7155851F;
        cote1.rotateAngleZ = 0F;
        cote1.renderWithRotation(0.0625F);

        cote2.rotateAngleX = 0F;
        cote2.rotateAngleY = -0.8552114F;
        cote2.rotateAngleZ = 0F;
        cote2.renderWithRotation(0.0625F);

        cote3.rotateAngleX = 0F;
        cote3.rotateAngleY = 0.7155851F;
        cote3.rotateAngleZ = 0F;
        cote3.renderWithRotation(0.0625F);

        Manche.rotateAngleX = 0F;
        Manche.rotateAngleY = 0.7155851F;
        Manche.rotateAngleZ = 0F;
        Manche.renderWithRotation(0.0625F);

    }

}
