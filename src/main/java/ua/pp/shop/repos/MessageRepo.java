package ua.pp.shop.repos;

import org.springframework.data.repository.CrudRepository;
import ua.pp.shop.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
   List<Message> findByType(String type);
}
