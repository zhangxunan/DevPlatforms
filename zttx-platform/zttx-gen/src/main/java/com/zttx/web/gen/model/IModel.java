package com.zttx.web.gen.model;

import java.util.Map;

/**
 * 模板数据模型
 * <p>File：IModel.java</p>
 * <p>Title: IModel</p>
 * <p>Description:IModel</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * 
 * @author Playguy
 * @version 1.0
 */
public interface IModel
{
	
	/**
	 * 获取描述信息
	 * 
	 * @author Playguy
	 * @return
	 */
	public String getDisplayDescription();
	
	/**
	 * 为模板路径提供数据
	 * 
	 * @author Playguy
	 * @param fileModel
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void mergeFilePathModel(Map fileModel) throws Exception;
	
	/**
	 * 获取模型名称
	 * 
	 * @author Playguy
	 * @return
	 */
	public String getTemplateModelName();
	
}
