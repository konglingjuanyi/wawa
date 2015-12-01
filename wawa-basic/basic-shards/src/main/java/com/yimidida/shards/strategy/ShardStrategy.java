/*
 * @(#)ShardStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy;

import com.yimidida.shards.strategy.access.ShardAccessStrategy;
import com.yimidida.shards.strategy.reduce.ShardReduceStrategy;
import com.yimidida.shards.strategy.resolution.ShardResolutionStrategy;
import com.yimidida.shards.strategy.selection.ShardSelectionStrategy;

/**
 * @author Feng Kuok
 */
public interface ShardStrategy {
	
	ShardSelectionStrategy getShardSelectionStrategy();

	ShardResolutionStrategy getShardResolutionStrategy();

	ShardAccessStrategy getShardAccessStrategy();
	
	ShardReduceStrategy getShardReduceStrategy();
	
}
