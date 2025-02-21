package com.himanshu.TheBuzzHub.querry;

public interface QueryMetaData {

	String CREATE_USER = "Insert into adminuser(username,password,email,role) values(?,?,?,'user')";

}
