package com.himanshu.TheBuzzHub.service;

import com.himanshu.TheBuzzHub.entity.User;

public interface UserServices {

	String createUser(User user);

	Object showEmail();

	Object changePassword(String lastPaswword, String newPaswword);

}
