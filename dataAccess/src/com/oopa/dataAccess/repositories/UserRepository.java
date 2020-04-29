package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>  {
}
