/*
 * @(#)ShardedSqlSessionFactory.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.session;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactory;

import com.yimidida.shards.ShardId;
import com.yimidida.shards.id.IdGenerator;
import com.yimidida.shards.strategy.ShardStrategyFactory;

/**
 * 
 */
public interface ShardedSqlSessionFactory extends SqlSessionFactory {

	List<SqlSessionFactory> getSqlSessionFactories();

	ShardedSqlSessionFactory getSqlSessionFactory(List<ShardId> shardIds,
			ShardStrategyFactory shardStrategyFactory);

	ShardedSqlSession openSession();
	
	IdGenerator getIdGenerator();

	Map<SqlSessionFactory, Set<ShardId>> getSqlSessionFactoryShardIdMap();

}
