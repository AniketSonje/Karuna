package com.karuna.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.dto.ItemDto;
import com.karuna.entity.Donor;
import com.karuna.entity.Item;
import com.karuna.entity.Receiver;

public interface ItemRepo extends JpaRepository<Item, Long> {

	Item save(ItemDto newItem);

	

	List<Item> findAllByDonorId(Long donorId);



	List<Item> findAllByReceiverId(Long receiverId);



	List<Item> findAllByStatus(Boolean status);



	List<Item> findAllByDonorId(Donor orElseThrow);



	List<Item> findAllByStatusIsNullOrStatusFalse();



	List<Item> findAllByReceiverId(Receiver orElseThrow);



	List<Item> findAllByReceiverIdIn(List<Long> receiverIds);

}
