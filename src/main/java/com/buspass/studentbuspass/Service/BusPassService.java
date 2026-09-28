package com.buspass.studentbuspass.Service;

import com.buspass.studentbuspass.Repository.BusPassRepository;
import com.buspass.studentbuspass.entity.BusPassEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusPassService {

    private final BusPassRepository busPassRepository;

    public BusPassService(BusPassRepository busPassRepository) {
        this.busPassRepository = busPassRepository;
    }

    public List<BusPassEntity> getAllBusPasses() {
        return busPassRepository.findAll();
    }

    public BusPassEntity getBusPassById(Long id) {
        return busPassRepository.findById(id).orElse(null);
    }

    public BusPassEntity saveBusPass(BusPassEntity busPass) {
        return busPassRepository.save(busPass);
    }

    public void deleteBusPass(Long id) {
        busPassRepository.deleteById(id);
    }
}