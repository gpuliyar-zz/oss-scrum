package oss.process.scrum.dao.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import oss.process.scrum.exception.AppException;

public abstract class AbstractDao<X, Y> {
    public abstract SessionFactory getSessionFactory();
    private Class<X> entityClass;

    public void setClazz(Class<X> entityClass) {
        this.entityClass = entityClass;
    }

    public void persist(X transientInstance) throws AppException {
        try {
            getSessionFactory().getCurrentSession().persist(transientInstance);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    public void attachDirty(X instance) throws AppException {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(instance);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    public void attachClean(X instance) throws AppException {
        try {
            getSessionFactory().getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    public void delete(X persistentInstance) throws AppException {
        try {
            getSessionFactory().getCurrentSession().delete(persistentInstance);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    @SuppressWarnings("unchecked")
    public X merge(X detachedInstance) throws AppException {
        try {
            return (X) getSessionFactory().getCurrentSession().merge(detachedInstance);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    @SuppressWarnings("unchecked")
    public X findById(Y id) throws AppException {
        try {
            return (X) getSessionFactory().getCurrentSession().get(entityClass, (Serializable) id);
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }

    @SuppressWarnings("unchecked")
    public List<X> findByExample(X instance) throws AppException {
        try {
            return (List<X>) getSessionFactory().getCurrentSession().createCriteria(entityClass).add(Example.create(instance)).list();
        } catch (RuntimeException re) {
            throw new AppException(re);
        }
    }
}