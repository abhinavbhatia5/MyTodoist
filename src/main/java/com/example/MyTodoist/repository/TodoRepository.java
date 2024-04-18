package com.example.MyTodoist.repository;

import com.example.MyTodoist.models.ListItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<ListItem,Long> {

    @Query(value = "select * from my_data_source where title=?1",nativeQuery = true)
    ListItem FindByTitle(String title);
}
