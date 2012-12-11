package oss.process.scrum.service;

import java.util.List;

import oss.process.scrum.domain.Organization;
import oss.process.scrum.exception.AppException;

public interface IOrganizationService {
    void create(Organization data) throws AppException;
    void update(Organization data) throws AppException;
    void delete(Organization data) throws AppException;
    Organization retrieveById(String id) throws AppException;
    List<Organization> retrieveByExample(Organization data) throws AppException;
    List<Organization> retrieveAll() throws AppException;
}
