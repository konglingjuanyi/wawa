/*
 * @(#)ExitOperationsSelectOneCollector.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.exit.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.yimidida.shards.select.SelectFactory;
import com.yimidida.shards.strategy.exit.ExitOperationsCollector;

/**
 * 
 */
@Deprecated
public class ExitOperationsSelectOneCollector implements ExitOperationsCollector {

	private final String statement;
	
	public ExitOperationsSelectOneCollector(SelectFactory selectFactory){
		this.statement = selectFactory.getStatement();
	}
	
	@Override
	public List<Object> apply(List<Object> result) {
		if(statement.endsWith("count")){
			return new RowCountExitOperation().apply(result);
		}else if(statement.endsWith("sum")){
			return new AggregateExitOperation("sum").apply(result);
		}else if(statement.endsWith("min")){
			return new AggregateExitOperation("min").apply(result);
		}else if(statement.endsWith("max")){
			return new AggregateExitOperation("max").apply(result);
		}else if(statement.endsWith("avg")){
			return new AvgResultsExitOperation().apply(result);
		}

		return result;
	}

	@Override
	public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
		
	}

}
