package com.theironyard;

import org.springframework.data.repository.CrudRepository;

public interface MicroBlogSpringRepo extends CrudRepository<Message, Integer> {

}
