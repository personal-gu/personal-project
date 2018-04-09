package com.wakeboy.general.controller;

import com.opensymphony.xwork2.ActionSupport;

public class BaseControler extends ActionSupport{

	/**
	 * ??????
	 */
	public static final String PREFIX = ".shtml";

	public static final String SUCCESS = "success";

	// jsp ???
	public static final String FAILED = "failed";

	// app?????
	public static final String ERROR = "error";

	// ???json
	public static final String JSON_VIEW = "json/json";

	// ?????????
	public static final String JSON_SUCCESS = "{\"result\":\"success\"}";

	// ?????????
	public static final String JSON_FAILED = "{\"result\":\"failed\"}";

	// ????????
	public static final String TABLENAME = "tableName";

	// ?????apper???????????
	public static final String KEYVAL = "keyVal";

	// ????????????
	public String keyName = "id";// ??????id

	// ????????????????
	public static final String IDSVALUE = "idsVal";

	// ??????????????
	public static final String BATCHDELETE = "CommonMapper.batchDelete";

	// ?????????????
	public static final String FINDENTITYBYID = "CommonMapper.findEntityById";

	public static final String SESSIONNAME = "jafUser";


	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

}
