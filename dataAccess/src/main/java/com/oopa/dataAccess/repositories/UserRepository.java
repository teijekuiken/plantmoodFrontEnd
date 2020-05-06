package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.User;
import com.oopa.interfaces.model.IUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<IUser, Integer>  {
}
