package com.custom.storage.user;

public class UserStoreQueries {
	// User retrieval queries

	public final static String GET_USER_BY_ID =
			"select userName,email,passWord,firstName,lastName from UserStore where id = ?1";

	public final static String GET_USER_BY_NAME =
			"select userName,email,passWord,firstName,lastName from UserStore where userName = ?1";

	public final static String GET_ALL_USERS =
			"select userName,email,passWord,firstName,lastName from UserStore";

	public final static String GET_USER_COUNT = "select count(userName) from UserStore";

	public final static String SEARCH_USER_BY_NAME =
			"select userName,email,passWord,firstName,lastName from UserStore where userName like ?1";

	// User authentication queries
	public final static String AUTH_USER_PASS =
			"select u.userName, u.passWord from UserStore u where u.passWord=?1 and u.userName=?2";


}
