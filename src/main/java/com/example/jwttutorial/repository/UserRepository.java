package com.example.jwttutorial.repository;


import com.example.jwttutorial.entity.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @EntityGraph(attributePaths = "authorities") // 쿼리 수행 시 Lazy 조회가 아니라 Eager조회로 authorities정보를 같이 가져오게 된다.
    Optional<Users> findOneWithAuthoritiesByUsername(String username);
}
