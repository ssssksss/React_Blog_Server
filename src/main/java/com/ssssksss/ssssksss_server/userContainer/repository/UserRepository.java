package com.ssssksss.ssssksss_server.userContainer.repository;

import com.ssssksss.ssssksss_server.userContainer.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //    User테이블에서 email컬럼에 email값을 조회한다.
    Optional<User> findByEmail(String email);

}
