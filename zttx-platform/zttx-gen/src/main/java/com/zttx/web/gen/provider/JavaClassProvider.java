package com.zttx.web.gen.provider;

import com.zttx.web.gen.IModelProvider;
import com.zttx.web.gen.model.IModel;

/**
 * 实体对象实现类
 * <p>File：JavaClassProvider.java</p>
 * <p>Title: JavaClassProvider</p>
 * <p>Description:JavaClassProvider</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * 
 * @author Playguy
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class JavaClassProvider implements IModelProvider
{
	
	private Class	clazz;
	
	public JavaClassProvider(Class clazz)
	{
		super();
		this.clazz = clazz;
	}
	
	public IModel getModel()
	{
		return JavaModelHelper.getInstance().createJaveClass(clazz);
	}
	
}
