package org.fast.www.service;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * service的代理类，用来在创建之前，开启sqlSession，结束后，关闭sqlSession
 * @author minjie
 * @since 2023/05/11 21:47
 */
public class CglibProxy implements MethodInterceptor {

    // 目标类
    private final Object target;

    private final SqlSessionFactory sqlSessionFactory;

    public CglibProxy(Object target, SqlSessionFactory sqlSessionFactory) {
        this.target = target;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        SqlSession sqlSession = null;
        Object result;
        try {
            sqlSession = sqlSessionFactory.openSession();
            ((AbstractService) target).setSqlSession(sqlSession);
            result = proxy.invokeSuper(obj, args);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw e;
        } finally {
            ((AbstractService) target).closeSqlSession(sqlSession);
        }
        return result;
    }
}
