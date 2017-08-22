package packages.services;

import org.springframework.data.jpa.repository.JpaRepository;

import packages.models.account;

public interface AccountRepository extends JpaRepository<account, Long>  {

}
