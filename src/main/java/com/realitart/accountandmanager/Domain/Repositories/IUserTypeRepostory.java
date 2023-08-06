package com.realitart.accountandmanager.Domain.Repositories;

import com.realitart.accountandmanager.Domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTypeRepostory extends JpaRepository<UserType, Long> {
}
