package com.pinyu.miniprogram.mysql.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.IfSqlNode;
import org.apache.ibatis.scripting.xmltags.MixedSqlNode;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

public class BaseMapperProvider extends MapperTemplate {

	public BaseMapperProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	public SqlNode selectPage(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);

		List<SqlNode> sqlNodes = new ArrayList<SqlNode>();
		// 静态的sql部分:select column ... from table
		sqlNodes.add(new StaticTextSqlNode(
				"SELECT " + EntityHelper.getSelectColumns(entityClass) + " FROM " + tableName(entityClass)));
		// 获取全部列
		Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);

		List<SqlNode> ifNodes = new ArrayList<SqlNode>();
		boolean first = true;
		// 对所有列循环，生成<if test="property!=null">[AND] column = #{property}</if>
		for (EntityColumn column : columns) {
			StaticTextSqlNode columnNode = new StaticTextSqlNode(
					(first ? "" : " AND ") + column.getColumn() + " = #{entity." + column.getProperty() + "} ");
			if (column.getJavaType().equals(String.class)) {
				ifNodes.add(new IfSqlNode(columnNode, "entity." + column.getProperty() + " != null and " + "entity."
						+ column.getProperty() + " != '' "));
			} else {
				ifNodes.add(new IfSqlNode(columnNode, "entity." + column.getProperty() + " != null "));
			}
			first = false;
		}
		// 将if添加到<where>
		sqlNodes.add(new WhereSqlNode(ms.getConfiguration(), new MixedSqlNode(ifNodes)));
		// 处理分页
		sqlNodes.add(new IfSqlNode(new StaticTextSqlNode(" LIMIT #{pageSize}"), "index==0"));
		sqlNodes.add(new IfSqlNode(new StaticTextSqlNode(" LIMIT #{pageSize} OFFSET #{index} "), "index>0"));
		return new MixedSqlNode(sqlNodes);
	}

}
