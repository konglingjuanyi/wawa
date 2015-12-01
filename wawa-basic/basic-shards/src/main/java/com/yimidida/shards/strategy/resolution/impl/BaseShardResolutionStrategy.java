/*
 * @(#)BaseShardResolutionStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.resolution.impl;

import java.util.List;

import com.yimidida.shards.BaseHasShardIdList;
import com.yimidida.shards.ShardId;
import com.yimidida.shards.strategy.resolution.ShardResolutionStrategy;

/**
 * 
 */
public abstract class BaseShardResolutionStrategy extends BaseHasShardIdList
		implements ShardResolutionStrategy {

	public BaseShardResolutionStrategy(List<ShardId> shardIds) {
		super(shardIds);
	}
	
}