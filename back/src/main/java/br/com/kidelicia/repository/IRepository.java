package br.com.kidelicia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kidelicia.domain.DomainEntity;

public interface IRepository<entity extends DomainEntity> extends JpaRepository<entity, Long> { 

}
