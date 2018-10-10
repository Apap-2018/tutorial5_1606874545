package com.apap.tutorial5.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial5.model.DealerModel;
import com.apap.tutorial5.repository.DealerDb;

public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	void addDealer (DealerModel dealer);
	/*void deleteDealer (DealerModel dealer);*/
	DealerDb allDealer();
	void deleteDealer(DealerModel dealer);
	void updateDealer(DealerModel updateDealer, Long dealerId);
	
	
}
