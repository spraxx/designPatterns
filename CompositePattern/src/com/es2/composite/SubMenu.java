package com.es2.composite;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class SubMenu extends Menu{
    private final ArrayList<Menu> SubMenus = new ArrayList<Menu>();
    public SubMenu()
    {

    }
    public void addChild(Menu child)
    {
        SubMenus.add(child);



    }
    public void removeChild(Menu child)
    {
        SubMenus.remove(child);

    }
    public void showOptions()
    {
        System.out.println(getLabel());

        for (Menu SubMenus : SubMenus)
        {
            SubMenus.showOptions();
        }
    }

}
