<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.entity;

import com.zttx.sdk.core.GenericEntity;

/**
 * ${table.sqlRemark} 实体对象
 * <p>File：${className}.java</p>
 * <p>Title: ${className}</p>
 * <p>Description:${className}</p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * @author 章旭楠
 * @version 1.0
 */
public class ${className} extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	<@generateFields/>
	
	<@generateNotPkProperties/>
}

<#macro generateFields>
<#if table.compositeId>
	private ${className}Id id;
	<#list table.columns as column>
		<#if !column.pk >
	private ${column.javaType} ${column.columnNameLower};
		</#if>
	</#list>
<#else>
	<#list table.columns as column>
	<#if !column.pk && !column.fk && column.columnNameLower != "delFlag">
	/**${column.remark}*/
	private ${column.javaType} ${column.columnNameLower};
	</#if>
	</#list>
</#if>
</#macro>

<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !column.pk && !column.fk && column.columnNameLower != "delFlag">
	public ${column.javaType} get${column.columnName}()
	{
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower})
	{
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	
		</#if>
	</#list>
</#macro>