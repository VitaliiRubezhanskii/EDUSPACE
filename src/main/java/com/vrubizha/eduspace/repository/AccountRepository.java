package com.vrubizha.eduspace.repository;

import com.vrubizha.eduspace.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
