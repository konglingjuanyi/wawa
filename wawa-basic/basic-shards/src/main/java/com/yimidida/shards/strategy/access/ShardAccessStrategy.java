/*
 * @(#)ShardAccessStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.access;

import java.util.List;

import com.yimidida.shards.Shard;
import com.yimidida.shards.ShardOperation;
import com.yimidida.shards.strategy.exit.ExitOperationsCollector;
import com.yimidida.shards.strategy.exit.ExitStrategy;


/**
 * 分区访问策略
 */
public interface ShardAccessStrategy {
	 <T> T apply(List<Shard> shards, ShardOperation<T> operation, ExitStrategy<T> exitStrategy, ExitOperationsCollector exitOperationsCollector);
}
