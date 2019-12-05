package com.example.demo.controller.components;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class PagingUtils {

    public static OrderSpecifier[] getOrder(EntityPathBase entityPathBase, Sort sort) {

        List<OrderSpecifier> orderSpecifiers = new ArrayList<>();

        if(sort.isSorted()) {

            for (Sort.Order o : sort) {

                PathBuilder orderByExpression = new PathBuilder(entityPathBase.getType(), entityPathBase.getMetadata());

                OrderSpecifier order = new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, orderByExpression.get(o.getProperty()));
                orderSpecifiers.add(order);
            }
        }

        return orderSpecifiers.toArray(new OrderSpecifier[0]);
    }
}
