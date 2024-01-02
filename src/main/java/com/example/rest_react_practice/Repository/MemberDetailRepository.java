package com.example.rest_react_practice.Repository;
import com.example.rest_react_practice.Entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface MemberDetailRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.username = :username")
    Optional<Member> findMemberByUsernameOpt(@Param("username")  String username);

    @Query("SELECT m FROM Member m WHERE m.username = :username")
    Member findMemberByUsername(@Param("username") String username);


    @Query("SELECT m.nickname FROM Member m WHERE m.memberId = :memberId")
    String findById(Integer memberId);
}