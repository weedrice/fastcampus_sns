package com.fastcampus.snsproject.service;

import com.fastcampus.snsproject.exception.SnsApplicationException;
import com.fastcampus.snsproject.model.User;
import com.fastcampus.snsproject.model.entity.UserEntity;
import com.fastcampus.snsproject.repository.UserEntityRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    // TODO: implement
    public User join(String userName, String password) {
        //회원가입하려는 userName으로 회원가입된 user가 있는지
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);

        //회원가입 진행 = user를 등록
        userEntityRepository.save(new UserEntity());

        return new User();
    }

    // TODO: implement
    public String login(String userName, String password) {
        // 회원가입 여부 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());

        // 비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }

        // 토큰 생성

        return "";
    }
}
