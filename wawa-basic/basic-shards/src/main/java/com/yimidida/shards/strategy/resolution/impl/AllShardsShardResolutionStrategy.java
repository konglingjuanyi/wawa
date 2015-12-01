/*
 * @(#)AllShardsShardResolutionStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.resolution.impl;

import java.util.List;

import com.yimidida.shards.ShardId;
import com.yimidida.shards.strategy.resolution.ShardResolutionStrategyData;

/**
 * 
 */
public class AllShardsShardResolutionStrategy extends BaseShardResolutionStrategy{

	public AllShardsShardResolutionStrategy(List<ShardId> shardIds) {
		super(shardIds);
	}

	@Override
	public List<ShardId> selectShardIdsFromShardResolutionStrategyData(ShardResolutionStrategyData shardResolutionStrategyData) {
		
		return super.getShardIds();
	}

}
