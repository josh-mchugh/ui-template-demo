package com.example.demo.controller.components;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class TablePage<T> extends PageImpl<T> {

    private final List<Integer> pageSizes = Lists.newArrayList(10, 20, 50);

    public TablePage(List<T> content, Pageable pageable, long count) {

        super(content, pageable, count);
    }

    public Long getCurrentOffset() {

        if(CollectionUtils.isEmpty(this.getContent())) {

            return 0L;
        }

        if(this.getContent().size() == this.getTotalElements()) {

            return this.getTotalElements();
        }

        return (long) this.getPageable().getPageNumber() * this.getPageable().getPageSize() + 1;
    }

    public Integer getNextPageNumber() {

        if(!isEmpty() && !isLast()) {

            return this.getPageable().getPageNumber() + 1;
        }

        return null;
    }

    public Integer getPrevPageNumber() {

        if(!isEmpty() && !isFirst()) {

            return this.getPageable().getPageNumber() - 1;
        }

        return null;
    }

    public String getCurrentSortValue() {

        if(this.getPageable().getSort().isSorted()) {

            return this.getPageable().getSort().stream()
                    .map(o -> String.format("%s,%s", o.getProperty(), o.getDirection().name().toLowerCase()))
                    .findFirst()
                    .get();
        }

        return null;
    }

    public SortedTableHeader getTableHeader(String columnName) {

        return new SortedTableHeader(columnName);
    }

    @Data
    public class SortedTableHeader {

        private String column;
        private String direction;
        private boolean active;
        private String sortClass;

        public SortedTableHeader(String column) {

            this.column = column;
            this.direction = initSortDirection();
            this.active = StringUtils.isNotBlank(direction);
            this.sortClass = initSortClass();
        }

        public String initSortDirection() {

            if(TablePage.this.getSort().isSorted()) {

                Sort.Order order = TablePage.this.getSort().getOrderFor(column);

                if(order != null) {
                    return order.isAscending() ? "asc" : "desc";
                }
            }

            return null;
        }

        public String initSortClass() {

            if(active) {

                return direction.equals("asc") ? "sorted ascending" : "sorted descending";
            }

            return "";
        }
    }

    public List<PaginationItem> getPaginationItems() {

        List<PaginationItem> items = new ArrayList<>();

        int firstPage  = 0;
        int lastPage = this.getTotalPages();
        int currentPage = this.getPageable().getPageNumber();
        int pageSplit = 5;

        if (lastPage >= pageSplit) {
            // Total pages > than split value, create links to split value
            int pageDiff = lastPage - currentPage;
            if (currentPage == 0) {
                // From first page to split value
                lastPage = pageSplit;
            } else if (pageDiff < pageSplit) {
                // From split value to latest page
                firstPage = currentPage - (pageSplit - pageDiff);
            } else {
                // From current page -1 to split value
                firstPage = currentPage - 1;
                lastPage = currentPage + pageSplit - 1;
            }
        }

        for (int i = firstPage; i < lastPage; i++) {

            int displayNumber = i + 1;
            boolean isActive = i == this.getPageable().getPageNumber();
            items.add(new PaginationItem(displayNumber, i, isActive));
        }

        return items;
    }

    @Data
    @AllArgsConstructor
    public class PaginationItem {

        private Integer displayNumber;
        private Integer pageNumber;
        private boolean active;
    }
}
