package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Love;

@Repository
public interface LoveRepository extends CrudRepository<Love, Long>{
}