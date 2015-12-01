/*
 * @(#)Mapper.java 2013-3-23 下午23:33:33
 *
 * Copyright (c) 2011-2013 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.mapreduce;

import com.yimidida.shards.ShardId;
import com.yimidida.shards.strategy.Strategy;

/**
 * mapper
 */
public interface Mapper extends Strategy{
	
	void map(final Object parameter, OutputCollector<ShardId> output);
	
}
