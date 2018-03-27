package com.telecom.project.beans;

import java.util.List;

public class PageBean {

	private long page;//当前页码
	private long rows;//每页显示的行数
	private long index;//数据库获取数据的起始位置
	private long totalRows;//总条数
	private long totalPage;//总页数
	private List<?> datas;//具体数据
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(long page, long rows) {
		super();
		this.page = page;
		this.rows = rows;
		index = (page-1) * rows;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
		totalPage = (totalRows % rows == 0) ? (totalRows / rows) : (totalRows / rows) + 1;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getDatas() {
		return datas;
	}
	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
	
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", index=" + index + ", totalRows=" + totalRows
				+ ", totalPage=" + totalPage + ", datas=" + datas + "]";
	}
}
