package ua.pp.shop.repos;

import org.springframework.data.repository.CrudRepository;
import ua.pp.shop.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Integer> {
}
