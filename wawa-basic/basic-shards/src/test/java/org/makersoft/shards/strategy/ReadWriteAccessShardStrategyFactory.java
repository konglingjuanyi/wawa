/*
 * @(#)ReadWriteAccessShardStrategyFactory.java 2014年3月18日 下午23:33:33
 *
 * Copyright (c) 2011-2014 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package org.makersoft.shards.strategy;

import java.util.List;

import com.yimidida.shards.ShardId;
import com.yimidida.shards.strategy.ShardStrategy;
import com.yimidida.shards.strategy.ShardStrategyFactory;
import com.yimidida.shards.strategy.selection.ShardSelectionStrategy;

/**
 * Read write access shard strategy sample.
 */
public class ReadWriteAccessShardStrategyFactory implements
		ShardStrategyFactory {

	@Override
	public ShardStrategy newShardStrategy(List<ShardId> shardIds) {
//		ShardSelectionStrategy ss =
		return null;
		
//		return new ShardStrategyImpl(shardSelectionStrategy, shardResolutionStrategy, shardAccessStrategy, shardReduceStrategy);
	}

}
