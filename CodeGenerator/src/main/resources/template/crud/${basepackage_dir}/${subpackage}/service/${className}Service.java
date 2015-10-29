<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;

import com.zttx.sdk.core.GenericServiceApi;
import com.zttx.sdk.exception.BusinessException;
import ${basepackage}.${subpackage}.entity.${className};

/**
 * ${table.sqlRemark} 服务接口
 * <p>File：${className}Service.java </p>
 * <p>Title: ${className}Service </p>
 * <p>Description:${className}Service </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * @author 章旭楠
 * @version 1.0
 */
public interface ${className}Service extends GenericServiceApi<${className}>{

    /**
     * 保存
     * @param ${classNameLower} 对象信息
     * @throws {@link BusinessException}
     */
    void save(${className} ${classNameLower}) throws BusinessException;
}
