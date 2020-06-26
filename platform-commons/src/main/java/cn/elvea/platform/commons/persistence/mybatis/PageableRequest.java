package cn.elvea.platform.commons.persistence.mybatis;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * PageableRequest
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class PageableRequest<T> implements Serializable {

    private Pageable pageable;

    private List<T> records;

    private long total;

    private boolean queryTotalCount = false;

    public PageableRequest(Pageable pageable) {
        this.pageable = pageable;
        this.queryTotalCount = false;
    }

    public PageableRequest(Pageable pageable, boolean queryTotalCount) {
        this.pageable = pageable;
        this.queryTotalCount = queryTotalCount;
    }

    public PageableRequest(Pageable pageable, List<T> records, long total) {
        this.pageable = pageable;
        this.records = records;
        this.total = total;
    }

    /**
     * 返回Spring Data的Page对象
     *
     * @return {@link Page}
     */
    public Page<T> getPage() {
        return new PageImpl<>(this.records, this.pageable, this.total);
    }

}
