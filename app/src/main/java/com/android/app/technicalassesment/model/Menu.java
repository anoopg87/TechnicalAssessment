package com.android.app.technicalassesment.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
import java.util.ArrayList;
import java.util.List;
public class Menu extends BaseObservable {

    /*
    Menu class used for sliding menu items

     */

    private String menuName;
      public Menu() {
    }
    @Bindable
    public String getMenuName() {
        return menuName;
    }
    private void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public static List<Menu> getMenuList(){
        List<Menu> menuList=new ArrayList<>();
        String[] menuItems= App.getApplicationInstance().getResources().getStringArray(R.array.menu_items);
        for (String menuItem : menuItems) {
            Menu menu = new Menu();
            menu.setMenuName(menuItem);
            menuList.add(menu);
        }
        return menuList;
    }
}
