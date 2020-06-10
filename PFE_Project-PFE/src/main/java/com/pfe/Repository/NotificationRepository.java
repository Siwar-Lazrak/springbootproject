package com.pfe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	Optional<Notification> save(Integer idModule);

}
