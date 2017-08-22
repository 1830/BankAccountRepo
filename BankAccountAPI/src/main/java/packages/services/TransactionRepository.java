package packages.services;

import org.springframework.data.jpa.repository.JpaRepository;

import packages.models.transactions;


public interface TransactionRepository extends JpaRepository<transactions, Long> {

	//TransactionSettings findOne(int i);

}
