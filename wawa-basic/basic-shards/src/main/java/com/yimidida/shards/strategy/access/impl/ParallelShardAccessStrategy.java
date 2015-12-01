/*
 * @(#)ParallelShardAccessStrategy.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.strategy.access.impl;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yimidida.shards.Shard;
import com.yimidida.shards.ShardId;
import com.yimidida.shards.ShardOperation;
import com.yimidida.shards.strategy.access.ShardAccessStrategy;
import com.yimidida.shards.strategy.exit.ExitOperationsCollector;
import com.yimidida.shards.strategy.exit.ExitStrategy;
import com.yimidida.shards.utils.Assert;
import com.yimidida.shards.utils.Lists;

/**
 * 并行访问策略
 */
public class ParallelShardAccessStrategy implements ShardAccessStrategy{
	
	private final Log log = LogFactory.getLog(getClass());
	
	private final ThreadPoolExecutor executor;
	  
	public ParallelShardAccessStrategy(ThreadPoolExecutor executor) {
		Assert.notNull(executor);
		this.executor = executor;
	}
	
	@Override
	public <T> T apply(List<Shard> shards, ShardOperation<T> operation,
			ExitStrategy<T> exitStrategy,
			ExitOperationsCollector exitOperationsCollector) {

		List<StartAwareFutureTask> tasks = Lists.newArrayListWithCapacity(shards.size());
		
		int taskId = 0;

	    /**
	     * Used to prevent threads for processing until all tasks have been
	     * submitted, otherwise we risk tasks that want to cancel other tasks
	     * that have not yet been scheduled.
	     */
	    CountDownLatch startSignal = new CountDownLatch(1);
	    /**
	     * Used to signal this thread that all processing is complete
	     */
	    CountDownLatch doneSignal = new CountDownLatch(shards.size());
	    
	    for(final Shard shard : shards) {
	        // create a task for each shard
	    	for(final ShardId shardId : shard.getShardIds()) {
	    		ParallelShardOperationCallable<T> callable =
	    	            new ParallelShardOperationCallable<T>(
	    	                startSignal,
	    	                doneSignal,
	    	                exitStrategy,
	    	                operation,
	    	                shard,
	    	                shardId,
	    	                tasks);
	    	        // wrap the task in a StartAwareFutureTask so that the task can be cancelled
	    	        StartAwareFutureTask ft = new StartAwareFutureTask(callable, taskId++);
	    	        tasks.add(ft);
	    	        // hand the task off to the executor for execution
	    	        executor.execute(ft);
	    	}
	        
	      }
	      // the tasks List is populated, release the threads!
	      startSignal.countDown();
	      try {
	        log.debug("Waiting for threads to complete processing before proceeding.");
	        //TODO(maxr) let users customize timeout behavior
	        /*
	        if(!doneSignal.await(10, TimeUnit.SECONDS)) {
	          final String msg = "Parallel operations timed out.";
	          log.error(msg);
	          throw new HibernateException(msg);
	        }
	        */
	        // now we wait until all threads finish
	        doneSignal.await();
	      } catch (InterruptedException e) {
	        // not sure why this would happen or what we should do if it does
	        log.error("Received unexpected exception while waiting for done signal.", e);
	      }
	      log.debug("Compiling results.");
	    
		return exitStrategy.compileResults(exitOperationsCollector);
	}

}
