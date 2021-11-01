package fr.mpgensai.common.service;

import org.springframework.data.domain.Page;

public interface IRawService<T> extends IOperations<T> {

    // Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);

    // Page<T> findAllPaginatedRaw(final int page, final int size);

}
