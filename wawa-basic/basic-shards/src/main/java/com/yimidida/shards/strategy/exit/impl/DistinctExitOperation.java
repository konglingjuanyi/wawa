/*
 * @(#)DistinctExitOperation.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.exit.impl;

import java.util.List;
import java.util.Set;

import com.yimidida.shards.strategy.exit.ExitOperation;
import com.yimidida.shards.strategy.exit.ExitOperationUtils;
import com.yimidida.shards.utils.Lists;
import com.yimidida.shards.utils.Sets;

/**
 * 
 */
public class DistinctExitOperation implements ExitOperation {

	@Override
	public List<Object> apply(List<Object> results) {
		Set<Object> uniqueSet = Sets.newHashSet();
	    uniqueSet.addAll(ExitOperationUtils.getNonNullList(results));

	    List<Object> uniqueList = Lists.newArrayList(uniqueSet);
	    
	    return uniqueList;
	}

	

}
