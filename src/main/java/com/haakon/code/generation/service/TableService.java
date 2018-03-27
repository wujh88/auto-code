package com.haakon.code.generation.service;

import java.util.List;

import com.haakon.code.generation.domain.TableInfo;

public interface TableService {

	/**
	 * 根据Schema查询所有表信息
	 * @param schema
	 * @return
	 * @since 2018年3月24日上午9:44:53
	 */
	List<TableInfo> findAll(String schema);
	
	void run();
}
