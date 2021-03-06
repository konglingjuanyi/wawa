/*
 * @(#)ShardSelect.java 2012-8-1 下午10:00:00
 *
 * Copyright (c) 2011-2012 Makersoft.org all rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 */
package com.yimidida.shards.select;

import java.util.List;
import java.util.Map;

/**
 * 
 */
public interface ShardSelect {

	<E> List<E> getResultList();
	
	<K, V> Map<K, V> getResultMap();
	
	<T> T getSingleResult(); 
}
