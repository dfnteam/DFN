package com.DFN.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.DFN.dao.impl.PageResults;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;


public interface IBaseDao {
    public Session getSession();


    public <T> Serializable save(T entity);


    public <T> void batchSave(List<T> entities);


    public <T> void saveOrUpdate(T entity);


    public <T> void delete(T entity); //mmbw


    public <T> void batchDelete(Collection<T> entities);


    public <T> void deleteById(Class<T> entityName, Serializable id);

    public <T> void deleteAll(final Class<T> entityName);


    public <T> void update(T entity);


    public <T> void batchUpdate(List<T> entitys);

    public int updateBySqlString(String sql);


    public <T> T load(final Class<T> entityName, Serializable id);

    public <T> List<T> loadAll(final Class<T> entityClass);


    public <T> T get(final Class<T> entityName, Serializable id);

    public <T> T getEntity(final Class<T> entityName, Serializable id);

    public <T> List<T> getAll(final Class<T> entityName);

    public <T> T getSingleByProperty(final Class<T> entityName,
                                     String propertyName, Object value);

    public <T> T getSingleByHQL(String hqlString);


    public <T> T getSingleByHQL(String hqlString, Object... values);


    public <T> T getSingleByHQL(String hqlString, Map<String, Object> values);


    public <T> T getSingleBySQL(String sqlString, final Class<T> entityName);

    public <T> T getSingleBySQL(String sqlString, final Class<T> entityName, Object... values);


    public <T> T getSingleBySQL(String sqlString, final Class<T> entityName, Map<String, Object> values);

    public <T> List<T> getListByProperty(final Class<T> entityName,
                                         String propertyName, Object value);

    public <T> List<T> getListByHQL(String hqlString);


    public <T> List<T> getListByHQL(String hqlString, Object... values);


    public <T> List<T> getListByHQL(String hqlString, Map<String, Object> values);

    public <T> List<T> getListBySQL(String sqlString, final Class<T> entityName);


    public <T> List<T> getListBySQL(String sqlString, final Class<T> entityName, Object... values);

    public <T> List<T> getListBySQL(String sqlString, final Class<T> entityName, Map<String, Object> values);


    public <T> List<T> getListbySql(final String sql);


    public <T> List<T> getByPropertyisOrder(final Class<T> entityClass,
                                            String propertyName, Object value, boolean isAsc);

    public <T> List<T> getByExample(final String entityName,
                                    final Object exampleEntity);

    public Map<Object, Object> getHashMapbyHql(String hql);


    public <T> int getCount(final Class<T> entityName);

    public Long getCountByHql(String hql, Object... values);


    public Long getCountByHql(String hql, Map<String, Object> values);

    public Long getCountForJdbc(String sql);

    public <T> PageResults<T> getPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize, Object... values);


    public <T> PageResults<T> getPageByFetchedHql(String hql, String countHql, int pageNo, int pageSize, Map<String, Object> values);

    public <T> List<T> getPageList(DetachedCriteria dc, int firstResult,
                                   int maxResult);

    public List<Map<String, Object>> findForJdbc(String sql, Object... objs);

    public List<Map<String, Object>> findForJdbc(String sql, int page, int rows);


    public Map<String, Object> findOneForJdbc(String sql, Object... objs);


    public <T> List<T> findObjForJdbc(String sql, int page, int rows,
                                      Class<T> clazz);

    public List<Map<String, Object>> findForJdbcParam(String sql, int page,
                                                      int rows, Object... objs);

    public <T> boolean contains(T entity);


    public Integer executeHql(String hqlString, Object... values);


    public Integer executeHql(String hqlString, List<Object> values);


    public Integer executeHql(String hqlString, Map<String, Object> values);

    public Integer executeSql(String sqlString, Object... values);


    public Integer executeSql(String sqlString, List<Object> values);


    public Integer executeSql(String sqlString, Map<String, Object> values);


    public Object executeSqlReturnKey(String sql, Map<String, Object> param);


    public <T> void refresh(T entity);

    public <T> List<T> executeQuery(String hql, Object[] values);
}