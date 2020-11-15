package com.mieszkocichon.main.beans;

import com.mieszkocichon.main.enums.UserRole;

public class UserBean
{
    private String id;
    private String name;
    private String password;
    private UserRole userRole;

    public static UserBean USER(String id, String name, String password)
    {
        return new UserBean(id, name, password, UserRole.USER);
    }

    public static UserBean CREATE(String id, String name, String password, UserRole userRole)
    {
        return new UserBean(id, name, password, userRole);
    }

    private UserBean()
    {
    }

    public UserBean(String id, String name, String password, UserRole userRole)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public UserRole getRole()
    {
        return userRole;
    }
}
