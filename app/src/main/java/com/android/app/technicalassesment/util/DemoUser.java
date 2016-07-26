package com.android.app.technicalassesment.util;


import com.android.app.technicalassesment.model.User;
import com.android.app.technicalassesment.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class DemoUser {

    public static List<User> getUerList(){

        List<User> users=new ArrayList<>();
        User user=new User("Jordan Cric","Busy in work","http://forums.rpgmakerweb.com/uploads/profile/photo-thumb-25768.jpg",true,true);
        users.add(user);
        user=new User("Steffy Rine","Busy in cooking","http://statecrime.org/data/2014/12/profile-picture-100x100.jpeg",true,true);
        users.add(user);
        user=new User("Shine Dowan","Enjoying hollydays","https://d37nk263jfz2p8.cloudfront.net/image/2/100/100/5/uploads/profile/10660395_10202054807365257_158-5551750cdbb44.jpg",true,false);
        users.add(user);
        user=new User("Jhone Cristo","Enjoying rain","https://media.licdn.com/mpr/mpr/shrink_100_100/p/1/000/2a9/25a/2183b01.jpg",false,true);
        users.add(user);
        user=new User("Ashly Rive","Enjoying aussie life","http://www.cakebakeandsweets.com/wp-content/uploads/sites/3/2015/08/Zoe-Profile-picture310x1941-100x100.jpg",true,true);
        users.add(user);
        user=new User("Cristy Steff","Dance.. Dance.. Dance..","https://d37nk263jfz2p8.cloudfront.net/image/2/100/100/5/uploads/profile/untitled-559420ac83340.jpg",false,false);
        users.add(user);
        return users;
    }


}
