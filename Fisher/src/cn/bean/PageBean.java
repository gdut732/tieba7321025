package cn.bean;

import java.util.List;

public class PageBean<T>
{
	private int pageIndex;
	private int rowcount;
	private int pageSize;
	private int pageCount;
	private List<T> list;
	
	public PageBean()
	{
	}
	public PageBean(int rowcount, int pageSize)
	{
		this.rowcount = rowcount;
		this.pageSize = pageSize;
		setPageCount();
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getRowcount()
	{
		return rowcount;
	}
	public void setRowcount(int rowcount)
	{
		this.rowcount = rowcount;
		setPageCount();
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
		setPageCount();
	}
	public int getPageCount()
	{
		return pageCount;
	}
	public void setPageCount()
	{
		this.pageCount =this.rowcount%this.pageSize==0?this.rowcount/this.pageSize:(this.rowcount/this.pageSize)+1;
	}
	public List<T> getList()
	{
		return list;
	}
	public void setList(List<T> list)
	{
		this.list = list;
	}
	
}
