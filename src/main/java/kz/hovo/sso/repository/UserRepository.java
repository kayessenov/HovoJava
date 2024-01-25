package kz.hovo.sso.repository;

import kz.hovo.sso.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Optional<Users> findUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Optional<Users> findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM Users u WHERE u.id = :id")
    Optional<Users> findUserById(@Param("id") Long id);
}
