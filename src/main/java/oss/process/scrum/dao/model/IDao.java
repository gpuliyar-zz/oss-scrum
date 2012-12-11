package oss.process.scrum.dao.model;

import java.util.List;

import oss.process.scrum.exception.AppException;

public interface IDao<X, Y> {
    void persist(X transientInstance) throws AppException;
    void attachDirty(X instance) throws AppException;
    void attachClean(X instance) throws AppException;
    void delete(X persistentInstance) throws AppException;
    X merge(X detachedInstance) throws AppException;
    X findById(Y id) throws AppException;
    List<X> findByExample(X instance) throws AppException;
}
