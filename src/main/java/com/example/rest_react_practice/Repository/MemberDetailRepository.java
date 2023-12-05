package com.example.rest_react_practice.Repository;
import com.example.rest_react_practice.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberDetailRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);
}