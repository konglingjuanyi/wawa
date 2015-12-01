/*
 * @(#)ShardedSqlSessionFactoryBuilder.java 2012-8-8 下午6:52:50
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.session.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yimidida.shards.ShardedConfiguration;
import com.yimidida.shards.cfg.ShardConfiguration;
import com.yimidida.shards.id.IdGenerator;
import com.yimidida.shards.session.ShardedSqlSessionFactory;
import com.yimidida.shards.strategy.ShardStrategyFactory;

/**
 * 类似于Mybaits原生SqlSessionFactoryBuilder.
 * 
 * @version 2012-8-8 下午6:52:50
 * @author Feng Kuok
 * 
 * @see SqlSessionFactoryBuilder
 */
public class ShardedSqlSessionFactoryBuilder {
	
	public ShardedSqlSessionFactory build(List<ShardConfiguration> shardConfigs, ShardStrategyFactory shardStrategyFactory) {
		ShardedConfiguration configuration = new ShardedConfiguration(shardConfigs, shardStrategyFactory, null);
		return configuration.buildShardedSessionFactory();
	}

	public ShardedSqlSessionFactory build(List<ShardConfiguration> shardConfigs, ShardStrategyFactory shardStrategyFactory, IdGenerator idGenerator) {
		ShardedConfiguration configuration = new ShardedConfiguration(shardConfigs, shardStrategyFactory, idGenerator);
		return configuration.buildShardedSessionFactory();
	}

}
