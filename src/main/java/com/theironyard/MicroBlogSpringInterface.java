package com.theironyard;

import org.springframework.data.repository.CrudRepository;

public interface MicroBlogSpringInterface extends CrudRepository<Message, Integer> {

}
