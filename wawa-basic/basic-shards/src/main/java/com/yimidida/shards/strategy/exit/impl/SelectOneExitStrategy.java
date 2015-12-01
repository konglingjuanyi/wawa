/*
 * @(#)SelectOneExitStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.exit.impl;

import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;

import com.yimidida.shards.Shard;
import com.yimidida.shards.strategy.exit.ExitOperationsCollector;
import com.yimidida.shards.strategy.exit.ExitStrategy;
import com.yimidida.shards.utils.Lists;

/**
 * 
 */
public class SelectOneExitStrategy implements ExitStrategy<Object> {

	private final List<Object> nonNullResult = Lists.newArrayList();

	@Override
	public synchronized boolean addResult(Object result, Shard shard) {
		if(result != null){
			nonNullResult.add(result);
		}
		return false;
	}

	@Override
	public Object compileResults(ExitOperationsCollector exitOperationsCollector) {
		List<Object> list = exitOperationsCollector.apply(nonNullResult);

		if (list.size() == 1) {
			return list.get(0);
		} else if (list.size() > 1) {
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
		} else {
			return null;
		}
	}

}
