package com.buspass.studentbuspass.Controller;

import com.buspass.studentbuspass.Service.BusPassService;
import com.buspass.studentbuspass.entity.BusPassEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-passes")
public class BusPassController {

    private final BusPassService busPassService;

    public BusPassController(BusPassService busPassService) {
        this.busPassService = busPassService;
    }

    @GetMapping
    public List<BusPassEntity> getAllBusPasses() {
        return busPassService.getAllBusPasses();
    }

    @GetMapping("/{id}")
    public BusPassEntity getBusPassById(@PathVariable Long id) {
        return busPassService.getBusPassById(id);
    }

    @PostMapping
    public BusPassEntity addBusPass(@RequestBody BusPassEntity busPass) {
        return busPassService.saveBusPass(busPass);
    }

    @PutMapping("/{id}")
    public BusPassEntity updateBusPass(
            @PathVariable Long id,
            @RequestBody BusPassEntity busPass) {

        BusPassEntity existingPass =
                busPassService.getBusPassById(id);

        if (existingPass == null) {
            return null;
        }

        existingPass.setPassNumber(busPass.getPassNumber());
        existingPass.setBusRoute(busPass.getBusRoute());
        existingPass.setBoardingPoint(busPass.getBoardingPoint());
        existingPass.setDestination(busPass.getDestination());
        existingPass.setValidFrom(busPass.getValidFrom());
        existingPass.setValidUntil(busPass.getValidUntil());
        existingPass.setStatus(busPass.getStatus());
        existingPass.setStudent(busPass.getStudent());

        return busPassService.saveBusPass(existingPass);
    }

    @DeleteMapping("/{id}")
    public void deleteBusPass(@PathVariable Long id) {
        busPassService.deleteBusPass(id);
    }
}