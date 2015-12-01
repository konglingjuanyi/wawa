/*
 * @(#)MySqlDialect.java 2012-8-17 下午2:54:51
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.plugin.spi.internal;

import com.yimidida.shards.plugin.spi.Dialect;

/**
 * MySQL数据库分页方言.
 * 
 * @version 2012-8-17 下午2:54:51
 * @author Feng Kuok
 */
public class MySQLDialect implements Dialect {

	@Override
	public boolean supportLimit() {
		return true;
	}

	@Override
	public boolean supportOffsetLimit() {
		return true;
	}

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 40).append(sql);
		if (offset > 0) {
			return pagingSelect.append(" limit ").append(offset).append(", ").append(limit).toString();
		} else {
			return pagingSelect.append(" limit ").append(limit).toString();
		}
	}

}
