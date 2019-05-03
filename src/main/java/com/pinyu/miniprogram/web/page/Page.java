package com.pinyu.miniprogram.web.page;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

public class Page<T extends BaseEntity> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8190433874844778460L;

	private static final Integer PAGE_SIZE = 10;
	
	private static final Integer MAX_PAGE_SIZE = 200;//最大200条一页，超过200条默认为10

	private String keyword;// 关键字查询

	private Date startDate;// 开始时间

	private Date endDate;// 结束时间

	private T entity;// 条件查询

	private Integer index;// 起始位置

	private Integer end;// 结束位置

	private Integer pageCount;// 总页数

	private Integer currentPage;// 当前页

	private Integer pageSize = PAGE_SIZE;// 每页条数

	private List<T> result;// 分页数据

	private Integer totalCount;// 总条数

	public Page() {
		super();
	}

	public Page(Integer pageCount, Integer currentPage, Integer pageSize, List<T> result, Integer totalCount) {
		super();
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.result = result;
		this.totalCount = totalCount;
	}

	public Page(String keyword, T entity, Integer index, Integer end, Integer pageCount, Integer currentPage,
			Integer pageSize, List<T> result, Integer totalCount) {
		super();
		this.keyword = keyword;
		this.entity = entity;
		this.index = index;
		this.end = end;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.result = result;
		this.totalCount = totalCount;
	}

	public Page(List<T> result, Integer totalCount, Integer currentPage) {
		if (totalCount % PAGE_SIZE != 0) {
			this.pageCount = totalCount / PAGE_SIZE + 1;
		} else {
			this.pageCount = totalCount / PAGE_SIZE;
		}
		if(this.pageCount==0){
			this.pageCount=1;
		}
		this.result = result;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if (currentPage != null) {
			this.index = (currentPage - 1) * pageSize;
		}
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize>MAX_PAGE_SIZE){
			pageSize=PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
