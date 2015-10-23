package com.zttx.web.gen;

import com.zttx.web.gen.model.IModel;

/**
 * 提供模板数据模型
 * <p>File：IModelProvider.java</p>
 * <p>Title: IModelProvider</p>
 * <p>Description:IModelProvider</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * @author Playguy
 * @version 1.0
 */
public interface IModelProvider
{
	
	/**
	 * 得到模板的数据模型
	 * @author Playguy
	 * @return {@link IModel}
	 * @throws Exception
	 */
	public IModel getModel() throws Exception;
}
