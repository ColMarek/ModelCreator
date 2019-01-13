package com.mrcrayfish.modelcreator.util;

import java.io.File;

/**
 * Author: MrCrayfish
 */
public class AssetsUtil
{
    public static boolean isImageInAssetPath(File file)
    {
        File previous = null;
        File parent = file;
        while((parent = parent.getParentFile()) != null)
        {
            if(parent.getName().equals("textures"))
            {
                break;
            }
            previous = parent;
        }
        return false;
    }

    public static String getTexturePath(File file)
    {
        StringBuilder builder = new StringBuilder();
        File parent = file;
        while((parent = parent.getParentFile()) != null)
        {
            if(!parent.getName().equals("textures"))
            {
                builder.insert(0, parent.getName()).insert(0, "/");
                continue;
            }
            break;
        }
        return builder.length() > 0 ? builder.substring(1, builder.length()) : "";
    }

    public static String getModId(File file)
    {
        File previous = null;
        File parent = file;
        while((parent = parent.getParentFile()) != null)
        {
            if(parent.getName().equals("assets"))
            {
                break;
            }
            previous = parent;
        }
        return previous != null ? previous.getName() : "minecraft";
    }
}