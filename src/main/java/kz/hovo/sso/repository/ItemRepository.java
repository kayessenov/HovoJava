package kz.hovo.sso.repository;

import kz.hovo.sso.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOrderByCreatedAtDesc();

    Optional<Item> findItemById(Long itemId);

}
