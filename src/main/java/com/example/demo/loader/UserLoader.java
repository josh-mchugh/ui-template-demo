package com.example.demo.loader;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserStatus;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Transactional
@RequiredArgsConstructor
public class UserLoader implements ApplicationRunner {

    private final EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Faker faker = new Faker(new Random());

        LocalDateTime minLocalDT = LocalDateTime.now().minusWeeks(1);
        LocalDateTime maxLocalDT = LocalDateTime.now();

        Date minDate = Date.from(minLocalDT.atZone(ZoneId.systemDefault()).toInstant());
        Date maxDate = Date.from(maxLocalDT.atZone(ZoneId.systemDefault()).toInstant());
        
        for(int i = 0; i < ThreadLocalRandom.current().nextInt(200, 300); i++) {

            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(faker.name().firstName());
            userEntity.setMiddleName(faker.name().name());
            userEntity.setLastName(faker.name().lastName());
            userEntity.setEmail(faker.internet().emailAddress());
            userEntity.setUsername(faker.name().username());
            userEntity.setPassword(faker.internet().password());

            Date lastLoginDate = faker.date().between(minDate, maxDate);
            LocalDateTime lastLoginDT = Instant.ofEpochMilli(lastLoginDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            userEntity.setLastLogin(lastLoginDT);

            UserStatus userStatus = lastLoginDT.isBefore(maxLocalDT.minusDays(4))
                    ? UserStatus.INACTIVE
                    : UserStatus.ACTIVE;
            userEntity.setStatus(userStatus);

            entityManager.persist(userEntity);
        }
    }
}
