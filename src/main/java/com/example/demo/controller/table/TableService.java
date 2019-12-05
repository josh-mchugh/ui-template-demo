package com.example.demo.controller.table;

import com.example.demo.controller.components.PagingUtils;
import com.example.demo.controller.components.TablePage;
import com.example.demo.controller.table.model.TableFilterForm;
import com.example.demo.entity.QUserEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserStatus;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TableService {

    private final JPQLQueryFactory queryFactory;

    public TablePage<UserEntity> getUsers(TableFilterForm form, Pageable pageable) {

        QUserEntity qUserEntity = QUserEntity.userEntity;
        BooleanBuilder predicate = new BooleanBuilder();

        if(StringUtils.isNotBlank(form.getFilterQuery())) {

            BooleanBuilder namePredicate = new BooleanBuilder();

            namePredicate.or(qUserEntity.email.containsIgnoreCase(form.getFilterQuery()));
            namePredicate.or(qUserEntity.firstName.containsIgnoreCase(form.getFilterQuery()));
            namePredicate.or(qUserEntity.lastName.containsIgnoreCase(form.getFilterQuery()));
            namePredicate.or(qUserEntity.username.containsIgnoreCase(form.getFilterQuery()));

            predicate.and(namePredicate);
        }

        if(form.isActive() || form.isInactive()) {

            BooleanBuilder statusPredicate = new BooleanBuilder();

            if(form.isActive()) {
                statusPredicate.or(qUserEntity.status.eq(UserStatus.ACTIVE));
            }

            if(form.isInactive()) {
                statusPredicate.or(qUserEntity.status.eq(UserStatus.INACTIVE));
            }

            predicate.and(statusPredicate);
        }

        JPQLQuery<UserEntity> query = queryFactory.select(qUserEntity)
                .from(qUserEntity)
                .limit(pageable.getPageSize())
                .where(predicate)
                .offset(pageable.getOffset())
                .orderBy(PagingUtils.getOrder(qUserEntity,pageable.getSort()));

        List<UserEntity> items = query.fetch();
        long count = query.fetchCount();

        return new TablePage<>(items, pageable, count);
    }
}
