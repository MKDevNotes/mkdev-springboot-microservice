package com.mkdev.rest.v1.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdev.rest.v1.example.model.DnUser;

/**
 * @author Muthukumar Thangavinayagam
 * 
 * @date 2020-May-02 5:52:18 pm 
 */
@Repository
public interface DnUserRepository extends JpaRepository<DnUser, Long> {

}
