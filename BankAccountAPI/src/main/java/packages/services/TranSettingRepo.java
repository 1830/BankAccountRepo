package packages.services;

import org.springframework.data.jpa.repository.JpaRepository;

import packages.models.TransactionSettings;

public interface TranSettingRepo extends JpaRepository<TransactionSettings, Long> {

}
