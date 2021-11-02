package com.example.sergio3.services;


import com.example.sergio3.crud.MachineRepository;
import com.example.sergio3.model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServices {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    public Optional<Machine> getMachine(int ID){
        return machineRepository.getMachine(ID);
    }
    public Machine save(Machine machine){
        if(machine.getID() == null){
            return machineRepository.save(machine);
        }else{
            Optional<Machine>maux=machineRepository.getMachine(machine.getID());
            if(maux.isEmpty()){
                return machineRepository.save(machine);
            }else{
                return machine;
            }
        }
    }
    public Machine update(Machine machine){
        if(machine.getID()!=null){
            Optional<Machine> e=machineRepository.getMachine(machine.getID());
            if(!e.isEmpty()){
                if(machine.getNAME()!=null){
                    e.get().setNAME(machine.getNAME());
                }
                if(machine.getBRAND()!=null){
                    e.get().setBRAND(machine.getBRAND());
                }
                if(machine.getYEAR()!=null){
                    e.get().setYEAR(machine.getYEAR());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
               machineRepository.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }


    public boolean deleteMachine(int machineId) {
        Boolean aBoolean = getMachine(machineId).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

